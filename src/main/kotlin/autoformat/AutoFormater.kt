package de.any.autoformat


import PipedFormatLexer
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.Token
import java.io.File

class AutoFormater {
    val max_new_lines: Int = 2
    val current_indent: Int = 0
    val singleIndent: String = "    "

    var current_new_lines: Int = 0

    val code = StringBuilder()


    fun formatString(code: String): String {
        return ""
    }

    fun formatFile(path: String) {
        PipedFormatLexer(CharStreams.fromFileName(path)).apply {
            val _tokens = CommonTokenStream(this)
            _tokens.fill()
            val tokens = _tokens.tokens
            var reminder = skipToStartOfCode(tokens)

            formatNext(reminder)

            pasteReminder(reminder)

        }
        writeBackToFile("src/main/resources/formated.pd", code.toString())
    }

    fun skipToStartOfCode(tokens: List<Token>): List<Token> {

        return tokens.dropWhile {
            it.type == PipedFormatLexer.SPACE || it.type == PipedFormatLexer.NEWLINE
        }
    }


    fun pasteReminder(tokens: List<Token>) {
        tokens.forEach {
            code.append(it.text)
        }
    }


    fun writeBackToFile(path: String, code: String) {
        File(path).writeText(code)
    }

    fun formatNext(tokens: List<Token>): Any {
        return when (tokens.first().text) {
            "pi" -> {
                formatPipe(tokens)
            }

            else -> {
                return tokens
            }
        }
    }

    fun formatPipe(tokens: List<Token>): List<Token> {
        var reminder = appendNext(tokens)
        reminder = dropSpace(reminder)
        if (reminder.first().text == "(") {
            reminder = appendNext(reminder)
            reminder = dropSpace(reminder, 0)
        } else return reminder

        while (true) {
            if (reminder.first().text == ",") {
                reminder = appendNext(reminder)
                reminder = dropSpace(reminder, 1)
            } else if (reminder.first().text == ")") {
                reminder = appendNext(reminder)
                reminder = dropSpace(reminder, 0)
                break;
            } else return reminder
        }

        return reminder

    }

    fun appendNext(tokens: List<Token>): List<Token> {
        code.append(tokens.first().text)
        return tokens.drop(1)
    }

    fun dropSpace(tokens: List<Token>, allowed: Int = 1): List<Token> {
        var count = 0
        return tokens.dropWhile {
            if (it.type == PipedFormatLexer.SPACE || it.type == PipedFormatLexer.NEWLINE) {
                count++
                count <= allowed
            } else {
                false
            }
        }
    }

}


