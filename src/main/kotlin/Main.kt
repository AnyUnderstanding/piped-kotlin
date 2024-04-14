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


    println(tree.toStringTree())


}

fun getParserTree(): ParseTree {
    val lexer = PipedLexer(CharStreams.fromFileName(programm))
    val tokens = CommonTokenStream(lexer)
    val parser = PipedParser(tokens)
    return parser.program()
}








