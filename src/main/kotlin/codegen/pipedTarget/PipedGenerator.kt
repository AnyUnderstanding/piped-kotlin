package de.any.codegen.pipedTarget

import de.any.AST.*
import de.any.codegen.CodeGenerator


// TODO not finished
class PipedGenerator : ASTVisitor(), CodeGenerator{

    private val code = StringBuilder()

    override fun gen(program: Program): String {
        visit(program)
        return code.toString()
    }

    override fun visit(program: Program, vararg args: Any) {
        super.visit(program)
    }

    override fun visitBundle(bundle: Bundle, vararg args: Any) {
        code.append("bundle ${bundle.name} {\n")
        super.visitBundle(bundle)
        code.append("}\n\n")
    }

    override fun visitPipe(pipe: Pipe, vararg args: Any) {
        code.append("pipe ${pipe.name}(")
        pipe.parameters.forEach {
            code.append("${it.name} : ${it.type.asPipedString()}, ")
        }
        code.append(") : ${pipe.returnType.asPipedString()} {\n")
        super.visitScope(pipe.body)
        code.append("}\n\n")

    }

    override fun visitAssignment(assignment: Assignment, vararg args: Any) {
        code.append("\t let ")
        code.append(assignment.name)
        code.append(" : ")
        code.append(assignment.type.asPipedString())
        code.append(" = ")
        super.visitExpression(assignment.expression)
    }

    override fun visitBoolOpExpression(boolExpression: BoolExpression, vararg args: Any) {
        code.append("\t")
        super.visitExpression(boolExpression.left)
        code.append(" ${boolExpression.operand} ")
        super.visitExpression(boolExpression.right)
    }

    override fun visitMulDivExpression(mulDivExpression: MulDivExpression, vararg args: Any) {
        code.append("\t")
        super.visitExpression(mulDivExpression.left)
        code.append(" ${mulDivExpression.operand} ")
        super.visitExpression(mulDivExpression.right)
    }

    override fun visitAddSubExpression(addSubExpression: AddSubExpression, vararg args: Any) {
        code.append("\t")
        super.visitExpression(addSubExpression.left)
        code.append(" ${addSubExpression.operand} ")
        super.visitExpression(addSubExpression.right)
    }

    override fun visitTuple(tuple: Tuple, vararg args: Any) {
        code.append("(")
        tuple.elements.forEach {
            visitExpression(it)
            code.append(", ")
        }
        code.append(")")
    }

    override fun visitReturn(return_: Return, vararg args: Any) {
        code.append("\t >> ")
        super.visitExpression(return_.expression)
        code.append("\n")
    }

    override fun visitValue(value: Value, vararg args: Any) {
        code.append(value.value)

    }

    override fun visitVariable(variable: Variable, vararg args: Any) {
        code.append(variable.path.joinToString("."))
    }

    override fun visitField(field: Field, vararg args: Any) {
        code.append("\t${field.name} : ${field.type.asPipedString()}, \n")
    }


}