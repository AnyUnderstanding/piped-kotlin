package de.any.normalize

import de.any.AST.*

class TupleTranslator : ASTVisitor() {
    val tuples = mutableSetOf<Type>()
    override fun visit(program: Program, vararg args: Any) {
        super.visit(program, *args)
        tuples.distinct().forEach {
            program.bundles.add(
                Bundle(
                    translateTuple(it).getBasicType()!!,
                    listOf(),
                ).apply {
                    this.fields = it.getChildren().mapIndexed { index, type ->
                        Field(
                            "field$index",
                            when {
                                type.isBasicType() -> type
                                else -> translateTuple(type)
                            },
                        )
                    }
                }
            )
        }
    }

    override fun visitField(field: Field, vararg args: Any) {
        super.visitField(field, *args)
        if (field.type.isBasicType()) return
        field.type = translateTuple(field.type)
    }

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        super.visitPipe(pipe, *args)
        if (pipe.returnType.isBasicType()) return
        pipe.returnType = translateTuple(pipe.returnType)
    }

    override fun visitExpression(expression: Expression, vararg args: Any) {
        super.visitExpression(expression)

        if (expression is Tuple) {
            when (val parent = expression.parent) {
                is Scope -> {
                    parent.children[
                        parent.children.indexOf(expression)
                    ] = getBundleInit(expression, parent)
                }

                is Return -> {
                    parent.expression = getBundleInit(expression, parent)
                }

                is InfixOperation -> {
                    if (parent.left == expression) {
                        parent.left = getBundleInit(expression, parent)
                    } else {
                        parent.right = getBundleInit(expression, parent)
                    }
                }

                is Assignment -> {
                    parent.expectedType = translateTuple(expression.type)
                    parent.expression = getBundleInit(expression, parent)
                }
                is BundleInit -> {
                    parent.initializers[parent.initializers.indexOf(expression)] =
                        getBundleInit(expression, parent)
                }
                is Tuple -> {
                    parent.elements[parent.elements.indexOf(expression)] =
                        getBundleInit(expression, parent)
                }
                is Guard  -> {
                    parent.returnExpression = getBundleInit(expression, parent)
                }
                is ElseGuard -> {
                    parent.returnExpression = getBundleInit(expression, parent)
                }
                else -> throw Exception("Unknown parent $parent")
            }
        }
    }

    private fun getBundleInit(
        expression: Tuple,
        parent: ASTNode,
    ) = BundleInit(
        translateTupleWithAdd(expression.type).getBasicType()!!,
        expression.elements.toMutableList(),
    ).apply { this.parent = parent }


    private fun translateTupleWithAdd(tuple: Type): Type {
        if (tuple.isBasicType()) return tuple
        tuples.add(tuple)
        return Type.fromStringUnsafe(
            tuple.asPipedString()
                .replace("(", "$$")
                .replace(")", "$$").replace(",", "$")
        )
    }


    companion object {
        fun translateTuple(tuple: Type): Type {
            if (tuple.isBasicType()) return tuple
            return Type.fromStringUnsafe(
                tuple.asPipedString()
                    .replace("(", "$$")
                    .replace(")", "$$").replace(",", "$")
            )
        }
    }

}