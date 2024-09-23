package de.any.codegen

import de.any.AST.ASTVisitor
import de.any.AST.ILASTVisitor
import de.any.AST.Program
import de.any.codegen.llvmTarget.TranslationResult

abstract class CodeGenerator<S, T> : ILASTVisitor() {
    var currentIndent: Int = 0
    val code = StringBuilder()
    val lineBuilder = StringBuilder()

    private fun indent(): String = "   ".repeat(currentIndent)


    abstract fun gen(node: S): T

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

    fun useLine(suffix: String = "", removeNewLine: Boolean = false) {
        appendCode(lineBuilder.toString() + suffix, removeNewLine)
        lineBuilder.clear()
    }

    fun joinLines(join: String, lineBuilder: () -> List<String>) {
        joinLines(join, *lineBuilder().toTypedArray())
    }

    fun joinLines(join: String, vararg lines: String) {
        lines.dropLast(1).forEach {
            appendCode(it + join)
        }
        appendCode(lines.last())
    }

    fun appendBlock(block: String) {
        block.lines().forEach {
            useLine(it)
        }
    }
}

abstract class CodeTargetGenerator : CodeGenerator<Program, String>()

abstract class AstNodeTranslator<T> : CodeGenerator<T, TranslationResult>(){
    lateinit var location: String

}