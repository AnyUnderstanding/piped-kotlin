package de.any.codegen.llvmTarget

import de.any.AST.*
import de.any.analyzer.BundleTable
import de.any.codegen.AstNodeTranslator

/**
 * ExpressionTranslator is responsible for translating AST expressions into LLVM code.
 * It extends the AstNodeTranslator to leverage the visitation pattern for different
 * types of expressions.
 *
 * @property bundleTable Table containing bundle definitions for type resolution.
 */
class ExpressionTranslator(val bundleTable: BundleTable) : AstNodeTranslator<Expression>() {

    /**
     * A companion object for the ExpressionTranslator class.
     */
    companion object {
        /**
         * Tracks the number of expressions encountered and translated.
         *
         * This variable is used to generate unique variable names for each expression.
         * It is incremented each time a new variable name is created.
         */
        var expressionCounter = -1
    }


    override fun gen(node: Expression): TranslationResult {
        code.clear()
        visitExpression(node)
        return TranslationResult(code.toString(), location)
    }

    /**
     * Generates a subexpression for the given node.
     * This means this should be called recursively if the current expression requires the evaluation of another expression
     *
     * @param node The expression node for which the subexpression is generated.
     * @return The translation result containing the generated code and location.
     */
    private fun genSubexpression(node: Expression): TranslationResult {
        visitExpression(node)
        return TranslationResult(code.toString(), location)
    }

    /**
     * Visits a `Value` expression and processes it within the current translation context.
     *
     * @param value The `Value` node to visit and process.
     * @param args Additional arguments for handling the `Value` node.
     */
    override fun visitValue(value: Value, vararg args: Any) {
        super.visitValue(value, *args)
        val name = createVariableName()
        location = name
        useLine("$name = add ${value.type.getLlvmName()} ${value.value}, 0");
    }

