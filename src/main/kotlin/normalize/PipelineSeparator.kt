package de.any.normalize

import de.any.AST.*

class PipelineSeparator : ASTVisitor() {
    private lateinit var currentScope: Scope

    override fun visitScope(scope: Scope, vararg args: Any) {
        currentScope = scope
        super.visitScope(scope, *args)
    }

    override fun visitPipeLine(pipeLine: PipeLine, vararg args: Any) {
        val assigns = pipeLine.elements.mapIndexed { i, it ->
            Assignment(
                "pipe$i",
                it.type,
                it
            )
        }




        super.visitPipeLine(pipeLine, *args)
    }
}

class CallPair(
    val pipeCall: PipeCall,
    val args: List<Expression>
) : TypedASTNode() {
}