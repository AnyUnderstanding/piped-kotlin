package de.any.analyzer

import PipedBaseVisitor
import de.any.Cause
import de.any.PipedException

class TypeChecker : PipedBaseVisitor<Type>() {
    var currentScope = Scope()
    var previousReturn: Type = PrimitiveType.VOID.type
    var parameters = listOf<Field>()

    override fun visitLocalScope(ctx: PipedParser.LocalScopeContext?): Type {
        currentScope = currentScope.addScope()

        parameters.forEach() {
            currentScope.addVariable(it)
        }
        parameters = listOf()

        visitChildren(ctx)
        val returnType: Type = ctx!!.return_().map { visit(it) }.reduceOrNull() { type, acc ->
            if (type != acc) {
                throw PipedException(Cause.TYPE_MISMATCH, ctx.start)
            }
            type
        } ?: PrimitiveType.VOID.type

        currentScope.returnType = returnType
        currentScope = currentScope.bubbleUp()


        return returnType
    }

    override fun visitReturn(ctx: PipedParser.ReturnContext?): Type {
        return visit(ctx!!.expression())
    }

    override fun visitVar(ctx: PipedParser.VarContext?): Type {
        val path = ctx!!.text.split(".")
        val variable = currentScope.findVariable(path.first()) ?: throw PipedException(Cause.UNKNOWN_TYPE, ctx.start)
        var type = variable.type
        currentScope.addReferencedVariable(variable)

        for (i in 1 until path.size) {
            type = type.getField(path[i])?.type ?: throw PipedException(Cause.UNKNOWN_TYPE, ctx.start)
        }
        return type
    }


    override fun visitPipeDefinition(ctx: PipedParser.PipeDefinitionContext?): Type {
        val pipe = PipeTable.findPipe(ctx!!.name.text) ?: throw PipedException(Cause.UNKNOWN_PIPE, ctx.start)
        val returnType = pipe.returnType

        parameters = pipe.parameters.map(Parameter::toField)

        val scopeReturn = visit(ctx.localScope())
        if (returnType != scopeReturn) {
            throw PipedException(Cause.TYPE_MISMATCH, ctx.start)
        }
        return PrimitiveType.VOID.type
    }

    override fun visitReassign(ctx: PipedParser.ReassignContext?): Type {
        val right = visit(ctx!!.right)
        val variable = currentScope.findVariable(ctx.name.text) ?: throw PipedException(Cause.UNKNOWN_TYPE, ctx.start)
        if (variable.type != right) {
            throw PipedException(Cause.TYPE_MISMATCH, ctx.start)
        }
        if (!variable.isMutable) {
            throw PipedException(Cause.IMMUTABLE_MUTATION, ctx.start)
        }

        return PrimitiveType.VOID.type
    }


    override fun visitMulDiv(ctx: PipedParser.MulDivContext?): Type {
        val left = visit(ctx!!.left)
        val right = visit(ctx.right)
        if (left != PrimitiveType.INT.type || right != PrimitiveType.INT.type) {
            throw PipedException(Cause.TYPE_MISMATCH, ctx.start)
        }
        return PrimitiveType.INT.type
    }

    override fun visitTupleType(ctx: PipedParser.TupleTypeContext?): Type {
        return validateTupleType(ctx!!)
    }

    override fun visitTuple(ctx: PipedParser.TupleContext?): Type {
        val types = ctx!!.expression().map { visit(it) }
        val typeName = "(" + types.map { it.name }.joinTo(StringBuilder(), ",") + ")"
        return Type(typeName)
    }

    override fun visitAddSub(ctx: PipedParser.AddSubContext?): Type {
        val left = visit(ctx!!.left)
        val right = visit(ctx.right)
        if (left != PrimitiveType.INT.type || right != PrimitiveType.INT.type) {
            throw PipedException(Cause.TYPE_MISMATCH, ctx.start)
        }
        return PrimitiveType.INT.type
    }

    override fun visitAssign(ctx: PipedParser.AssignContext?): Type {
        val right = visit(ctx!!.right)
        val left = visit(ctx.typedName())
        if (left != right) {
            throw PipedException(Cause.TYPE_MISMATCH, ctx.start)
        }
        val isMutable = ctx.ValueDefinition().text == "var"
        val name = ctx.typedName().name.text.split(":").first().trim()
        currentScope.addVariable(Field(name, left, isMutable))
        return PrimitiveType.VOID.type
    }

    override fun visitTypedName(ctx: PipedParser.TypedNameContext?): Type {
        return visit(ctx!!.typeName())
    }

    override fun visitTypeName(ctx: PipedParser.TypeNameContext?): Type {
        return TypeTable.findType(ctx!!.text) ?: visit(ctx.tupleType())
    }

    override fun visitBOOL_OP(ctx: PipedParser.BOOL_OPContext?): Type {
        val left = visit(ctx!!.left)
        val right = visit(ctx.right)
        if (left != right) {
            throw PipedException(Cause.TYPE_MISMATCH, ctx.start)
        }
        return PrimitiveType.BOOLEAN.type
    }

    override fun visitValue(ctx: PipedParser.ValueContext?): Type {
        if (ctx?.STRING_() != null) {
            return PrimitiveType.STRING.type
        }
        if (ctx?.INT() != null) {
            return PrimitiveType.INT.type
        }
        if (ctx?.BOOLEAN() != null) {
            return PrimitiveType.BOOLEAN.type
        }
        throw IllegalStateException("The value is unknown, this is most likely a bug in the compiler")
    }

    override fun visitPipeline(ctx: PipedParser.PipelineContext?): Type {
        if (ctx!!.inital != null) {
            previousReturn = visit(ctx.inital)
        }
        return ctx!!.children.map { previousReturn = visit(it); previousReturn }.last()
    }

    override fun visitGuardedPipe(ctx: PipedParser.GuardedPipeContext?): Type {
        currentScope = currentScope.addScope()
        val argsText = ctx!!.untypedArgumentList().text
        val args = argsText.substring(1, argsText.length - 1).split(",").map { it.trim() }
        if (args.size != deconstructTuple(previousReturn).size) {
            throw PipedException(Cause.ARGUMENT_MISMATCH, ctx.start)
        }
        args.zip(deconstructTuple(previousReturn)).forEach {
            currentScope.addVariable(Field(it.first, Type(it.second.name), false))
        }
        val guards = ctx.guard()

        // check conditions
        guards.forEach {
            val condition = visit(it.condition)
            if (condition != PrimitiveType.BOOLEAN.type) {
                throw PipedException(Cause.TYPE_MISMATCH, it.start)
            }
        }
        val elseReturn = visit(ctx.elseBody)
        // check body
        return guards.map { visit(it.body) }.fold(elseReturn) { acc, type ->
            if (acc != type) {
                throw PipedException(Cause.TYPE_MISMATCH, ctx.start)
            }
            acc
        }
    }

    override fun visitNextPipe(ctx: PipedParser.NextPipeContext?): Type {
        val pipe = PipeTable.findPipe(ctx!!.name.text) ?: throw PipedException(Cause.UNKNOWN_PIPE, ctx.start)
        val input = deconstructTuple(previousReturn)
        if (pipe.parameters.size != input.size) {
            throw PipedException(Cause.TYPE_MISMATCH, ctx.start)
        }
        pipe.parameters.zip(input).forEach {
            if (it.first.type != it.second) {
                throw PipedException(Cause.TYPE_MISMATCH, ctx.start)
            }
        }

        return pipe.returnType
    }
}