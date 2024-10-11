import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


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
        assertEquals( "5\n3\n3141\n1\n1\n2\n3\n42\n43\n1\n2", result.trim())
    }

}