import kotlin.test.BeforeTest
import kotlin.test.Test


internal class ComplexPipeline {

    val testName = "complexPipeline"
    val path = "./src/test/kotlin/$testName/"


    @BeforeTest
    fun compile() {
        buildCompilerAndCompile(path, testName)
    }

    @Test
    fun complexPipeline() {
        val result = run(testName)!!
        println(result)
        assert(false)
    }

}