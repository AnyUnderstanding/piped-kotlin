import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


class Arithmetic {

    val testName = "arithmetic"
    val path = "./src/test/kotlin/$testName/"


    @BeforeTest
    fun compile() {
        buildCompilerAndCompile(path, testName)
    }

    @Test
    fun arithmetic() {
        val result = run(testName)!!
        println(result)
        assertEquals(
            result.trim(),
            "9"
        )
    }

}