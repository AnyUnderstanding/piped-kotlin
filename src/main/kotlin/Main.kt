package de.any


import PipedLexer
import PipedParser
import de.any.AST.AntlrAstTranslator
import de.any.analyzer.BundleTable
import de.any.analyzer.PipeTable
import de.any.analyzer.SymbolCollector
import de.any.analyzer.TypeChecker
import de.any.autoformat.AutoFormater
import de.any.codegen.pipedTarget.PipedGenerator
import de.any.normalize.PipelineSeparator
import de.any.normalize.TupleTranslator
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree




fun main() {

    Compiler.fromFile("src/main/resources/scratch.pd").tokenize {
        PipedLexer(it)
    }.toAst {
        PipedParser(it).program()
    }.addAstTranslator {
        AntlrAstTranslator.visit(it) as de.any.AST.Program
    }.addSteps(
        SymbolCollector(),
        TypeChecker(),
        PipelineSeparator(),
        TupleTranslator(),
    )
        .addGenerator(PipedGenerator(true))
        .toFile("src/main/resources/out.pd")

    BundleTable.clear()
    PipeTable.clear()
    println("--------------------------------------------")
    println("--------------------------------------------")
    println("--------------------------------------------")
    println("--------------------------------------------")

    Compiler.fromFile("src/main/resources/out.pd").tokenize {
        PipedLexer(it)
    }.toAst {
        PipedParser(it).program()
    }.addAstTranslator {
        AntlrAstTranslator.visit(it) as de.any.AST.Program
    }.addSteps(
        SymbolCollector(),
        TypeChecker(),
        PipelineSeparator(),
        TupleTranslator(),
    )
        .addGenerator(PipedGenerator(true))
        .toFile("src/main/resources/out1.pd")


}









