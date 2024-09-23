import kotlin.test.BeforeTest
import kotlin.test.Test


internal class SimpleMain {

    val testName = "simpleMain"
    val path = "./src/test/kotlin/$testName/"

    @BeforeTest
    fun compile() {
        buildCompilerAndCompile(path, testName)
    }

    @Test
    fun simpleMain() {
        val result = run(testName)!!
        assert(result.trim() == "9")
    }

}