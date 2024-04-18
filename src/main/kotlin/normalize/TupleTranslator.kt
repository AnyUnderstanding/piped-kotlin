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
                    tuples.mapIndexed { index, type ->
                        Field(
                            "field$index",
                            when {
                                type.isBasicType() -> type
                                else -> translateTuple(type)
                            }
                        )
                    }
                )
            )
        }
    }

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        pipe.returnType = translateTuple(pipe.returnType)
        tuples.add(pipe.returnType)
        super.visitPipe(pipe)
    }

    override fun visitField(field: Field, vararg args: Any) {
        field.type = translateTuple(field.type)
        tuples.add(field.type)
        super.visitField(field)
    }

    override fun visitAssignment(assignment: Assignment, vararg args: Any) {
        assignment.expectedType = translateTuple(assignment.expectedType)
        tuples.add(assignment.expectedType)
        super.visitAssignment(assignment)
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