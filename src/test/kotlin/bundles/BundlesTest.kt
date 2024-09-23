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
import de.any.normalize.PipelineSeparatorRework
import de.any.normalize.ScopeSeparator
import de.any.normalize.TupleTranslator
import kotlin.test.Test
import kotlin.test.BeforeTest


internal class Bundles {

    val testName = "bundles"
    val path = "./src/test/kotlin/$testName/"


    @BeforeTest
    fun compile() {
        buildCompilerAndCompile(path, testName)
    }

    @Test
    fun bundles() {
        val result = run(testName)!!
        assert(result.trim() == "18\n4")

    }

}