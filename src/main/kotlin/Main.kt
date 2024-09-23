package de.any


import PipedLexer
import PipedParser
import de.any.AST.AntlrAstTranslator
import de.any.analyzer.*
import de.any.codegen.llvmTarget.AssignmentTranslator
import de.any.codegen.llvmTarget.ExpressionTranslator
import de.any.codegen.llvmTarget.InsertPredefined
import de.any.codegen.llvmTarget.LlvmGenerator
import de.any.codegen.pipedTarget.PipedGenerator
import de.any.normalize.PipelineSeparatorRework
import de.any.normalize.ScopeSeparator
import de.any.normalize.TupleTranslator


// TODO consider (1) |> x |> () |> y
// TODO ---
// TODO consider ((2) |> one, (2) |> one) |> test2;
// TODO ---
// TODO bundle Dog {
// TODO   let name: bool, <-- this compiles
// TODO    let age: Int
// TODO }
// TODO ---
// TODO handle (Int) as tuple
fun main() {
    createCompiler(
        BundleTable(),
        PipeTable()
    )
}



fun createCompiler(
    bundleTable: BundleTable,
    pipeTable: PipeTable,
) {
    val expressionTranslator = ExpressionTranslator(bundleTable)
    val assignmentTranslator = AssignmentTranslator(expressionTranslator)

    val generatorStage = Compiler().fromFile("src/main/resources/scratch.pd").tokenize {
        PipedLexer(it)
    }.toAst {
        PipedParser(it).program()
    }.addAstTranslator {
        AntlrAstTranslator.visit(it) as de.any.AST.Program
    }.addSteps(
        InsertPredefined(),
        SymbolCollector(bundleTable, pipeTable),
        TypeChecker(bundleTable, pipeTable),
    )
        .addILSteps(
            PipelineSeparatorRework(bundleTable),
            ScopeSeparator(),
            TupleTranslator(bundleTable),
        )
    generatorStage.addGenerator(PipedGenerator(true)).toFile("src/main/resources/out.pd")
    generatorStage.addGenerator(LlvmGenerator(assignmentTranslator, expressionTranslator)).showStats()
        .toFile("src/main/resources/out.ll")
}








