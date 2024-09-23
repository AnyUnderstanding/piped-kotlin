import kotlin.test.BeforeTest
import kotlin.test.Test


internal class Scopes {

    val testName = "scopes"
    val path = "./src/test/kotlin/$testName/"

    @BeforeTest
    fun compile() {
        buildCompilerAndCompile(path, testName)
    }

    @Test
    fun scopes() {
        val result = run(testName)
        assert(result!!.trim() == "6")
    }

}