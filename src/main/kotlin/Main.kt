package de.any


import PipedLexer
import PipedParser
import de.any.AST.AntlrAstTranslator
import de.any.analyzer.SymbolCollector
import de.any.analyzer.TypeChecker
import de.any.codegen.pipedTarget.PipedGenerator
import de.any.normalize.TupleTranslator
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree


val programm = "src/main/resources/typeChecker.pd"

fun main() {

    Compiler.fromFile(programm).tokenize {
        PipedLexer(it)
    }.toAst {
        PipedParser(it).program()
    }.addAstTranslator {
        AntlrAstTranslator.visit(it) as de.any.AST.Program
    }.addSteps(
        TupleTranslator(),
        SymbolCollector(),
        TypeChecker(),
    ).printAst()


}

fun getParserTree(): ParseTree {
    val lexer = PipedLexer(CharStreams.fromFileName(programm))
    val tokens = CommonTokenStream(lexer)
    val parser = PipedParser(tokens)
    return parser.program()
}










