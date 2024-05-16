package de.any


import PipedLexer
import PipedParser
import de.any.AST.AntlrAstTranslator
import de.any.analyzer.BundleTable
import de.any.analyzer.PipeTable
import de.any.analyzer.SymbolCollector
import de.any.analyzer.TypeChecker
import de.any.codegen.llvmTarget.LlvmGenerator
import de.any.codegen.pipedTarget.PipedGenerator
import de.any.normalize.PipelineSeparator
import de.any.normalize.TupleTranslator

// TODO add guarded pipes
// TODO ---
// TODO consider (1) |> x |> () |> y
// TODO ---
// TODO consider ((2) |> one, (2) |> one) |> test2;
// TODO ---
// TODO bundle Dog {
// TODO   let name: bool, <-- this compiles
// TODO    let age: Int
// TODO }
fun main() {
    val generatorStage = Compiler().fromFile("src/main/resources/scratch.pd").tokenize {
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
            PipelineSeparator(),
            TupleTranslator(),
        )

    generatorStage.addGenerator(PipedGenerator()).toFile("src/main/resources/out.pd")
    generatorStage.addGenerator(LlvmGenerator()).showStats().toFile("out.ll")

    BundleTable.clear()
    PipeTable.clear()

}









