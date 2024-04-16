package de.any


import PipedLexer
import PipedParser
import de.any.AST.AntlrAstTranslator
import de.any.AST.TestVisitor
import de.any.analyzer.SymbolCollector
import de.any.analyzer.TypeChecker
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree


val programm = "src/main/resources/scratch.pd"
// TODO!!! CHANGE TUPLE-TYPE HANDLING
// TODO!!! CURRENTLY NO NESTING IS SUPPORTED AND TUPLES DONT WORK AS FUNCTION ARGUMENTS
fun main() {
    val tree = getParserTree()
    val pipedTree = AntlrAstTranslator.visit(tree)
    SymbolCollector().visit(pipedTree as de.any.AST.Program)
    TypeChecker().visit(pipedTree)
    println(pipedTree)
}

fun getParserTree(): ParseTree {
    val lexer = PipedLexer(CharStreams.fromFileName(programm))
    val tokens = CommonTokenStream(lexer)
    val parser = PipedParser(tokens)
    return parser.program()
}








