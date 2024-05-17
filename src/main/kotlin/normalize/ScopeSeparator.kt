package de.any.normalize

import de.any.AST.*
import de.any.AST.Function

class ScopeSeparator : ILASTVisitor() {
    var scopeCounter = 0
    val functions: MutableList<Function> = mutableListOf()

    override fun visit(program: ILProgram, vararg args: Any) {
        super.visit(program, *args)
        program.functions.addAll(functions)
    }

    override fun visitScope(scope: Scope, vararg args: Any) {
        super.visitScope(scope, *args)
        if (scope.parent is Pipe || scope.parent is Function) return
        val functionName = "scope$${scopeCounter++}"
        replaceScope(
            scope, FunctionCall(
                functionName,
                scope.capturedVariables,
                scope.type
            )
        )
        val function = Function(
            functionName,
            scope.type,
            scope.capturedVariables.map { Field(it.getIdentifier(), it.type) },
            scope
        )
        functions.add(function)
    }

    fun replaceScope(scope: Scope, function: FunctionCall) {
        val parent = scope.parent
        function.parent = parent
        when (parent) {
            is Scope -> parent.children.replaceAll { if (it == scope) function else it }
            is InfixOperation -> {
                if (parent.left == scope) {
                    parent.left = function
                } else {
                    parent.right = function
                }
            }

            is Assignment -> {
                parent.expression = function
            }

            is PipeLineTuple -> {
                parent.expressions.replaceAll { if (it == scope) function else it }
            }

            is Tuple -> {
                parent.elements.replaceAll { if (it == scope) function else it }
            }

            is Return -> {
                parent.expression = function
            }
        }
    }


}