package de.any.codegen.pipedTarget

import de.any.AST.*
import de.any.AST.Function
import de.any.codegen.CodeGenerator


class PipedGenerator(val allowTuples: Boolean = false) : CodeGenerator() {

    val lineBuilder = StringBuilder()

    fun useLine(suffix: String = "", removeNewLine: Boolean = false) {
        appendCode(lineBuilder.toString() + suffix, removeNewLine)
        lineBuilder.clear()
    }

    override fun gen(program: Program): String {
        if (program is ILProgram) {
            visit(program as ILProgram)
        } else {
            visit(program as Program)
        }
        return code.toString()
    }

    override fun visit(program: Program, vararg args: Any) {
        program.bundles.forEach { bundle ->
            visitBundle(bundle)

        }
        program.pipes.forEach { pipe ->
            visitPipe(pipe)
        }
    }

    override fun visitBundle(bundle: Bundle, vararg args: Any) {
        appendCode("bundle ${bundle.name} {")
        increaseIndent()
        bundle.fields.forEach {
            lineBuilder.append("let ")
            visitField(it)
        }
        decreaseIndent()
        appendCode("}")
    }

    override fun visitField(field: Field, vararg args: Any) {
        val removeNewLine = args.isNotEmpty() && args[0] == true
        lineBuilder.append("${field.name} : ${field.type.asPipedString()}")
        if (removeNewLine) {
            lineBuilder.append(", ")
        } else {
            useLine(", ")
        }
    }

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        appendCode("pi ${pipe.name}(", true)
        pipe.parameters.forEach { visitField(it, true) }
        useLine("", true)
        if (pipe.parameters.isNotEmpty()) {
            code.deleteCharAt(code.length - 1)
            code.deleteCharAt(code.length - 1)

        }
        appendCode(") : ${pipe.returnType.asPipedString()} ", true)
        visitScope(pipe.body)
    }

    override fun visitScope(scope: Scope, vararg args: Any) {
        appendCode("{")
        increaseIndent()
        super.visitScope(scope, true)
        decreaseIndent()
        appendCode("}")
    }

    override fun visitAssignment(assignment: Assignment, vararg args: Any) {
        lineBuilder.append("let ${assignment.name} : ${assignment.expectedType.asPipedString()} = ")
        visitExpression(assignment.expression)

        useLine(";")
    }

    override fun visitReturn(return_: Return, vararg args: Any) {
        lineBuilder.append(">> ")
        visitExpression(return_.expression)
        useLine(";")
    }

    override fun visitExpression(expression: Expression, vararg args: Any) {
        super.visitExpression(expression, *args)
        if (args.isNotEmpty() && args[0] == true) {
            useLine(";")
        }
    }

    override fun visitValue(value: Value, vararg args: Any) {
        lineBuilder.append(value.value)
    }

    override fun visitVariable(variable: Variable, vararg args: Any) {
        lineBuilder.append(variable.path.joinToString("."))
    }

    override fun visitBoolOpExpression(boolExpression: BoolExpression, vararg args: Any) {
        visitExpression(boolExpression.left)
        lineBuilder.append(" ${boolExpression.operand} ")
        visitExpression(boolExpression.right)
    }

    override fun visitMulDivExpression(mulDivExpression: MulDivExpression, vararg args: Any) {
        visitExpression(mulDivExpression.left)
        lineBuilder.append(" ${mulDivExpression.operand} ")
        visitExpression(mulDivExpression.right)
    }

    override fun visitAddSubExpression(expression: AddSubExpression, vararg args: Any) {
        visitExpression(expression.left)
        lineBuilder.append(" ${expression.operand} ")
        visitExpression(expression.right)
    }

    override fun visitTuple(tuple: Tuple, vararg args: Any) {
        check(allowTuples) { "Every tuple should be translated to a BundleInit before code generation." }
        if (tuple.elements.isEmpty()) {
            lineBuilder.append("()")
            return
        }
        lineBuilder.append("(")
        tuple.elements.dropLast(1).forEach {
            visitExpression(it)
            lineBuilder.append(", ")
        }
        visitExpression(tuple.elements.last())
        lineBuilder.append(")")
    }

    override fun visitBundleInit(bundleInit: BundleInit, vararg args: Any) {
        if (bundleInit.initializers.isEmpty()) {
            lineBuilder.append(bundleInit.name + "()")
            return
        }
        lineBuilder.append(bundleInit.name + "(")
        bundleInit.initializers.dropLast(1).forEach {
            visitExpression(it)
            lineBuilder.append(", ")
        }
        visitExpression(bundleInit.initializers.last())
        lineBuilder.append(")")
    }

    override fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {
        pipeLine.elements.dropLast(1).forEach {
            visitPipeLineElement(it)
            lineBuilder.append(" |> ")
        }
        visitPipeLineElement(pipeLine.elements.last())
        lineBuilder.drop(4)
    }

    override fun visitPipeCall(pipeLineElement: PipeCall, vararg args: Any) {
        lineBuilder.append(pipeLineElement.name)
    }

    override fun visitPipeLineTuplePlaceholder(pipeLineTuplePlaceholder: PipeLineTuplePlaceholder, vararg args: Any) {
        lineBuilder.append("#${pipeLineTuplePlaceholder.index}")
    }

    override fun visitPipeLineTuple(pipelineTuple: PipeLineTuple, vararg args: Any) {
        if (pipelineTuple.expressions.isEmpty()) {
            lineBuilder.append("()")
            return
        }
        lineBuilder.append("(")

        pipelineTuple.expressions.dropLast(1).forEach {
            visitExpression(it)
            lineBuilder.append(", ")
        }
        visitExpression(pipelineTuple.expressions.last())
        lineBuilder.append(")")
    }

    override fun visitParenthesis(parenthesis: Parenthesis, vararg args: Any) {
        lineBuilder.append("(")
        visitExpression(parenthesis.expression)
        lineBuilder.append(")")
    }

    override fun visitGuardedPipeCall(guardedPipeCall: GuardedPipeCall, vararg args: Any) {
        lineBuilder.append(guardedPipeCall.name + " [")
        lineBuilder.append("(")
        guardedPipeCall.parameters.dropLast(1).forEach {
            lineBuilder.append(it.name)
            lineBuilder.append(", ")
        }
        lineBuilder.append(guardedPipeCall.parameters.last().name)
        lineBuilder.append(") |> ")
        useLine()
        increaseIndent()
        guardedPipeCall.guards.forEach {
            lineBuilder.append("(")
            visitExpression(it.guardExpression)
            lineBuilder.append(")")
            lineBuilder.append(" -> ")
            visitExpression(it.returnExpression)
            useLine(",")
        }
        lineBuilder.append("else -> ")
        visitExpression(guardedPipeCall.elseGuard.returnExpression)
        useLine()
        lineBuilder.append("]")
        decreaseIndent()
    }

    override fun visitFunction(function: Function, vararg args: Any) {
        lineBuilder.append("fun ${function.name}(")
        function.parameters.forEach {
            visitField(it, true)
        }
        useLine("){}", true)
    }
}