package de.any.normalize

import de.any.AST.*
import de.any.AST.Function
import de.any.analyzer.BundleTable

class PipelineSeparatorRework(val bundleTable: BundleTable) : ILASTVisitor() {
    val functions: MutableList<Function> = mutableListOf()
    private val guardPrefix = "guard$"
    private val pipelineVariablePrefix = "pipelineVar$"
    private var pipeLineVariableIndex = 0

    private val pipelinePrefix = "pipeline$"

    companion object {
        var pipeLineIndex = 0
        var guardIndex = 0
    }

    override fun visit(program: ILProgram, vararg args: Any) {
        super.visit(program, *args)
        program.functions.addAll(functions)
    }


    override fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {
        SubPipelineSeparator(bundleTable, pipeLine).separate().apply {
            functions.addAll(this)
        }
        // find variables that need to be captured
        val capturedVariables = getCapturedVariables(pipeLine)

        val functionDefinition =
            getFunctionDefinition(pipeLine, capturedVariables.map { Field(it.getPathAsString(), it.type) })


        val functionCall = FunctionCall(functionDefinition.name, capturedVariables.toMutableList().map {
            if (it.path.size > 1)
                Variable(
                    it.path.toMutableList(),
                    it.type,
                    it.referencedBundle
                )
            else Variable(
                it.path.toMutableList(),
                it.type,
            )
        }, functionDefinition.returnType)

        val scope = separatePipeline(pipeLine, capturedVariables)

        val function = Function(
            functionDefinition.name,
            functionDefinition.returnType,
            functionDefinition.args,
            scope
        )


        replacePipeline(pipeLine, functionCall)
        functions.add(function)
    }

    fun separateSubPipeline(pipeLine: PipeLine): List<Function> {
        visitPipeLine(pipeLine)
        try {
            return functions.toMutableList()
        } finally {
            functions.clear()
        }
    }

    private fun separatePipeline(pipeLine: PipeLine, capturedVariables: List<Variable>): Scope {
        val scope = Scope(mutableListOf())

        // handle first tuple
        val first = pipeLine.elements.first()
        require(first is PipeLineTuple) { "The first element must be a PipeLineTuple, this Exception should never be thrown" }
        val firstExpressions = first.expressions.toMutableList()
        firstExpressions.forEach { VariablePathFlattener.flatten(it) }
        val firstAssignment = Assignment(
            newPipelineVariableName(),
            first.type,
            if (first.type.isTuple()) Tuple(firstExpressions, first.type) else firstExpressions.first()
        )
        scope.children.add(firstAssignment)

        // handle the remaining elements
        var result = firstAssignment
        for (element in pipeLine.elements.drop(1)) {
            result = handlePipelineElement(element, result.getAsVariable(), capturedVariables)
            scope.children.add(result)
        }

        // handle last Assignment by turning it into a return
        val lastExpression = (scope.children.removeLast() as Assignment).expression
        scope.children.add(
            Return(
                lastExpression
            )
        )

        return scope
    }

    /**
     * turns a pipelineElement into an Assignment in the form of
     * pipelineVar$\d+ : <Type> = [func(...)/(...)]
     *
     * This method may not be called for the first element in a pipeline
     *
     * @see handlePipelineTuple
     */
    private fun handlePipelineElement(
        element: PipeLineElement,
        previousResult: Variable,
        capturedVariables: List<Variable>
    ): Assignment {
        return when (element) {
            is PipeLineTuple -> handlePipelineTuple(element, previousResult)
            is PipeCall -> handlePipeCall(element, previousResult)
            is GuardedPipeCall -> handleGuardedPipeCall(element, previousResult, capturedVariables)
            else -> error("This should not happen")

        }
    }

    /**
     * turns a pipelineElement into an Assignment in the form of
     * pipelineVar$\d+ : <Type> = (...)
     *
     * This method may not be called for the first element in a pipeline
     * @see handlePipelineElement
     */
    private fun handlePipelineTuple(tuple: PipeLineTuple, previousResult: Variable): Assignment {
        // handle placeholder
        tuple.expressions.forEachIndexed { index, it ->
            if (it is PipeLineTuplePlaceholder) {
                val path = mutableListOf(previousResult.getPathAsString())

                if (previousResult.type.isTuple()) {
                    path.add(
                        TupleTranslator.fieldPrefix + it.index
                    )
                }

                tuple.expressions[index] = Variable(path, it.type, tuple.type)
            }
            VariablePathFlattener.flatten(it)
        }

        // transform into Assignment
        return Assignment(
            newPipelineVariableName(),
            tuple.type,
            if (tuple.type.isBasicType()) tuple.expressions.first() else Tuple(tuple.expressions, tuple.type)
        )
    }

