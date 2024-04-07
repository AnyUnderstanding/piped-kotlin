package de.any


import PipedLexer
import PipedParser
import de.any.analyzer.*
import de.any.codegen.Generator
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree


val programm = "src/main/resources/codegen.pd"

fun main() {
    val tree = getParserTree()
    try {
        SymbolCollector().visit(tree)
        BundleHydrate().visit(tree)
        val typeChecker = TypeChecker()
        typeChecker.visit(tree)
        Generator(typeChecker.currentScope.getGlobalScope()).visit(tree)
    } catch (e: PipedException) {
        e.printStackTrace()
        // for better debugging
        throw e
    }

    println(tree.toStringTree())
    println(TypeTable)
    println("\n----------\n")
    println(PipeTable)

}

fun getParserTree(): ParseTree {
    val lexer = PipedLexer(CharStreams.fromFileName(programm))
    val tokens = CommonTokenStream(lexer)
    val parser = PipedParser(tokens)
    return parser.programm()
}








