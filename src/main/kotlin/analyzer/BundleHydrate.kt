package de.any.analyzer

import PipedBaseVisitor
import de.any.Cause
import de.any.PipedException

class BundleHydrate : PipedBaseVisitor<Unit>() {
    override fun visitBundleDefinition(ctx: PipedParser.BundleDefinitionContext?) {
        val names = ctx!!.typedName().map { it.name }
        val typeNames = ctx.typedName().map { it.type }
        val isMutable = ctx.ValueDefinition().map { it.text == "var" }

        val types = typeNames.map {
            if (TypeTable.findType(it.text) == null) {
                throw PipedException(Cause.UNKNOWN_TYPE, ctx.start)
            }
            TypeTable.findType(it.text)!!
        }
        val fields = mutableListOf<Field>()
        names.zip(types).zip(isMutable).map {
            fields.add(
                Field(it.first.first.text, it.first.second, it.second)
            )
        }
        val bundle = TypeTable.findType(ctx.name.text)!! as Bundle
        bundle.fields = fields
    }

    override fun visitPipeDefinition(ctx: PipedParser.PipeDefinitionContext?) {
        val parameters = parseArgs(ctx!!.args)
        if (ctx.returnType.tupleType() != null) {
            validateTupleType(ctx.returnType.tupleType())
        } else {
            if (TypeTable.findType(ctx.returnType.text) == null) {
                throw PipedException(Cause.UNKNOWN_TYPE, ctx.start)
            }
        }
        PipeTable.findPipe(ctx.name.text)!!.parameters = parameters

    }
}