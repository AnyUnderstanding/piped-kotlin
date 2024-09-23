package de.any.normalize

import de.any.AST.*
import de.any.AST.Function
import de.any.analyzer.BundleTable

class PipelineSeparatorRework(val bundleTable: BundleTable) : ILASTVisitor() {
    val functions: MutableList<Function> = mutableListOf()
    var index = 0
    var scopeIndex = 0

    override fun visit(program: ILProgram, vararg args: Any) {
        super.visit(program, *args)
        program.functions.addAll(functions)
    }

    override fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {
        val assignments = mutableListOf<Assignment>()


        val (assignment, args_) = handleFirstElement(
            pipeLine.elements.first()
        )

        assignment?.let { assignments.add(it) }

        pipeLine.elements.drop(1).fold(args_) { acc, element ->
            val (newAssignment, newArgs) = handlePipelineElement(element, acc)
            newAssignment?.let { assignments.add(it) }
            newArgs
        }

        functions.add(
            createFunction(
                args_.map { it.type },
                pipeLine.type,
                assignments
            )
        )
        replacePipeline(
            pipeLine,
            FunctionCall(
                "pipeLine${index++}",
                (pipeLine.elements.first() as PipeLineTuple).expressions,
                pipeLine.type
            )
        )
    }

    /**
     * Replaces a pipeline with a function call
     * @param pipeLine the pipeline to be replaced
     * @param functionCall the function call to replace the pipeline with
     */
    fun replacePipeline(pipeLine: PipeLine, functionCall: FunctionCall) {
        val parent = pipeLine.parent
        functionCall.parent = parent
        when (parent) {
            is Scope -> {
                parent.children = parent.children.map { if (it == pipeLine) functionCall else it }.toMutableList()
            }

            is InfixOperation -> {
                if (parent.left == pipeLine) {
                    parent.left = functionCall
                } else {
                    parent.right = functionCall
                }
            }

            is Assignment -> {
                parent.expression = functionCall
            }

            is PipeLineTuple -> {
                parent.expressions = parent.expressions.map { if (it == pipeLine) functionCall else it }.toMutableList()
            }

            is Tuple -> {
                parent.elements = parent.elements.map { if (it == pipeLine) functionCall else it }.toMutableList()
            }

            is Return -> {
                parent.expression = functionCall
            }

            is Parenthesis -> {
                parent.expression = functionCall
            }

            is BundleInit -> {
                parent.initializers =
                    parent.initializers.map { if (it == pipeLine) functionCall else it }.toMutableList()
            }

            else -> error("Unknown parent type $parent")
        }
    }

    fun createFunction(
        args: List<Type>,
        returnType: Type,
        assignments: List<Assignment>
    ): Function {
        return Function(
            "pipeLine$index",
            returnType,
            args.mapIndexed { index, type -> Field("field$index", type) },
            createScope(assignments)
        )
    }

    fun createScope(assignments: List<Assignment>): Scope {
        return Scope(
            (assignments.dropLast(1) + Return(assignments.last().expression)).toMutableList()
        )
    }


    /**
     * Handles the first element of a pipeline
     * @param first the first element of the pipeline
     * @return the assignment and the arguments to be passed to the next element
     */
    fun handleFirstElement(first: PipeLineElement): Pair<Assignment?, List<Variable>> {
        require(first is PipeLineTuple) { "First element of pipeline must be a tuple" }

        val assignmentName = getVariableName()

        if (first.expressions.isEmpty()) {
            return Pair(null, emptyList())
        }

        return Pair(
            Assignment(
                assignmentName,
                getTupleType(first.expressions),
                getExpressionFromPipelineTuple(first)
            ),
            getArgs(assignmentName, first.type)
        )
    }


    fun getExpressionFromPipelineTuple(
        tuple: PipeLineTuple,
    ): Expression {
        val expectedType = getTupleType(tuple.expressions)
        if (tuple.expressions.size == 1) {
            return tuple.expressions.first()
        }
        return Tuple(tuple.expressions, expectedType)
    }

    fun handlePipelineElement(
        element: PipeLineElement,
        args: List<Variable>,
    ): Pair<Assignment?, List<Variable>> {
        return when (element) {
            is PipeCall -> handlePipeCall(element, args)
            is PipeLineTuple -> handlePipeLineTuple(element, args)
            is GuardedPipeCall -> handleGuardedPipeCall(element, args)
            else -> error("Unreachable")
        }
    }

    private fun handleGuardedPipeCall(
        element: GuardedPipeCall,
        args: List<Variable>
    ): Pair<Assignment?, List<Variable>> {
        TODO("Not implemented yet")
    }

    private fun handlePipeLineTuple(element: PipeLineTuple, args: List<Variable>): Pair<Assignment?, List<Variable>> {
        val expressions = element.expressions.map {
            if (it is PipeLineTuplePlaceholder) {
                args[it.index]
            } else {
                it
            }
        }

        val assignmentName = getVariableName()

        return Pair(
            Assignment(
                assignmentName,
                getTupleType(expressions),
                element
            ),
            getArgs(assignmentName, element.type)
        )
    }

    fun handlePipeCall(
        pipeCall: PipeCall,
        args: List<Variable>,
    ): Pair<Assignment?, List<Variable>> {
        val assignmentName = getVariableName()

        val functionCall = FunctionCall(
            pipeCall.name,
            args,
            pipeCall.type
        )
        return Pair(
            Assignment(
                assignmentName,
                functionCall.type,
                functionCall
            ),
            getArgs(assignmentName, pipeCall.type)
        )
    }

    /**
     * gets the arguments for the next pipe given the bundle name and the expressions
     * @param name the name of the bundle
     * @param type the type of the bundle
     */

    fun getArgs(name: String, type: Type): List<Variable> {
        if (type.isBasicType()) {
            return listOf(Variable(listOf(name), type))
        }
        return type.getChildren(bundleTable).mapIndexed { index, it ->
            Variable(
                listOf(name, "field$index"),
                it,
                type
            )
        }
    }

    fun getTupleType(expressions: List<Expression>): Type {
        if (expressions.size == 1) {
            return expressions.first().type
        }
        return Type(expressions.map { it.type })
    }

    fun getVariableName(): String {
        return "pipeLineVar${scopeIndex++}"
    }
}