package de.any


import PipedLexer
import PipedParser
import de.any.analyzer.*
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree


val programm = "src/main/resources/typeChecker.pd"

fun main() {
    val tree = getParserTree()
    try {
        SymbolCollector().visit(tree)
        BundleHydrate().visit(tree)
        TypeChecker().visit(tree)
    }catch (e: PipedException){
        // for better debugging
        throw e
        e.printStackTrace()
        return
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








