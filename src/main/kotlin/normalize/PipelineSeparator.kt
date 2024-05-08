package de.any.normalize

import de.any.AST.*
import de.any.AST.Function

class PipelineSeparator : ILASTVisitor() {
    lateinit var functions : MutableList<Function>
    private var index = 0


    override fun visit(program: ILProgram, vararg args: Any) {
        functions = program.functions
        super.visit(program, *args)
    }

    override fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {
        functions.add(
            Function(
                "pipeLine$index",
                pipeLine.elements.last().type,
                getFields(pipeLine.elements.first().type),
                Scope(
                    mutableListOf(/*TODO*/)
                )
            )
        )
    }

    private fun getFields(type: Type): List<Field> {
        return when {
            type.isBasicType() -> listOf(
                Field(
                    "field$0",
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
}

