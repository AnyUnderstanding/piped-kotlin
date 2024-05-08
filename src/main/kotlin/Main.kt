package de.any


import PipedLexer
import PipedParser
import de.any.AST.AntlrAstTranslator
import de.any.analyzer.BundleTable
import de.any.analyzer.PipeTable
import de.any.analyzer.SymbolCollector
import de.any.analyzer.TypeChecker
import de.any.codegen.pipedTarget.PipedGenerator
import de.any.normalize.PipelineSeparator
import de.any.normalize.TupleTranslator


fun main() {
    Compiler().fromFile("src/main/resources/scratch.pd").tokenize {
        PipedLexer(it)
    }.toAst {
        PipedParser(it).program()
    }.addAstTranslator {
        AntlrAstTranslator.visit(it) as de.any.AST.Program
    }.addSteps(
        SymbolCollector(),
        TypeChecker(),
    )
        .addILSteps(
            TupleTranslator(),
            PipelineSeparator(),
            )
        .addGenerator(PipedGenerator(true))
        .showStats()
        .toFile("src/main/resources/out.pd")

    BundleTable.clear()
    PipeTable.clear()

}









