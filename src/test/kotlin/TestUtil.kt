import de.any.AST.AntlrAstTranslator
import de.any.Compiler
import de.any.analyzer.BundleTable
import de.any.analyzer.PipeTable
import de.any.analyzer.SymbolCollector
import de.any.analyzer.TypeChecker
import de.any.codegen.llvmTarget.AssignmentTranslator
import de.any.codegen.llvmTarget.ExpressionTranslator
import de.any.codegen.llvmTarget.InsertPredefined
import de.any.codegen.llvmTarget.LlvmGenerator
import de.any.codegen.pipedTarget.PipedGenerator
import de.any.normalize.PipelineSeparatorRework
import de.any.normalize.ScopeSeparator
import de.any.normalize.TupleTranslator
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit


fun run(testName: String): String? {
    return "../runLlvm.sh".runCommand(File("./src/test/kotlin/$testName"))?.lines()?.drop(1)?.joinToString("\n") { it }
}


fun String.runCommand(workingDir: File): String? {
    try {
        val parts = this.split("\\s".toRegex())
        val proc = ProcessBuilder(*parts.toTypedArray())
            .directory(workingDir)
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()

        proc.waitFor(60, TimeUnit.MINUTES)
        return proc.inputStream.bufferedReader().readText()
    } catch (e: IOException) {
        e.printStackTrace()
        return null
    }
}


fun buildCompilerAndCompile(
    path: String,
    testname: String
) {
    val bundleTable = BundleTable()
    val pipeTable = PipeTable()
    val expressionTranslator = ExpressionTranslator(bundleTable)
    val assignmentTranslator = AssignmentTranslator(expressionTranslator)
    val symbolCollector = SymbolCollector(bundleTable, pipeTable)
    val typeChecker = TypeChecker(bundleTable, pipeTable)
    val pipelineSeparator = PipelineSeparatorRework(bundleTable)
    val tupleTranslator = TupleTranslator(bundleTable)
    val llvmGenerator = LlvmGenerator(assignmentTranslator, expressionTranslator)

    val generatorStage =
        Compiler().fromFile("$path/${testname.replaceFirstChar(Char::titlecaseChar)}.pd").tokenize {
            PipedLexer(it)
        }.toAst {
            PipedParser(it).program()
        }.addAstTranslator {
            AntlrAstTranslator.visit(it) as de.any.AST.Program
        }.addSteps(
            InsertPredefined(),
            symbolCollector,
            typeChecker,
        )
            .addILSteps(
                pipelineSeparator,
                ScopeSeparator(),
                tupleTranslator,
            )
    generatorStage.addGenerator(PipedGenerator()).toFile("$path/out/piped.pd")
    generatorStage.addGenerator(llvmGenerator).showStats().toFile("$path/out/llvm.ll")
}