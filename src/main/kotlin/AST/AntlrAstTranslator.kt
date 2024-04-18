package de.any.AST

import PipedBaseVisitor

object AntlrAstTranslator : PipedBaseVisitor<ASTNode>() {
    override fun visitProgram(ctx: PipedParser.ProgramContext?): ASTNode {
        val bundles = ctx!!.bundleDefinition().map { visitBundleDefinition(it) as Bundle }
        val pipes = ctx.pipeDefinition().map { visitPipeDefinition(it) as Pipe }
        return Program(bundles, pipes)
    }

    override fun visitBundleDefinition(ctx: PipedParser.BundleDefinitionContext?): ASTNode {
        return BundleTranslator.visitBundleDefinition(ctx)
    }

    override fun visitPipeDefinition(ctx: PipedParser.PipeDefinitionContext?): ASTNode {
        return PipeTranslator.visitPipeDefinition(ctx)
    }
}

object PipeTranslator : PipedBaseVisitor<Pipe>() {
    override fun visitPipeDefinition(ctx: PipedParser.PipeDefinitionContext?): Pipe {
        val name = ctx!!.name.text
        val returnType = TypeTranslator.visitType(ctx.type())
        val parameters = ctx.argumentsDefinitionList().typedName().map { TypedNameTranslator.visitTypedName(it) }
        val body = ExpressionTranslator.visit(ctx.scope())
        return Pipe(name, returnType, parameters, body as Scope)
    }
}

object BundleTranslator : PipedBaseVisitor<Bundle>() {
    override fun visitBundleDefinition(ctx: PipedParser.BundleDefinitionContext?): Bundle {
        val name = ctx!!.name.text
        val fields = ctx.typedName().map { TypedNameTranslator.visitTypedName(it) }
        return Bundle(name, fields)
    }
}

object TypedNameTranslator : PipedBaseVisitor<Field>() {
    override fun visitTypedName(ctx: PipedParser.TypedNameContext?): Field {
        return Field(ctx!!.name.text, TypeTranslator.visitType(ctx.type()))
    }
}

object TypeTranslator : PipedBaseVisitor<Type>() {
    override fun visitType(ctx: PipedParser.TypeContext?): Type {
        if (ctx!!.tupleType() != null){
            return Type(ctx.tupleType().type().map { visitType(it) })
        }
        return Type.fromString(ctx.text)
    }
}

object ExpressionTranslator : PipedBaseVisitor<Expression>() {

    override fun visitAddSubOp(ctx: PipedParser.AddSubOpContext?): Expression {
        return AddSubExpression(
            visit(ctx!!.left),
            visit(ctx.right),
            ctx.op.text
        )
    }

    override fun visitMulDivOp(ctx: PipedParser.MulDivOpContext?): Expression {
        return MulDivExpression(
            visit(ctx!!.left),
            visit(ctx.right),
            ctx.op.text
        )
    }

    override fun visitParenthesis(ctx: PipedParser.ParenthesisContext?): Expression {
        return Parenthesis(visit(ctx!!.expr()))
    }

    override fun visitBoolOp(ctx: PipedParser.BoolOpContext?): Expression {
        return BoolExpression(
            visit(ctx!!.left),
            visit(ctx.right),
            ctx.op.text
        )
    }

    override fun visitPipeline(ctx: PipedParser.PipelineContext?): Expression {
        return PipeLineTranslator.visitPipeline(ctx)
    }

    override fun visitTuple(ctx: PipedParser.TupleContext?): Expression {
        return Tuple(ctx!!.expr().map { visit(it) })
    }

    override fun visitScope(ctx: PipedParser.ScopeContext?): Expression {
        return Scope(ctx!!.statement().map { StatementTranslator.visitStatement(it) })
    }

    override fun visitVar(ctx: PipedParser.VarContext?): Expression {
        return Variable(ctx!!.text.split("."))
    }

    override fun visitValue(ctx: PipedParser.ValueContext?): Expression {
        return if (ctx!!.BOOLEAN() != null) {
            BoolValue(ctx.text)
        } else if (ctx.STRING_() != null) {
            StringValue(ctx.text)
        } else {
            IntValue(ctx.text)
        }
    }

    override fun visitBundleInit(ctx: PipedParser.BundleInitContext?): Expression {
        val name = ctx!!.name.text
        val fields = ctx.expr().map { ExpressionTranslator.visit(it) }
        return BundleInit(name, fields)

    }
}

object StatementTranslator : PipedBaseVisitor<TypedASTNode>() {
    override fun visitReturn(ctx: PipedParser.ReturnContext?): TypedASTNode {
        return Return(ExpressionTranslator.visit(ctx!!.expr()))
    }

    override fun visitAssign(ctx: PipedParser.AssignContext?): TypedASTNode {
        val field = TypedNameTranslator.visitTypedName(ctx!!.typedName())
        val expression = ExpressionTranslator.visit(ctx.expr())
        return Assignment(field.name, field.type, expression)
    }

    override fun visitStatement(ctx: PipedParser.StatementContext?): TypedASTNode {
        return when {
            ctx!!.assign() != null -> return visitAssign(ctx.assign())
            ctx.return_() != null -> return visitReturn(ctx.return_())
            else -> ExpressionTranslator.visit(ctx.expr())
        }
    }
}

object PipeLineTranslator : PipedBaseVisitor<Expression>() {
    override fun visitPipeline(ctx: PipedParser.PipelineContext?): Expression {
        return PipeLine(ctx!!.pipelineElement().map { visit(it) as PipeLineElement })
    }

    override fun visitPipelineElement(ctx: PipedParser.PipelineElementContext?): Expression {
        val pipeCallName = ctx!!.ID()
        val guard = ctx.guardedPipe()
        val tuple = ctx.pipelineTuple()
        return when {
            guard != null -> {
                val args = guard.args.ID().map { Field(it.text, PrimitiveType.NONE.type) }
                val guardings = GuardTranslator.visitGuardedPipe(guard)
                GuardedPipeCall(
                    pipeCallName.text,
                    args,
                    guardings.first, guardings.second
                )
            }

            pipeCallName != null -> {
                PipeCall(pipeCallName.text)
            }

            else -> {
                visitPipelineTuple(tuple)
            }
        }
    }

    override fun visitPipelineTuple(ctx: PipedParser.PipelineTupleContext?): Expression {
        val tupleElements = ctx!!.children.map {
            when (it) {
                is PipedParser.PlaceholderContext -> {
                    PipeLineTuplePlaceholder(it.DEC_INT().text.toInt())
                }

                is PipedParser.ExprContext -> {
                    ExpressionTranslator.visit(it)
                }

                else -> null

            }
        }.filterNotNull()

        return PipeLineTuple(tupleElements)
    }
}

object GuardTranslator : PipedBaseVisitor<Pair<List<Guard>, ElseGuard>>() {
    override fun visitGuardedPipe(ctx: PipedParser.GuardedPipeContext?): Pair<List<Guard>, ElseGuard> {
        val guards = ctx!!.guard().map {
            Guard(
                ExpressionTranslator.visit(it.condition),
                ExpressionTranslator.visit(it.body)
            )
        }
        val elseGuard = ElseGuard(
            ExpressionTranslator.visit(ctx.elseGuard().body)
        )
        return Pair(guards, elseGuard)
    }


}