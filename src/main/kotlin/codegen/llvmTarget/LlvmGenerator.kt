package de.any.codegen.llvmTarget

import de.any.AST.*
import de.any.AST.Function
import de.any.codegen.CodeTargetGenerator

class LlvmGenerator(
    val assignmentTranslator: AssignmentTranslator,
    val expressionTranslator: ExpressionTranslator,
) : CodeTargetGenerator() {
    var labelCounter = 0

    override fun gen(expression: Program): String {
        require(expression is ILProgram) { "Program must be of type ILProgram" }
        visit(expression as ILProgram)
        addDeclarations()
        return code.toString()
    }

    fun addDeclarations() {
        useLine("declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2")
        useLine("declare i8* @malloc(i32) nounwind")
        appendBlock(printFunctionDeclare)
    }

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        appendCode(getFunctionDefinition(pipe))
        visitScope(pipe.body)
    }


    override fun visitFunction(function: Function, vararg args: Any) {
        appendCode(getFunctionDefinition(function))
        visitScope(function.body)
    }


    override fun visitBundle(bundle: Bundle, vararg args: Any) {
        appendCode("%${bundle.name} = type {")
        increaseIndent()
        joinLines(",") {
            bundle.fields.map { "${it.type.getLlvmName()}" }
        }
        decreaseIndent()

        useLine("}\n")
    }

    fun getFunctionDefinition(pipe: Pipe): String {
        val returnType = pipe.returnType.getLlvmNamePointer()
        val parameters = pipe.parameters.joinToString(", ") {
            if (it.type.isBundle()) {
                "${it.type.getLlvmName()}* %${it.name}"
            } else {
                "${it.type.getLlvmName()} %${it.name}"
            }
        }
        return "define $returnType @${pipe.name}($parameters) "
    }

    fun getFunctionDefinition(function: Function): String {
        val returnType = function.returnType.getLlvmNamePointer()
        val parameters = function.parameters.joinToString(", ") {
            if (it.type.isBundle()) {
                "${it.type.getLlvmName()}* %${it.name}"
            } else {
                "${it.type.getLlvmName()} %${it.name}"
            }
        }
        return "define $returnType @${function.name}($parameters) "
    }

    override fun visitScope(scope: Scope, vararg args: Any) {
        useLine("{")
        increaseIndent()
        super.visitScope(scope)
        decreaseIndent()
        useLine("}")
    }

    override fun visitAssignment(assignment: Assignment, vararg args: Any) {
        val translated = assignmentTranslator.gen(assignment)
        appendBlock(
            translated.code
        )

    }

    override fun visitExpression(expression: Expression, vararg args: Any) {
        val translated = expressionTranslator.gen(expression)
        appendBlock(translated.code)
    }

    override fun visitReturn(return_: Return, vararg args: Any) {
        val translated = expressionTranslator.gen(return_.expression)

        appendBlock(translated.code)
        useLine("ret ${return_.expression.type.getLlvmNamePointer()} ${translated.location}")
    }

    override fun visitConditional(conditional: Conditional, vararg args: Any) {
        val condition = expressionTranslator.gen(conditional.condition)
        appendBlock(condition.code)
        val trueLabel = getLabel()
        val falseLabel = getLabel()
        useLine("br i1 ${condition.location}, label %$trueLabel, label %$falseLabel")
        useLine("$trueLabel:")
        visitReturn(conditional.thenBranch)
        useLine("$falseLabel:")
    }

    override fun visitPreDefinedNode(predefined: PreDefinedNode, vararg args: Any) {
        appendBlock(predefined.content)
    }

    fun getLabel(): String {
        return "label${labelCounter++}"
    }


}
