package de.any.codegen.llvmTarget

import de.any.AST.*
import de.any.analyzer.BundleTable
import de.any.codegen.AstNodeTranslator

class ExpressionTranslator : AstNodeTranslator<Expression>() {

    companion object {
        var expressionCounter = -1
    }

    override fun gen(node: Expression): TranslationResult {
        visitExpression(node)
        return TranslationResult(code.toString(), location)
    }

    override fun visitValue(value: Value, vararg args: Any) {
        super.visitValue(value, *args)
        val name = createVariableName()
        location = name
        useLine("$name = add ${value.type.getLlvmName()} ${value.value}, 0");
    }

    override fun visitBundleInit(bundleInit: BundleInit, vararg args: Any) {
        // generate expressions for constructor
        val locations = bundleInit.initializers.map {
            gen(it)
        }

        // alloc bundle
        val name = createVariableName()
        location = name
        useLine("$name = alloca ${bundleInit.type.getLlvmName()}")

        // store values
        repeat(bundleInit.initializers.size) {
            val fieldPointer = getBundleFieldPointer(bundleInit.type, name, it)
            useLine("store ${bundleInit.initializers[it].type.getLlvmName()} ${locations[it].location}, ptr ${fieldPointer}")

        }

    }

    override fun visitMulDivExpression(mulDivExpression: MulDivExpression, vararg args: Any) {
        val left = gen(mulDivExpression.left)
        val right = gen(mulDivExpression.right)
        val name = createVariableName()
        location = name
        useLine("$name = ${if (mulDivExpression.operand == "*") "mul" else "sdiv"} ${mulDivExpression.left.type.getLlvmName()} ${left.location}, ${right.location}")
    }

    override fun visitAddSubExpression(expression: AddSubExpression, vararg args: Any) {
        val left = gen(expression.left)
        val right = gen(expression.right)
        val name = createVariableName()
        location = name
        useLine("$name = ${if (expression.operand == "+") "add" else "sub"} ${expression.left.type.getLlvmName()} ${left.location}, ${right.location}")
    }

    override fun visitVariable(variable: Variable, vararg args: Any) {
        if (variable.path.size == 1) {
            location =
                ("%" + (AssignmentTranslator.assignmentTracking[variable.getIdentifier()] ?: variable.getIdentifier()))
            return
        }
        val pointer = getBundleFieldPointer(variable)
        val name = createVariableName()
        location = name
        useLine("$name = load ${variable.type.getLlvmName()}, ${variable.type.getLlvmName()}* ${pointer}")
    }

    override fun visitParenthesis(parenthesis: Parenthesis, vararg args: Any) {
        val expression = gen(parenthesis.expression)
        location = expression.location
    }

    override fun visitBoolOpExpression(boolExpression: BoolExpression, vararg args: Any) {
        val left = gen(boolExpression.left)
        val right = gen(boolExpression.right)
        val name = createVariableName()
        location = name
        useLine(
            "$name = ${
                when (boolExpression.operand) {
                    "==" -> "icmp eq"
                    "!=" -> "icmp ne"
                    "<" -> "icmp slt"
                    "<=" -> "icmp sle"
                    ">" -> "icmp sgt"
                    ">=" -> "icmp sge"
                    else -> throw IllegalArgumentException("Unknown operand ${boolExpression.operand}")
                }
            } ${boolExpression.left.type.getLlvmName()} ${left.location}, ${right.location}"
        )
    }

    override fun visitFunctionCall(expression: FunctionCall, vararg args: Any) {
        val args = expression.parameters.map { gen(it).location }.zip(expression.parameters).map {
            "${it.second.type.getLlvmName()} ${it.first}"
        }
        val name = createVariableName()
        location = name
        useLine("$name = call ${expression.type.getLlvmNamePointer()} " + "@${expression.name}(${args.joinToString(", ")})")
    }

    fun getBundleFieldPointer(bundle: Type, storedVariable: String, index: Int): String {
        val name = createVariableName()
        useLine("$name = getelementptr ${bundle.getLlvmName()}, ptr ${storedVariable}, i32 0, i32 ${index}")
        return name
    }


    fun getBundleFieldPointer(expression: Variable): String {
        println(expression)
        println(expression.referencedBundle)
        val firstBundleType = expression.referencedBundle
        val bundle = BundleTable.getBundleByTypeStrict(firstBundleType)
        val variableName = AssignmentTranslator.assignmentTracking[expression.getIdentifier()]
        var previousBundle: Bundle? = bundle
        val pointerPath = expression.getPathWithoutIdentifier().map {
            val field = previousBundle?.getField(it)!!
            val index = previousBundle?.getFieldIndex(it)!!
            previousBundle = BundleTable.getBundleByType(field.type)
            "i32 ${index}"
        }.joinToString(", ")

        val name = createVariableName()

        useLine(
            "${name} = getelementptr ${firstBundleType.getLlvmName()}, ptr %${variableName}, i32 0, ${pointerPath}"
        )
        return name
    }

    fun createVariableName(): String {
        expressionCounter++
        return "%v$$expressionCounter"
    }

}