import de.any.AST.AntlrAstTranslator
import de.any.Compiler
import de.any.analyzer.BundleTable
import de.any.analyzer.PipeTable
import de.any.analyzer.SymbolCollector
import de.any.analyzer.TypeChecker
import de.any.codegen.llvmTarget.InsertPredefined
import de.any.codegen.llvmTarget.LlvmGenerator
import de.any.codegen.pipedTarget.PipedGenerator
import de.any.normalize.PipelineSeparator
import de.any.normalize.ScopeSeparator
import de.any.normalize.TupleTranslator
import kotlin.test.Test
import kotlin.test.BeforeTest


class ComplexPipeline {

    val testName = "complexPipeline"
    val path = "./src/test/kotlin/$testName/"

    @BeforeTest
    fun compile() {
        val generatorStage = Compiler().fromFile("$path/ComplexPipeline.pd").tokenize {
            PipedLexer(it)
        }.toAst {
            PipedParser(it).program()
        }.addAstTranslator {
            AntlrAstTranslator.visit(it) as de.any.AST.Program
        }.addSteps(
            InsertPredefined(),
            SymbolCollector(),
            TypeChecker(),
        )
            .addILSteps(
                PipelineSeparator(),
                ScopeSeparator(),
                TupleTranslator(),
            )
        generatorStage.addGenerator(PipedGenerator()).toFile("$path/out/piped.pd")
        generatorStage.addGenerator(LlvmGenerator()).showStats().toFile("$path/out/llvm.ll")

        BundleTable.clear()
        PipeTable.clear()
    }

    @Test
    fun complexPipeline() {
        val result = run(testName)!!
        println(result)
    }

}