    /**
     * Visits a `BundleInit` expression and generates the necessary code for bundle initialization.
     *
     * @param bundleInit The `BundleInit` expression representing the initialization of a bundle.
     * @param args Additional arguments, if any, required for processing the bundle initialization.
     */
    override fun visitBundleInit(bundleInit: BundleInit, vararg args: Any) {
        // generate expressions for constructor
        val locations = bundleInit.initializers.map {
            genSubexpression(it)
        }

        // alloc bundle
        val bundle = bundleTable.getBundleByTypeStrict(bundleInit.type)

        val mallocVariable = createVariableName()

        useLine("$mallocVariable = call i8* @malloc(i32 ${bundle.getByteCount(bundleTable)})")
        val name = createVariableName()
        location = name
        useLine("$name = bitcast i8* $mallocVariable to ${bundleInit.type.getLlvmName()}*")

        // store values
        repeat(bundleInit.initializers.size) {
            val fieldPointer = getBundleFieldPointer(bundleInit.type, name, it)
            val initializer = bundleInit.initializers[it]
            if (initializer.type.isBundle()) {
                val bundle = bundleTable.getBundleByTypeStrict(initializer.type)
                val dest = fieldPointer
                val src = locations[it].location
                val castedDest = createVariableName()
                val castedSrc = createVariableName()
                useLine("$castedDest = bitcast ptr $dest to i8*")
                useLine("$castedSrc = bitcast ptr $src to i8*")
                useLine(
                    "   call void @llvm.memcpy.p0.p0.i32(ptr $castedDest, ptr $castedSrc, i32 ${
                        bundle.getByteCount(
                            bundleTable
                        )
                    }, i1 0)\n"
                )
                return
            }
            useLine("store ${initializer.type.getLlvmName()} ${locations[it].location}, ptr ${fieldPointer}")

        }

    }

    /**
     * Translates a multiplication or division expression into LLVM intermediate representation (IR).
     *
     * @param mulDivExpression The multiplication or division expression node to be translated.
     * @param args Additional arguments that may be required for translation.
     */
    override fun visitMulDivExpression(mulDivExpression: MulDivExpression, vararg args: Any) {
        val left = genSubexpression(mulDivExpression.left)
        val right = genSubexpression(mulDivExpression.right)
        val name = createVariableName()
        location = name
        useLine("$name = ${if (mulDivExpression.operand == "*") "mul" else "sdiv"} ${mulDivExpression.left.type.getLlvmName()} ${left.location}, ${right.location}")
    }

    /**
     * Processes an `AddSubExpression` node, generating the appropriate code for addition or subtraction,
     * and sets the location for the resultant variable.
     *
     * @param expression The `AddSubExpression` instance containing the left and right expressions
     * along with the operand indicating addition ("+") or subtraction ("-").
     * @param args Additional arguments that might be required for code generation.
     */
    override fun visitAddSubExpression(expression: AddSubExpression, vararg args: Any) {
        val left = genSubexpression(expression.left)
        val right = genSubexpression(expression.right)
        val name = createVariableName()
        location = name
        useLine("$name = ${if (expression.operand == "+") "add" else "sub"} ${expression.left.type.getLlvmName()} ${left.location}, ${right.location}")
    }

    /**
     * Visits a variable expression and generates the appropriate LLVM instructions for its representation.
     * If the variable is a simple variable (with a path size of 1), it assigns the location based on the
     * assignment tracking data. Otherwise, it computes a pointer to the bundle field and generates a load
     * instruction for the variable.
     *
     * @param variable The variable expression to visit.
     * @param args Additional arguments for the visit, if any.
     */
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

    /**
     * Visits a Parenthesis expression node and generates the corresponding subexpression.
     *
     * @param parenthesis The Parenthesis expression node to visit.
     * @param args Additional arguments that may be used during the visit.
     */
    override fun visitParenthesis(parenthesis: Parenthesis, vararg args: Any) {
        val expression = genSubexpression(parenthesis.expression)
        location = expression.location
    }

    /**
     * Visits a boolean operation expression and generates the corresponding LLVM code.
     *
     * @param boolExpression The boolean expression node containing the left and right sub-expressions,
     *                       and the operand (e.g., "==", "!=", "<", "<=", ">", ">=").
     * @param args Additional arguments for the expression visitor, not used in this method.
     */
    override fun visitBoolOpExpression(boolExpression: BoolExpression, vararg args: Any) {
        val left = genSubexpression(boolExpression.left)
        val right = genSubexpression(boolExpression.right)
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

    /**
     * Visits a `FunctionCall` node in the abstract syntax tree and generates corresponding LLVM code.
     *
     * @param expression The `FunctionCall` expression containing the function name and its parameters.
     * @param args Additional arguments that can be provided to customize the behavior of the method.
     */
    override fun visitFunctionCall(expression: FunctionCall, vararg args: Any) {
        val args = expression.parameters.map { genSubexpression(it).location }.zip(expression.parameters).map {
            "${it.second.type.getLlvmName()} ${it.first}"
        }
        val name = createVariableName()
        location = name
        useLine("$name = call ${expression.type.getLlvmNamePointer()} " + "@${expression.name}(${args.joinToString(", ")})")
    }


    /**
     * Generates and returns a pointer to a specific field in a given bundle.
     *
     * @param bundle The Type representing the bundle from which the field pointer is to be retrieved.
     * @param storedVariable The name of the variable where the bundle is stored.
     * @param index The zero-based index of the field within the bundle for which the pointer is to be retrieved.
     * @return The name of the pointer variable pointing to the specified field in the bundle.
     */
    fun getBundleFieldPointer(bundle: Type, storedVariable: String, index: Int): String {
        val name = createVariableName()
        useLine("$name = getelementptr ${bundle.getLlvmName()}, ptr ${storedVariable}, i32 0, i32 ${index}")
        return name
    }


    /**
     * Retrieves a pointer to a specific field within a bundle.
     *
     * @param expression The variable expression representing the desired field in the bundle.
     * @return A string containing the LLVM IR pointer to the specific field within the bundle.
     */
    fun getBundleFieldPointer(expression: Variable): String {
        val firstBundleType = expression.referencedBundle
        val bundle = bundleTable.getBundleByTypeStrict(firstBundleType)
        val variableName = AssignmentTranslator.assignmentTracking[expression.getIdentifier()]
        var previousBundle: Bundle? = bundle
        val pointerPath = expression.getPathWithoutIdentifier().map {
            val field = previousBundle?.getField(it)!!
            val index = previousBundle?.getFieldIndex(it)!!
            previousBundle = bundleTable.getBundleByType(field.type)
            "i32 ${index}"
        }.joinToString(", ")

        val name = createVariableName()

        useLine(
            "${name} = getelementptr ${firstBundleType.getLlvmName()}, ptr %${variableName}, i32 0, ${pointerPath}"
        )
        return name
    }

    /**
     * Generates a unique variable name using an internal counter.
     * Each call increments the counter and returns a variable name
     * following the pattern %v$ followed by the current counter value.
     *
     * @return the newly created variable name as a String
     */
    fun createVariableName(): String {
        expressionCounter++
        return "%v$$expressionCounter"
    }

}