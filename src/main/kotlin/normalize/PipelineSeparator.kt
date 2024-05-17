package de.any.normalize

import de.any.AST.*
import de.any.AST.Function

class PipelineSeparator : ILASTVisitor() {
    lateinit var functions: MutableList<Function>
    private var index = 0
    private var guardCounter = 0


    override fun visit(program: ILProgram, vararg args: Any) {
        functions = program.functions
        super.visit(program, *args)
    }

    override fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {
        val functionArgs = getFields(pipeLine.elements.first().type)
        val scope = buildScope(pipeLine, functionArgs)
        functions.add(
            Function(
                "pipeLine$index",
                pipeLine.elements.last().type,
                functionArgs,
                scope
            )
        )
        replacePipeline(
            pipeLine,
            FunctionCall("pipeLine$index", (pipeLine.elements.first() as PipeLineTuple).expressions, pipeLine.type)
        )
        index++
        visitScope(scope)
    }

    fun replacePipeline(pipeLine: PipeLine, functionCall: FunctionCall) {
        val parent = pipeLine.parent
        functionCall.parent = parent
        when (parent) {
            is Scope -> parent.children.replaceAll { if (it == pipeLine) functionCall else it }
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
                parent.expressions.replaceAll { if (it == pipeLine) functionCall else it }
            }

            is Tuple -> {
                parent.elements.replaceAll { if (it == pipeLine) functionCall else it }
            }

            is Return -> {
                parent.expression = functionCall
            }

            is Parenthesis -> {
                parent.expression = functionCall
            }

            is BundleInit -> {
                parent.initializers.replaceAll { if (it == pipeLine) functionCall else it }
            }

            else -> error("Unknown parent type $parent")
        }
    }


    fun buildScope(
        pipeLine: PipeLine,
        functionArgs: List<Field>
    ): Scope {
        val scope = Scope(mutableListOf())
        val children = scope.children
        pipeLine.elements.foreachWithPreviousIndexed { _, previous, current ->
            val expressions = when (previous) {
                // todo cases can be collapesed if the function gets passed the arguments as a single bundle
                null -> {
                    callWithPreviousNull(current)
                }

                else -> {
                    callWithPrevious(index, previous, current)
                }
            }

            expressions.forEach { expression ->
                children.add(
                    Assignment(
                        "element\$$index",
                        expression.type,
                        expression
                    )
                )
                index++
            }
        }
        val return_ = Return(
            Variable(listOf("element\$${index - 1}"))
        )
        return_.expression.type = pipeLine.type
        return_.type = pipeLine.type
        children.add(
            return_
        )
        return scope
    }

    fun callWithPrevious(
        index: Int,
        previous: PipeLineElement,
        current: PipeLineElement
    ): List<Expression> {
        return when (current) {
            is PipeLineTuple -> {
                listOf(
                    Tuple(
                        current.expressions.mapIndexed { i, it ->
                            when (it) {
                                is PipeLineTuplePlaceholder ->
                                    Variable(
                                        listOf("element\$${index - 1}", "field${it.index}"),
                                        it.type,
                                        current.previousElement!!.type
                                    )

                                else -> it
                            }

                        }.toMutableList(),
                        current.type
                    )
                )
            }


            is PipeCall -> {
                listOf(handlePipeCall(previous, current))
            }

            is GuardedPipeCall -> {
                val expression = handlePipeCall(previous, current)
                val guardCall = handleGuards(previous, current)

                listOf(expression, guardCall)
            }

            else -> error("this should not happen")


        }
    }

    fun handleGuards(previous: PipeLineElement, current: GuardedPipeCall): FunctionCall {
        val args = getArgs(previous, 0)
        val guardFunctionName = getGuardFunctionName()
        val expressions: MutableList<TypedASTNode> = current.guards.map {
            Conditional(
                it.guardExpression,
                Return(
                    it.returnExpression
                )
            )
        }.union(
            listOf(
                Return(
                    current.elseGuard.returnExpression
                )
            )
        ).toMutableList()


        val guardFunction = Function(
            guardFunctionName,
            current.type,
            current.parameters,
            Scope(
                expressions
            )
        )
        functions.add(guardFunction)

        val call = FunctionCall(
            guardFunctionName,
            args,
            current.type
        )
        call.parent = current.parent
        return call

    }

    fun handlePipeCall(previous: PipeLineElement, current: PipeCall): Expression {
        return handlePipeCall(previous, current, current.name)
    }

    fun handlePipeCall(previous: PipeLineElement, current: GuardedPipeCall): Expression {
        return handlePipeCall(previous, current, current.name)
    }

    fun handlePipeCall(previous: PipeLineElement, current: PipeLineElement, name: String): Expression {

        val args = getArgs(previous)
        val call = FunctionCall(
            name,
            args,
            current.type
        )
        call.parent = current.parent
        return call
    }

    fun getArgs(previous: PipeLineElement, backStep: Int = 1): List<Variable> {
        return if (previous.type.getChildren().size == 1) {
            listOf(
                Variable(
                    listOf("element\$${index - backStep}"),
                    previous.type,
                    previous.type
                )
            )
        } else {
            previous.type.getChildren().mapIndexed { j, it1 ->
                Variable(
                    listOf("element\$${index - backStep}", "field$j"),
                    it1,
                    previous.type
                )
            }
        }
    }

    fun callWithPreviousNull(
        current: PipeLineElement,
    ): List<Expression> {
        when (current) {

            is PipeLineTuple -> {
                val expressions: MutableList<Expression> = current.expressions.mapIndexed { i, it ->
                    Variable(
                        listOf("field$i"),
                        it.type,
                        current.type
                    )
                }.toMutableList()
                if (expressions.size == 1) {
                    return listOf(expressions[0])
                }
                val type = Type(expressions.map { it.type })
                return listOf(
                    Tuple(
                        expressions,
                        type
                    )
                )

            }

            is GuardedPipeCall -> {
                // todo
                return error("Does it make sense to have guards as the first element of a pipeline?")
            }

            else -> error("All elements should be pipeline tuples")
        }

    }

    fun getGuardFunctionName(): String {
        return "guard${guardCounter++}"
    }

    private fun getFields(type: Type): List<Field> {
        return when {
            type.isBasicType() -> listOf(
                Field(
                    "field0",
                    type,
                )
            )

            else -> type.getChildren().mapIndexed { index, type ->
                Field(
                    "field$index",
                    when {
                        type.isBasicType() -> type
                        else -> error("All tuples should be translated to bundles")
                    }
                )
            }

        }
    }

    fun <T> List<T>.foreachWithPreviousIndexed(action: (Int, T?, T) -> Unit) {
        var index = 0
        var previous: T? = null
        for (element in this) {
            action(index, previous, element)
            previous = element
            index++
        }
    }
}

