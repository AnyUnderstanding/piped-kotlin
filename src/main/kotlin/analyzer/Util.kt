package de.any.analyzer

import de.any.Cause
import de.any.PipedException

fun validateTupleType(context: PipedParser.TupleTypeContext): Type {
    context.ID().forEach {
        if (TypeTable.findType(it.text) == null) {
            throw PipedException(Cause.UNKNOWN_TYPE, context.start)
        }
    }
    return Type(context.text)
}

fun deconstructTuple(tuple: Type): List<Type> {
    if (tuple.name.first() != '(' || tuple.name.last() != ')') {
        return listOf(tuple)
    }
    val types = tuple.name.substring(1, tuple.name.length - 1).split(",")
    return types.map { Type(it.trim()) }
}

fun parseArgs(ctx: PipedParser.ArgumentsDefinitionContext): List<Parameter> {
    return   ctx.text.split(",").filter { it != "" }.map {
        val split = it.split(":")
        val name = split[0].trim()
        val typeName = split[1].trim()
        val type = TypeTable.findType(typeName)
            ?: // TODO: get the correct token
            throw PipedException(Cause.UNKNOWN_TYPE, ctx.start)
        Parameter(name, type)
    }
}