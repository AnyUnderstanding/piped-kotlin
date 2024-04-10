package de.any.codegen

import PipedBaseVisitor
import de.any.analyzer.*
import java.io.File

class Generator(var currentScope: Scope) : PipedBaseVisitor<String>() {
    val llvmMethod: String = """
        define %s @%s(%s) nounwind {
               %s
        }
    """
    val llvmStruct = """
        %%%s = type { %s }
    """

    val llvmCall = """
        call %s @%s(%s)
    """

    var firstScope = false

    val lambdaName = "lambda$%d"

    val tempRegisterName = "%%temp$%d"

    val expressionCode = mutableListOf<String>()

    // the llvm code for all lambdas, which will be appended to the end of the file
    val lambdas = StringBuilder()


    override fun visitProgramm(ctx: PipedParser.ProgrammContext?): String {
        val out = ctx!!.globalScope().children.map { visit(it) }.filterNotNull()
            .joinToString(separator = "\n") { it } + "\n" + lambdas.toString()
        val outFile = File("out.ll")
        outFile.writeText(out)
        println(out)
        return out
    }


    override fun visitBundleDefinition(ctx: PipedParser.BundleDefinitionContext?): String {
        val bundle = TypeTable.findType(ctx!!.name.text)!! as Bundle
        val fields = bundle.fields.joinToString(separator = ", ") { getLLVMType(it.type) }
        return llvmStruct.format(bundle.name, fields)
    }

    override fun visitVar(ctx: PipedParser.VarContext?): String {
        return "%" + currentScope.findVariable(ctx!!.text)!!.name
    }

    override fun visitPipeDefinition(ctx: PipedParser.PipeDefinitionContext?): String {
        val name = ctx!!.name.text
        val pipe = PipeTable.findPipe(name)!!
        val parameters = pipe.parameters.joinToString { "${getLLVMType(it.type)} %${it.name}" }
        firstScope = true
        val body = visit(ctx.localScope())
        return llvmMethod.format(getLLVMType(pipe.returnType), pipe.name, parameters, body)
    }

    override fun visitLocalScope(ctx: PipedParser.LocalScopeContext?): String {
        currentScope = currentScope.nextChild()
        val result: String
        if (firstScope) {
            firstScope = false
            result = ctx!!.children.map { visit(it) }.filterNotNull().joinToString(separator = "\n") { it }
        } else {
            val body = ctx!!.children.map { visit(it) }.filterNotNull().joinToString(separator = "\n") { it }
            val lambdaName = nextLambdaName.next()
            val returnType = getLLVMType(currentScope.returnType!!)
            val parameters =
                currentScope.getReferencedVariables().joinToString(",") { getLLVMType(it.type) + " %" + it.name }
            lambdas.append(llvmMethod.format(returnType, lambdaName, parameters, body))
            val tempRegister = nextTempRegisterName.next()
            expressionCode.add(tempRegister + " = " + llvmCall.format(returnType, lambdaName, parameters))
            result = tempRegister
        }

        currentScope = currentScope.bubbleUp()
        return result
    }

    override fun visitReturn(ctx: PipedParser.ReturnContext?): String {
        val returnType = getLLVMType(currentScope.returnType!!)


        val (register, code) = evaluateExpression(ctx!!.expression())
        return "$code \n ret ${returnType} ${register}"
    }

    override fun visitAssign(ctx: PipedParser.AssignContext?): String {
        val variable = currentScope.findVariable(ctx!!.typedName().name.text)!!
        println("---")
        println(variable.name)
        println("---")
        return evaluateExpression(ctx.expression(), variable.name).second
    }

    override fun visitMulDiv(ctx: PipedParser.MulDivContext?): String {
        val left = visit(ctx!!.left)
        val right = visit(ctx.right)
        val register = nextTempRegisterName.next()

        expressionCode.add(
            "$register = " +
                    if (ctx.op.text == "*") {
                        "mul i32 $left, $right"
                    } else {
                        "sdiv i32 $left, $right"
                    }
        )
        return register
    }

    override fun visitAddSub(ctx: PipedParser.AddSubContext?): String {
        val left = visit(ctx!!.left)
        val right = visit(ctx.right)
        val register = nextTempRegisterName.next()

        expressionCode.add(
            "$register = " +
                    if (ctx.op.text == "+") {

                        "add i32 $left, $right"
                    } else {
                        "sub i32 $left, $right"
                    }
        )
        return register
    }

    override fun visitBOOL_OP(ctx: PipedParser.BOOL_OPContext?): String {
        val left = visit(ctx!!.left)
        val right = visit(ctx.right)

        val type = getLLVMType(TreeInfo.getType(ctx.left))

        val op = ctx.op.text
        val register = nextTempRegisterName.next()
        val instruction = when (op) {
            "==" -> "$register = icmp eq $type $left, $right"
            "!=" -> "$register = icmp ne $type $left, $right"
            "<" -> "$register = icmp slt $type $left, $right"
            "<=" -> "$register = icmp sle $type $left, $right"
            ">" -> "$register = icmp sgt $type $left, $right"
            ">=" -> "$register = icmp sge $type $left, $right"
            else -> throw IllegalArgumentException("Unknown operator")
        }
        expressionCode.add(instruction)

        return register
    }



    override fun visitValue_(ctx: PipedParser.Value_Context?): String {
        val type = getLLVMType(TreeInfo.getType(ctx!!.value()))
        val value = when (ctx!!.text) {
            "true" -> "add $type 1, 0"
            "false" -> "add $type 0, 0"
            else -> "add $type ${ctx.text}, 0"
        }
        val nextTempRegister = nextTempRegisterName.next()
        expressionCode.add("$nextTempRegister = $value")
        return nextTempRegister
    }



    fun getLLVMType(type: Type): String {
        return when (type) {
            PrimitiveType.INT.type -> "i32"
            PrimitiveType.VOID.type -> "void"
            PrimitiveType.BOOLEAN.type -> "i1"
            else -> throw IllegalArgumentException("Unknown type")
        }
    }

    val nextLambdaName = _nextLambdaName()
    fun _nextLambdaName() = iterator {
        var x = 0
        while (true) {
            yield(lambdaName.format(x))
            x++
        }
    }

    val nextTempRegisterName = _nextTempRegisterName()

    fun _nextTempRegisterName() = iterator {
        var x = 0
        while (true) {
            yield(tempRegisterName.format(x))
            x++
        }
    }

    // first element is the used register, second is the code
    fun evaluateExpression(ctx: PipedParser.ExpressionContext, alterLast: String? = null): Pair<String, String> {
        val register = visit(ctx)
        val code = getExpressionCode(if (alterLast != null) Pair(register, alterLast) else null)
        return Pair(register, code)
    }

    fun getExpressionCode(alterLast: Pair<String, String>? = null): String {
        if (alterLast != null) {
            val last = expressionCode.removeLastOrNull()?.replaceFirst(alterLast.first, "%" + alterLast.second)
            expressionCode.add(last ?: "")
        }
        val result = expressionCode.joinToString(separator = "\n") { it }
        expressionCode.clear()
        return result
    }
}