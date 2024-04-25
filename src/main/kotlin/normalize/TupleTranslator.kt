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

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        pipe.returnType = translateTupleWithAdd(pipe.returnType)
        super.visitPipe(pipe)
    }

    override fun visitField(field: Field, vararg args: Any) {
        field.type = translateTupleWithAdd(field.type)
        super.visitField(field)
    }

    override fun visitAssignment(assignment: Assignment, vararg args: Any) {
        assignment.expectedType = translateTupleWithAdd(assignment.expectedType)
        super.visitAssignment(assignment)
    }

    override fun visitExpression(expression: Expression, vararg args: Any) {
        if (expression is Tuple) {

        }
    }

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