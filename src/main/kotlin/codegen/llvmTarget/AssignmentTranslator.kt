package de.any.codegen.llvmTarget

import de.any.AST.*
import de.any.AST.ExpressionTranslator
import de.any.codegen.AstNodeTranslator

class AssignmentTranslator : AstNodeTranslator<Assignment>() {

    companion object {
        val assignmentTracking: MutableMap<String, String> = mutableMapOf()

    }

    override fun gen(node: Assignment): TranslationResult {
        visitAssignment(node)
        return TranslationResult(code.toString(), "")
    }

    override fun visitAssignment(assignment: Assignment, vararg args: Any) {
        when (assignment.expression) {
            is Variable -> {
                assignVariable(assignment.name, assignment.expression as Variable)
            }

            else -> {
                assignmentTracking[assignment.name] = assignment.name
                val expression = ExpressionTranslator().gen(assignment.expression)
                appendBlock(
                    expression.code.replace(
                        expression.location,
                        "%${assignment.name}"
                    )
                )

            }
        }
    }

    fun assignVariable(assignedVariableName: String, variable: Variable): String {
        assignmentTracking[assignedVariableName] = variable.getIdentifier()
        return assignedVariableName
    }


}
