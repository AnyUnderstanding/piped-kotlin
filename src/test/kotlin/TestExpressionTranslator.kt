import de.any.AST.ExpressionTranslator
import de.any.programm
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree
import kotlin.test.Test

class TestExpressionTranslator {
    @Test
    fun testTranslate() {
        val testCase = "1 + 2"
        val tree = getParserTree(testCase)
        val expression = ExpressionTranslator.visit(tree)
        println(expression)
    }

    @Test
    fun testTranslate2() {
        val testCase = "1 + 2 * 3 * (4 + 5)"
        val tree = getParserTree(testCase)
        val expression = ExpressionTranslator.visit(tree)
        println(expression)
    }

    @Test
    fun testTranslate3() {
        val testCase = "1 +{>>2;}"
        val tree = getParserTree(testCase)
        val expression = ExpressionTranslator.visit(tree)
        println(expression)
    }

    fun getParserTree(text: String): ParseTree {
        val lexer = PipedLexer(CharStreams.fromString(text))
        val tokens = CommonTokenStream(lexer)
        val parser = PipedParser(tokens)
        return parser.expr()
    }
}