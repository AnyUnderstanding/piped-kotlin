package de.any.codegen.llvmTarget

import de.any.AST.*
import de.any.AST.ExpressionTranslator
import de.any.AST.Function
import de.any.codegen.CodeTargetGenerator

class LlvmGenerator : CodeTargetGenerator() {
    override fun gen(expression: Program): String {
        require(expression is ILProgram) { "Program must be of type ILProgram" }
        visit(expression as ILProgram)
        return code.toString()
    }

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        appendCode(getFunctionDefinition(pipe))
        visitScope(pipe.body)
    }


    override fun visitFunction(function: Function, vararg args: Any) {
        appendCode(getFunctionDefinition(function))
        visitScope(function.body)
    }


    override fun visitBundle(bundle: Bundle, vararg args: Any) {
        appendCode("%${bundle.name} = type {")
        increaseIndent()
        joinLines(",") {
            bundle.fields.map { "${it.type.getLlvmNamePointer()}" }
        }
        decreaseIndent()

        useLine("}\n")
    }

    fun getFunctionDefinition(pipe: Pipe): String {
        val returnType = pipe.returnType.getLlvmNamePointer()
        val parameters = pipe.parameters.joinToString(", ") { "${it.type.getLlvmName()} %${it.name}" }
        return "define $returnType @${pipe.name}($parameters) "
    }

    fun getFunctionDefinition(function: Function): String {
        val returnType = function.returnType.getLlvmNamePointer()
        val parameters = function.parameters.joinToString(", ") { "${it.type.getLlvmName()} %${it.name}" }
        return "define $returnType @${function.name}($parameters) "
    }

    override fun visitScope(scope: Scope, vararg args: Any) {
        useLine("{")
        increaseIndent()
        super.visitScope(scope)
        decreaseIndent()
        useLine("}")
    }

    override fun visitAssignment(assignment: Assignment, vararg args: Any) {
        val translated = AssignmentTranslator().gen(assignment)
        appendBlock(
            translated.code
        )

    }

    override fun visitReturn(return_: Return, vararg args: Any) {
        val translated = ExpressionTranslator().gen(return_.expression)

        appendBlock(translated.code)
        useLine("ret ${return_.expression.type.getLlvmNamePointer()} ${translated.location}")
    }
}

