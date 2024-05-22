package de.any

import de.any.AST.ASTVisitor
import de.any.AST.ILASTVisitor
import de.any.AST.ILProgram
import de.any.AST.Program
import de.any.codegen.CodeGenerator
import de.any.codegen.CodeTargetGenerator
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.TokenSource
import org.antlr.v4.runtime.TokenStream
import java.util.concurrent.TimeUnit

interface Stage {
    fun printAst(): Stage
}


class Compiler {
    val timer: Timer = Timer()
    var tokenCount = 0

    init {
        timer.start()
    }

    fun fromFile(path: String): RawCodeStage {
        return RawCodeStage(
            CharStreams.fromFileName(path),
            this
        )
    }

    fun fromString(code: String): RawCodeStage {
        return RawCodeStage(
            CharStreams.fromString(code),
            this
        )
    }

}


class RawCodeStage(
    private val rawCode: CharStream,
    val compiler: Compiler
) : Stage {
    fun tokenize(lexer: (code: CharStream) -> TokenSource): LexerStage {
        return LexerStage(CommonTokenStream(lexer(rawCode)), compiler)
    }

    override fun printAst(): RawCodeStage {
        throw IllegalAccessError("No AST available")
    }
}

class LexerStage(
    private val tokens: TokenStream,
    val compiler: Compiler
) : Stage {
    fun <T> toAst(body: (tokens: TokenStream) -> T): ParserStage<T> {
        // TODO get token count
        return ParserStage<T>(body(tokens), compiler)

    }

    override fun printAst(): LexerStage {
        throw IllegalAccessError("No AST available")
    }
}

class ParserStage<T>(
    val ast: T,
    val compiler: Compiler
) : Stage {
    fun addAstTranslator(translator: (T) -> Program): AnalyzerStage {
        return AnalyzerStage(translator(ast), compiler)
    }

    override fun printAst(): ParserStage<T> {
        println(ast)
        return this
    }
}

class AnalyzerStage(
    val ast: Program,
    val compiler: Compiler
) : Stage {
    fun addSteps(vararg steps: ASTVisitor): ILStage {

        steps.forEach {
            it.visit(ast)
        }
        return ILStage(ast, compiler)
    }

    override fun printAst(): AnalyzerStage {
        println(ast)
        return this
    }
}

class ILStage(
    ast: Program, val compiler: Compiler
) : Stage {
    val ilAst: ILProgram = ILProgram(ast, mutableListOf())

    fun addILSteps(vararg steps: ILASTVisitor): CodegenStage {

        steps.forEach {
            it.visit(ilAst)
        }
        return CodegenStage(ilAst, compiler)
    }

    fun skipILStage(): CodegenStage {
        return CodegenStage(ilAst, compiler)
    }

    override fun printAst(): ILStage {
        println(ilAst)
        return this
    }
}

class CodegenStage(
    val ast: ILProgram, val compiler: Compiler
) : Stage {
    fun addGenerator(generator: CodeTargetGenerator): OutPutStage {
        return OutPutStage(generator.gen(ast), compiler)
    }

    override fun printAst(): CodegenStage {
        println(ast)
        return this
    }
}

class OutPutStage(
    val output: String, val compiler: Compiler
) : Stage {
    init {
        compiler.timer.stop()
    }

    fun showStats(): OutPutStage {
        println("Compilation took: ${compiler.timer.getReadableDuration()}")
        // println("Token count: ${compiler.tokenCount}")
        return this
    }

    fun toFile(path: String) {
        java.io.File(path).writeText(output)
    }

    fun print() {
        println(output)
    }

    override fun printAst(): OutPutStage {
        throw IllegalAccessError("No AST available")
    }

    override fun toString(): String {
        return output
    }
}


class Timer {
    private var start: Long = 0
    private var end: Long = 0

    fun start() {
        start = System.currentTimeMillis()
    }

    fun stop() {
        end = System.currentTimeMillis()
    }

    fun duration(): Long {
        return end - start
    }

    fun getReadableDuration(): String {
        val millis = duration()
        val minutes = TimeUnit.MILLISECONDS.toMinutes(millis)
        val seconds =
            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        val ms = millis - TimeUnit.SECONDS.toMillis(seconds) - TimeUnit.MINUTES.toMillis(minutes)
        return String.format(
            "%d min, %d sec, %d ms",
            minutes, seconds, ms
        );
    }
}

