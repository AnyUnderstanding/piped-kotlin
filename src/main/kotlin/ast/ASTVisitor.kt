package de.any.AST

abstract class ASTVisitor {
    open fun visit(program: Program, vararg args: Any) {
        program.bundles.forEach { bundle ->
            visitBundle(bundle, *args)

        }
        program.pipes.forEach { pipe ->
            visitPipe(pipe, *args)
        }
    }

    open fun visitBundle(bundle: Bundle, vararg args: Any) {
        bundle.fields.forEach { visitField(it, *args) }
    }

    open fun visitField(field: Field, vararg args: Any) {
        visitTypeDefinition(field.type, *args)
    }

    open fun visitPipe(pipe: Pipe, vararg args: Any) {
        pipe.parameters.forEach { visitField(it, *args) }
        visitTypeDefinition(pipe.returnType, *args)
        visitScope(pipe.body, *args)
    }

    open fun visitScope(scope: Scope, vararg args: Any) {
        scope.children.forEach {
            when (it) {
                is Assignment -> visitAssignment(it, *args)
                is Expression -> visitExpression(it, *args)
                is Return -> visitReturn(it, *args)
            }
        }
    }

    open fun visitReturn(return_: Return, vararg args: Any) {
        visitExpression(return_.expression, *args)
    }

    open fun visitExpression(expression: Expression, vararg args: Any) {
        when (expression) {
            is BoolExpression -> visitBoolOpExpression(expression, *args)
            is MulDivExpression -> visitMulDivExpression(expression, *args)
            is AddSubExpression -> visitAddSubExpression(expression, *args)
            is Scope -> visitScope(expression, *args)
            is Value -> visitValue(expression, *args)
            is Variable -> visitVariable(expression, *args)
            is Parenthesis -> visitParenthesis(expression, *args)
            is Tuple -> visitTuple(expression, *args)
            is PipeLine -> visitPipeLine(expression, *args)
            is PipeLineTuplePlaceholder -> visitPipeLineTuplePlaceholder(expression, *args)
            is BundleInit -> visitBundleInit(expression, *args)
        }
    }

    open fun visitBoolOpExpression(boolExpression: BoolExpression, vararg args: Any) {
        visitExpression(boolExpression.left, *args)
        visitExpression(boolExpression.right, *args)
    }

    open fun visitMulDivExpression(mulDivExpression: MulDivExpression, vararg args: Any) {
        visitExpression(mulDivExpression.left, *args)
        visitExpression(mulDivExpression.right, *args)
    }

    open fun visitAddSubExpression(expression: AddSubExpression, vararg args: Any) {
        visitExpression(expression.left, *args)
        visitExpression(expression.right, *args)
    }

    open fun visitValue(value: Value, vararg args: Any) {
        // no more children
    }

    open fun visitVariable(variable: Variable, vararg args: Any) {
        // no more children
    }

    open fun visitParenthesis(parenthesis: Parenthesis, vararg args: Any) {
        visitExpression(parenthesis.expression, *args)
    }

    open fun visitBundleInit(bundleInit: BundleInit, vararg args: Any) {
        bundleInit.initializers.forEach { visitExpression(it, *args) }
    }


    open fun visitTuple(tuple: Tuple, vararg args: Any) {
        tuple.elements.forEach { visitExpression(it, *args) }
    }

    open fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {
        pipeLine.elements.forEach {
            visitPipeLineElement(it, *args)
        }
    }

    open fun visitPipeLineTuplePlaceholder(pipeLineTuplePlaceholder: PipeLineTuplePlaceholder, vararg args: Any) {
        // no more children
    }

    open fun visitPipeLineElement(pipeLineElement: PipeLineElement, vararg args: Any) {
        when (pipeLineElement) {
            is PipeCall -> visitPipeCall(pipeLineElement, *args)
            is PipeLineTuple -> visitPipeLineTuple(pipeLineElement, *args)
            is GuardedPipeCall -> visitGuardedPipeCall(pipeLineElement, *args)
        }
    }

    open fun visitGuardedPipeCall(guardedPipeCall: GuardedPipeCall, vararg args: Any) {
        guardedPipeCall.guards.forEach { visitGuard(it, *args) }
        visitElseGuard(guardedPipeCall.elseGuard, *args)
    }

    open fun visitElseGuard(elseGuard: ElseGuard, vararg args: Any) {
        visitExpression(elseGuard.returnExpression, *args)
    }

    open fun visitGuard(guard: Guard, vararg args: Any) {
        visitExpression(guard.guardExpression, *args)
        visitExpression(guard.returnExpression, *args)
    }


    open fun visitPipeLineTuple(pipelineTuple: PipeLineTuple, vararg args: Any) {
        pipelineTuple.expressions.forEach { visitExpression(it, *args) }
    }

    open fun visitPipeCall(pipeLineElement: PipeCall, vararg args: Any) {
        // no more children
    }


    open fun visitAssignment(assignment: Assignment, vararg args: Any) {
        visitTypeDefinition(assignment.expectedType, *args)
        visitExpression(assignment.expression, *args)
    }

    open fun visitTypeDefinition(type: Type, vararg args: Any) {
        // no more children
    }
}

abstract class ILASTVisitor : ASTVisitor() {

    override fun visit(program: Program, vararg args: Any) {
        // todo its probably better to enforce this using the type system
        error("this method should not be called on a ILASTVisitor, consider using: fun visit(program: ILProgram, vararg args: Any)")
    }

    open fun visit(program: ILProgram, vararg args: Any) {
        program.bundles.forEach { bundle ->
            visitBundle(bundle)

        }
        program.pipes.forEach { pipe ->
            visitPipe(pipe)
        }
        program.functions.forEach {
            visitFunction(it)
        }
    }

    open fun visitFunction(function: Function, vararg args: Any) {
        visitTypeDefinition(function.returnType)
        function.parameters.forEach { visitField(it) }
        visitScope(function.body)
    }

    override fun visitExpression(expression: Expression, vararg args: Any) {
        if (expression is FunctionCall) {
            visitFunctionCall(expression)
        } else {
            super.visitExpression(expression)
        }
    }

    override fun visitScope(scope: Scope, vararg args: Any) {
        scope.children.forEach {
            when (it) {
                is Assignment -> visitAssignment(it, *args)
                is Expression -> visitExpression(it, *args)
                is Return -> visitReturn(it, *args)
                is Conditional -> visitConditional(it, *args)
                is PreDefinedNode -> visitPreDefinedNode(it, *args)
            }
        }
    }

    open fun visitFunctionCall(expression: FunctionCall, vararg args: Any) {
        expression.parameters.forEach { visitExpression(it) }
    }

    open fun visitConditional(conditional: Conditional, vararg args: Any) {
        visitExpression(conditional.condition)
        visitReturn(conditional.thenBranch)
    }

    open fun visitPreDefinedNode(predefined: PreDefinedNode, vararg args: Any) {
        // no more children
    }
}