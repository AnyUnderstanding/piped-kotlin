import kotlin.test.BeforeTest
import kotlin.test.Test


internal class Fibonacci {

    val testName = "fibonacci"
    val path = "./src/test/kotlin/$testName/"

    @BeforeTest
    fun compile(){
        buildCompilerAndCompile(path, testName)
    }

    @Test
    fun fibonacci() {
        val result = run(testName)!!
        println(result)
        assert(result.trim() == "102334155")
    }

}