package de.any

import de.any.AST.ASTVisitor
import de.any.AST.Program
import de.any.codegen.CodeGenerator
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.TokenSource
import org.antlr.v4.runtime.TokenStream

interface Stage {
    fun printAst() : Stage
}


object Compiler {
    fun fromFile(path: String): RawCodeStage {
        return RawCodeStage(
            CharStreams.fromFileName(programm)
        )
    }

    fun fromString(code: String): RawCodeStage {
        return RawCodeStage(
            CharStreams.fromString(code)
        )
    }
}


class RawCodeStage(private val rawCode: CharStream) : Stage {
    fun tokenize(lexer: (code: CharStream) -> TokenSource): LexerStage {
        return LexerStage(CommonTokenStream(lexer(rawCode)))
    }

    override fun printAst() : RawCodeStage {
        throw IllegalAccessError("No AST available")
    }
}

class LexerStage(private val tokens: TokenStream) : Stage {
    fun <T> toAst(body: (tokens: TokenStream) -> T): ParserStage<T> {
        return ParserStage<T>(body(tokens))

    }

    override fun printAst() : LexerStage {
        throw IllegalAccessError("No AST available")
    }
}

class ParserStage<T>(val ast: T) : Stage {
    fun addAstTranslator(translator: (T) -> Program): AnalyzerStage {
        return AnalyzerStage(translator(ast))
    }

    override fun printAst() : ParserStage<T> {
        println(ast)
        return this
    }
}

class AnalyzerStage(val ast: Program) : Stage {
    fun addSteps(vararg steps: ASTVisitor): CodegenStage {

        steps.forEach {
            it.visit(ast)
        }
        return CodegenStage(ast)
    }

    override fun printAst() : AnalyzerStage {
        println(ast)
        return this
    }
}

class CodegenStage(val ast: Program) : Stage {
    fun addGenerator(generator: CodeGenerator): OutPutStage {
        return OutPutStage(generator.gen(ast))
    }

    override fun printAst() : CodegenStage {
        println(ast)
        return this
    }
}

class OutPutStage(val output: String) : Stage {
    fun toFile(path: String) {
        // write to file

    }

    fun print() {
        println(output)
    }

    override fun printAst() : OutPutStage {
        throw IllegalAccessError("No AST available")
    }

    override fun toString(): String {
        return output
    }
}