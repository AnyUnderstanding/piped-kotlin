package de.any.AST

abstract class ASTVisitor {
    open fun visit(program: Program, vararg args: Any) {
        program.bundles.forEach { bundle ->
            visitBundle(bundle)

        }
        program.pipes.forEach { pipe ->
            visitPipe(pipe)
        }
    }

    open fun visitBundle(bundle: Bundle, vararg args: Any) {
        bundle.fields.forEach(::visitField)
    }

    open fun visitField(field: Field, vararg args: Any) {
        visitTypeDefinition(field.type)
    }

    open fun visitPipe(pipe: Pipe, vararg args: Any) {
        pipe.parameters.forEach(::visitField)
        visitTypeDefinition(pipe.returnType)
        visitScope(pipe.body)
    }

    open fun visitScope(scope: Scope, vararg args: Any) {
        scope.children.forEach {
            when (it) {
                is Assignment -> visitAssignment(it)
                is Expression -> visitExpression(it)
                is Return -> visitReturn(it)
            }
        }
    }

    open fun visitReturn(return_: Return, vararg args: Any) {
        visitExpression(return_.expression)
    }

    open fun visitExpression(expression: Expression, vararg args: Any) {
        when (expression) {
            is BoolExpression -> visitBoolOpExpression(expression)
            is MulDivExpression -> visitMulDivExpression(expression)
            is AddSubExpression -> visitAddSubExpression(expression)
            is Scope -> visitScope(expression)
            is Value -> visitValue(expression)
            is Variable -> visitVariable(expression)
            is Parenthesis -> visitParenthesis(expression)
            is Tuple -> visitTuple(expression)
            is PipeLine -> visitPipeLine(expression)
            is PipeLineTuplePlaceholder -> visitPipeLineTuplePlaceholder(expression)
            is BundleInit -> visitBundleInit(expression)
        }
    }

    open fun visitBoolOpExpression(boolExpression: BoolExpression, vararg args: Any) {
        visitExpression(boolExpression.left)
        visitExpression(boolExpression.right)
    }

    open fun visitMulDivExpression(mulDivExpression: MulDivExpression, vararg args: Any) {
        visitExpression(mulDivExpression.left)
        visitExpression(mulDivExpression.right)
    }

    open fun visitAddSubExpression(expression: AddSubExpression, vararg args: Any) {
        visitExpression(expression.left)
        visitExpression(expression.right)
    }

    open fun visitValue(value: Value, vararg args: Any) {
        // no more children
    }

    open fun visitVariable(variable: Variable, vararg args: Any) {
        // no more children
    }

    open fun visitParenthesis(parenthesis: Parenthesis, vararg args: Any) {
        visitExpression(parenthesis.expression)
    }

    open fun visitBundleInit(bundleInit: BundleInit, vararg args: Any) {
        bundleInit.initializers.forEach(::visitExpression)
    }


    open fun visitTuple(tuple: Tuple, vararg args: Any) {
        tuple.elements.forEach(::visitExpression)
    }

    open fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {
        pipeLine.elements.forEach {
            visitPipeLineElement(it)
        }
    }

    open fun visitPipeLineTuplePlaceholder(pipeLineTuplePlaceholder: PipeLineTuplePlaceholder, vararg args: Any) {
        // no more children
    }

    open fun visitPipeLineElement(pipeLineElement: PipeLineElement, vararg args: Any) {
        when (pipeLineElement) {
            is PipeCall -> visitPipeCall(pipeLineElement)
            is PipeLineTuple -> visitPipeLineTuple(pipeLineElement)
            is GuardedPipeCall -> visitGuardedPipeCall(pipeLineElement)
        }
    }

    open fun visitGuardedPipeCall(guardedPipeCall: GuardedPipeCall, vararg args: Any) {
        guardedPipeCall.guards.forEach { visitGuard(it) }
        visitElseGuard(guardedPipeCall.elseGuard)
    }

    open fun visitElseGuard(elseGuard: ElseGuard, vararg args: Any) {
        visitExpression(elseGuard.returnExpression)
    }

    open fun visitGuard(guard: Guard, vararg args: Any) {
        visitExpression(guard.guardExpression)
        visitExpression(guard.returnExpression)
    }


    open fun visitPipeLineTuple(pipelineTuple: PipeLineTuple, vararg args: Any) {
        pipelineTuple.expressions.forEach(::visitExpression)
    }

    open fun visitPipeCall(pipeLineElement: PipeCall, vararg args: Any) {
        // no more children
    }


    open fun visitAssignment(assignment: Assignment, vararg args: Any) {
        visitTypeDefinition(assignment.expectedType)
        visitExpression(assignment.expression)
    }

    open fun visitTypeDefinition(type: Type, vararg args: Any) {
        // no more children
    }
}

class TestVisitor : ASTVisitor()