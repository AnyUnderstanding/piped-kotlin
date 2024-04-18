package de.any.normalize

import de.any.AST.*

class TupleTranslator : ASTVisitor() {
    val tuples = mutableListOf<Tuple>()

    override fun visitAssignment(assignment: Assignment, vararg args: Any) {
        super.visitAssignment(assignment)
        if (assignment.expectedType.isTuple()){
        }
    }

    override fun visitPipe(pipe: Pipe, vararg args: Any){
        super.visitPipe(pipe)
    }

    fun getBundleNameForTupleType(tuple: Type){
    }
}