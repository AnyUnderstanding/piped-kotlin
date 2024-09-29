package de.any.normalize

import de.any.AST.*
import de.any.AST.Function
import de.any.analyzer.BundleTable

class PipelineSeparatorRework(val bundleTable: BundleTable) : ILASTVisitor() {
    val functions: MutableList<Function> = mutableListOf()
    private val capturedVariables = mutableListOf<Field>()
    private val fieldPrefix = "field$"
    private var fieldIndex = 0
    private var pipelineVariablePrefix = "pipelineVar$"
    private var pipeLineVariableIndex = 0

    private val pipelinePrefix = "pipeline$"

    companion object {
        var pipeLineIndex = 0
    }

    override fun visit(program: ILProgram, vararg args: Any) {
        capturedVariables.clear()
        super.visit(program, *args)
        program.functions.addAll(functions)
    }

    override fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {
        // find variables that need to be captured
        getCapturedVariables(pipeLine)
        val functionDefinition = getFunctionDefinition(pipeLine)
    }

    private fun separatePipeline(pipeLine: PipeLine): Scope {
        val scope = Scope(mutableListOf())

        // handle first tuple
        val first = pipeLine.elements.first()
        require(first is PipeLineTuple) { "The first element must be a PipeLineTuple, this Exception should never be thrown" }
        scope.children.add(
            Assignment(
                newPipelineVariableName(),
                first.type,
                Tuple(first.expressions, first.type)
            )
        )

        // handle the remaining elements


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
    private fun handlePipelineElement(element: PipeLineElement, previousResult: Variable): Assignment {
        return when (element) {
            is PipeLineTuple -> handlePipelineTuple(element, previousResult)

            is PipeCall -> handlePipeCall(element, previousResult)
            is GuardedPipeCall ->
                TODO("Not implemented yet")
            else -> throw IllegalStateException("")

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
        tuple.expressions.forEach {
            if (it is PipeLineTuplePlaceholder) {
                val path = mutableListOf(previousResult.getIdentifier())

                if (previousResult.type.isTuple()) {
                    path.add(
                        TupleTranslator.fieldPrefix + it.index
                    )
                }

                tuple.expressions[it.index] = Variable(path, it.type, tuple.type)
            }
        }

        // transform into Assignment
        return Assignment(
            newPipelineVariableName(),
            tuple.type,
            Tuple(tuple.expressions, tuple.type)
        )
    }

    /**
     * TODO
     */
    private fun handlePipeCall(call: PipeCall, previousResult: Variable): Assignment {
        val args = previousResult.type.getChildren(bundleTable).mapIndexed() { index, type ->
            Variable(
                listOf(previousResult.getIdentifier(), TupleTranslator.fieldPrefix + index),
                type
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

    private fun getCapturedVariables(pipeLine: PipeLine) {
        pipeLine.elements.forEach {
            if (it is PipeLineTuple) {
                // create mappings for captured variables
                PipelineTupleVariableCapturer().getCapturedVariables(it).forEach { v ->
                    capturedVariables.add(Field(newFieldName(), v.type))
                }
            }
        }
    }


    private fun getFunctionDefinition(pipeLine: PipeLine): FunctionDefinition {
        val outType = pipeLine.elements.last().type
        return FunctionDefinition(
            newPipelineName(),
            outType,
            capturedVariables
        )

    }

    private fun newFieldName() = fieldPrefix + fieldIndex++
    private fun newPipelineName() = pipelinePrefix + pipeLineIndex++
    private fun newPipelineVariableName() = pipelineVariablePrefix + pipeLineVariableIndex++
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

class FunctionDefinition(
    val name: String,
    val returnType: Type,
    val args: List<Field>,
)