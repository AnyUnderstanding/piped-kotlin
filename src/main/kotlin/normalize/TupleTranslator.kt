package de.any.normalize

import de.any.AST.*
import de.any.AST.Function
import de.any.analyzer.BundleTable

class TupleTranslator : ILASTVisitor() {
    val tuples = mutableSetOf<Type>()
    override fun visit(program: ILProgram, vararg args: Any) {
        super.visit(program, *args)
        tuples.distinct().forEach {
            val bundle = Bundle(
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
            program.bundles.add(bundle)
            BundleTable.addBundle(bundle.name, bundle)
        }
    }

    override fun visitField(field: Field, vararg args: Any) {
        super.visitField(field, *args)
        if (field.type.isBasicType()) return
        field.type = translateTuple(field.type)
        // TODO pipeline assignments dont change field type
    }

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        super.visitPipe(pipe, *args)
        if (pipe.returnType.isBasicType()) return
        pipe.returnType = translateTuple(pipe.returnType)
    }

    override fun visitReturn(return_: Return, vararg args: Any) {
        // TODO: this is somehow needed for guarded pipes, but why?
        return_.expression.type = translateTuple(return_.expression.type)
    }

    override fun visitFunction(function: Function, vararg args: Any) {
        super.visitFunction(function, *args)
        if (function.returnType.isBasicType()) return
        function.returnType = translateTuple(function.returnType)
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

                is Guard -> {
                    parent.returnExpression = getBundleInit(expression, parent)
                }

                is ElseGuard -> {
                    parent.returnExpression = getBundleInit(expression, parent)
                }

                else -> throw Exception("Unknown parent $parent")
            }
        } else if (expression is FunctionCall) {
            expression.type = translateTuple(expression.type)
            when (val parent = expression.parent) {
                is Assignment -> {
                    parent.expectedType = translateTuple(expression.type)
                }
            }
        } else if (expression is Variable && expression.path.size > 1) {
            expression.referencedBundle = translateTuple(expression.referencedBundle)
        }
    }

    private fun getBundleInit(
        expression: Tuple,
        parent: ASTNode,
    ) = BundleInit(
        translateTupleWithAdd(expression.type).getBasicType()!!,
        expression.elements.toMutableList(),
    ).apply {
        this.parent = parent
        this.type = translateTuple(expression.type)
    }


    private fun translateTupleWithAdd(tuple: Type): Type {
        if (tuple.isBasicType()) return tuple
        tuples.add(tuple)
        return translateTuple(tuple)
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