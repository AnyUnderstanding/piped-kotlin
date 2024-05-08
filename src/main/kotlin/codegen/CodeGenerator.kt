package de.any.codegen

import de.any.AST.ASTVisitor
import de.any.AST.ILASTVisitor
import de.any.AST.Program

abstract class CodeGenerator : ILASTVisitor() {
    var currentIndent: Int = 0
    val code = StringBuilder()

    private fun indent(): String = "   ".repeat(currentIndent)


    abstract fun gen(program: Program): String

    fun increaseIndent(amt: Int = 1) {
        currentIndent += amt
    }

    fun decreaseIndent(amt: Int = 1) {
        currentIndent -= amt
    }

    fun appendCode(line: String, removeNewLine: Boolean = false) {
        val result = line.prependIndent(indent()) + if (removeNewLine) "" else "\n"
        code.append(result)
    }

    fun prependCode(line: String, removeNewLine: Boolean = false) {
        val result = line.prependIndent(indent()) + if (removeNewLine) "" else "\n"
        code.insert(0, result)
    }
}