    /**
     * turns a pipelineElement into an Assignment in the form of
     * pipelineVar$\d+ : <Type> = func(...)
     *
     * This method may not be called for the first element in a pipeline
     * @see handlePipelineElement
     */
    private fun handlePipeCall(call: PipeCall, previousResult: Variable): Assignment {
        val args = previousResult.type.getChildren(bundleTable).mapIndexed() { index, type ->
            val path = mutableListOf(previousResult.getPathAsString())
            if (previousResult.type.isTuple()) {
                path.add(
                    TupleTranslator.fieldPrefix + index
                )
            }
            Variable(
                path,
                type,
                previousResult.type
            )
        }


        return Assignment(
            newPipelineVariableName(),
            call.type,
            FunctionCall(
                call.name,
                args,
                call.type
            )
        )
    }

    private fun handleGuardedPipeCall(
        call: GuardedPipeCall,
        previousResult: Variable,
        capturedVariables: List<Variable>
    ): Assignment {
        val functionName = newGuard()
        val outType = call.type

        val callArgs = if (previousResult.type.isTuple()) {
            previousResult.type.getChildren(bundleTable).mapIndexed { index, type ->
                Variable(
                    mutableListOf(previousResult.getIdentifier(), TupleTranslator.fieldPrefix + index),
                    type,
                    previousResult.type
                )
            }
        } else {
            listOf(previousResult)
        }
        val funcArgs = call.parameters
        val func = Function(
            functionName,
            outType,
            funcArgs + capturedVariables.map { Field(it.getPathAsString(), it.type) },
            buildGuardScope(call)
        )

        functions.add(func)

        val functionCall = FunctionCall(
            functionName,
            callArgs + capturedVariables,
            outType
        )

        return Assignment(
            newPipelineVariableName(),
            outType,
            functionCall
        )


    }

    private fun buildGuardScope(call: GuardedPipeCall): Scope {
        val scope = Scope(
            call.guards.map {
                Conditional(
                    it.guardExpression,
                    Return(it.returnExpression)
                )
            }.toMutableList()
        )
        scope.children.add(Return(call.elseGuard.returnExpression))
        return scope
    }

    private fun getCapturedVariables(pipeLine: PipeLine): List<Variable> {
        val capturedVariables: MutableList<Variable> = mutableListOf()
        pipeLine.elements.forEach {
            if (it is PipeLineTuple) {
                // create mappings for captured variables
                capturedVariables.addAll(PipelineTupleVariableCapturer().getCapturedVariables(it))
            }
        }
        return capturedVariables.distinctBy { it.getPathAsString() }
    }


    private fun getFunctionDefinition(pipeLine: PipeLine, capturedVariables: List<Field>): FunctionDefinition {
        val outType = pipeLine.elements.last().type
        return FunctionDefinition(
            newPipelineName(),
            outType,
            capturedVariables
        )

    }

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

            is Guard -> {
                parent.returnExpression = functionCall
            }

            is ElseGuard -> {
                parent.returnExpression = functionCall
            }

            else -> error("Unknown parent type $parent")
        }
    }


    private fun newPipelineName() = pipelinePrefix + pipeLineIndex++
    private fun newPipelineVariableName() = pipelineVariablePrefix + pipeLineVariableIndex++
    private fun newGuard() = guardPrefix + guardIndex++
}


class PipelineTupleVariableCapturer : ILASTVisitor() {
    private val capturedVariables = mutableListOf<Variable>()
    fun getCapturedVariables(pipelineTuple: PipeLineTuple): List<Variable> {
        capturedVariables.clear()
        visitPipeLineTuple(pipelineTuple)
        return capturedVariables
    }

    override fun visitVariable(variable: Variable, vararg args: Any) {
        if (capturedVariables.contains(variable)) return
        capturedVariables.add(variable)
    }
}

class VariablePathFlattener : ILASTVisitor() {
    companion object {
        fun flatten(expression: Expression) {
            VariablePathFlattener().visitExpression(expression)
        }
    }


    override fun visitVariable(variable: Variable, vararg args: Any) {
        if (variable.path.size > 1) {
            variable.path = listOf(variable.getPathAsString())
        }
    }
}

class SubPipelineSeparator(val bundleTable: BundleTable, val pipeLine: PipeLine) : ILASTVisitor() {
    val functions = mutableListOf<Function>()
    override fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {

        super.visitPipeLine(pipeLine, *args)
        if (pipeLine != this.pipeLine)
            PipelineSeparatorRework(bundleTable).separateSubPipeline(pipeLine).apply {
                functions.addAll(this)
            }

    }

    fun separate(): MutableList<Function> {
        visitPipeLine(pipeLine)
        return functions
    }
}

class FunctionDefinition(
    val name: String,
    val returnType: Type,
    val args: List<Field>,
)