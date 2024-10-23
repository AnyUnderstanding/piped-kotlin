import kotlin.test.Test
import kotlin.test.BeforeTest
import kotlin.test.assertEquals

class SubPipelines {

    val testName = "subPipelines"
    val path = "./src/test/kotlin/$testName/"

    val expected = """
        4
        3
        85
        20
    """.trimIndent()

    @BeforeTest
    fun compile() {
        buildCompilerAndCompile(path, testName)
    }

    @Test
    fun subPipelines() {
        val result = run(testName)
        println(result)
        assertEquals(expected, result?.trim())
    }
}