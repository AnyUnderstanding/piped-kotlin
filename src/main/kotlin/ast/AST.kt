package de.any.AST


abstract class ASTNode {
    lateinit var parent: ASTNode

}


open class TypedASTNode(
    var type: Type = PrimitiveType.NONE.type,
) : ASTNode()


class Program(
    val bundles: MutableList<Bundle>,
    val pipes: List<Pipe>,
) : ASTNode() {

    init {
        parent = this
        bundles.forEach { it.parent = this }
        pipes.forEach { it.parent = this }
    }

    override fun toString(): String {
        return StringBuilder()
            .append("Program: \n")
            .append(" Bundles:\n")
            .append(getIndentedStringFromList(bundles))
            .append(" Pipes:\n")
            .append(getIndentedStringFromList(pipes))
            .toString()
    }


}


class Bundle(
    val name: String,
    var fields: List<Field>,
) : ASTNode() {

    init {
        fields.forEach { it.parent = this }
    }

    override fun toString(): String {
        return StringBuilder()
            .append("Bundle\n")
            .append(" name: $name\n")
            .append(" Fields:\n")
            .append(getIndentedStringFromList(fields))
            .toString()
    }
}

class Field(
    val name: String,
    var type: Type,
) : ASTNode() {

    override fun toString(): String {
        return "Field:\n name: $name \n type: $type"
    }


}


class Pipe(
    val name: String,
    var returnType: Type,
    val parameters: List<Field>,
    val body: Scope,
) : ASTNode() {

    init {
        parameters.forEach { it.parent = this }
        body.parent = this
    }

    fun getInType(): Type {
        if (parameters.isEmpty()) {
            return PrimitiveType.NONE.type
        } else if (parameters.size == 1) {
            return parameters[0].type
        } else {
            return Type(
                parameters.map { it.type }
            )
        }
    }

    override fun toString(): String {
        return StringBuilder()
            .append("Pipe: ")
            .append(" return: $returnType")
            .append(" parameters: \n")
            .append(getIndentedStringFromList(parameters))
            .append("\n body: \n")
            .append(body)
            .toString()
    }
}


class Assignment(val name: String, var expectedType: Type, var expression: Expression) : TypedASTNode() {

    init {
        expression.parent = this
    }

    override fun toString(): String {
        return "Assignment: $name: $expectedType = $expression"
    }
}


// _ EXPRESSIONS _
open class Expression : TypedASTNode()

abstract class InfixOperation(
    var left: Expression,
    var right: Expression
) : Expression()

class AddSubExpression(left: Expression, right: Expression, val operand: String) :
    InfixOperation(left, right) {

    init {
        left.parent = this
        right.parent = this
    }

    override fun toString(): String {
        return "AddSubExpression: $left $operand $right"
    }

}

class MulDivExpression(left: Expression, right: Expression, val operand: String) :
    InfixOperation(left, right) {

    init {
        left.parent = this
        right.parent = this
    }

    override fun toString(): String {
        return "MulDivExpression: $left $operand $right"
    }

}

class BoolExpression(left: Expression, right: Expression, val operand: String) :
    InfixOperation(left, right) {
    init {
        left.parent = this
        right.parent = this
    }

    override fun toString(): String {
        return "BoolExpression: $left $operand $right"
    }
}


// ___ PIPELINE ___
class PipeLine(val elements: List<PipeLineElement>) : Expression() {
    init {
        elements.forEach { it.parent = this }
    }

    override fun toString(): String {
        return "PipeLine: \n" + getIndentedStringFromList(elements)
    }
}

open class PipeLineElement : Expression() {
    var previousElement: PipeLineElement? = null

}

class PipeCall(val name: String) : PipeLineElement() {
    override fun toString(): String {
        return "PipeCall: $name"
    }
}

class GuardedPipeCall(
    val name: String,
    val parameters: List<Field>,
    val guards: List<Guard>,
    val elseGuard: ElseGuard,
) : PipeLineElement() {

    init {
        parameters.forEach { it.parent = this }
        guards.forEach { it.parent = this }
        elseGuard.parent = this
    }

    override fun toString(): String {
        return "GuardedPipeCall: $name \n" + getIndentedStringFromList(guards) + "\n" + elseGuard
    }
}

class Guard(val guardExpression: Expression, var returnExpression: Expression) : TypedASTNode() {

    init {
        guardExpression.parent = this
        returnExpression.parent = this
    }

    override fun toString(): String {
        return "Guard: $guardExpression -> $returnExpression"
    }
}

class ElseGuard(var returnExpression: Expression) : TypedASTNode() {

    init {
        returnExpression.parent = this
    }

    override fun toString(): String {
        return "ElseGuard: $returnExpression"
    }
}

class PipeLineTuple(val expressions: List<Expression>) : PipeLineElement() {
    init {
        expressions.forEach { it.parent = this }
    }

    override fun toString(): String {
        return "PipeLineTuple: \n" + getIndentedStringFromList(expressions)
    }

    fun typeFromElements(elements: List<Type>) {
        type = if (elements.isEmpty()) {
            PrimitiveType.NONE.type
        } else if (elements.size == 1) {
            elements[0]
        } else {
            Type(
                elements
            )
        }
    }

}

class PipeLineTuplePlaceholder(val index: Int, val referencedPipe: Pipe? = null) : Expression() {

    override fun toString(): String {
        return "PipeLineTuplePlaceholder: $index"
    }
}
// ___ END PIPELINE ___

class BundleInit(val name: String, val initializers: MutableList<Expression>) : Expression() {
    init {
        initializers.forEach { it.parent = this }
    }

    override fun toString(): String {
        return "BundleInit: $name \n" + getIndentedStringFromList(initializers)
    }
}

class Tuple(val elements: MutableList<Expression>) : Expression() {
    init {
        elements.forEach { it.parent = this }
    }

    override fun toString(): String {
        return "Tuple: \n" + getIndentedStringFromList(elements)
    }

    fun typeFromElements() = Type(elements.map { it.type })
}

class Scope(val children: MutableList<TypedASTNode>) : Expression() {
    init {
        children.forEach { it.parent = this }
    }

    override fun toString(): String {
        return "  Scope: \n" + getIndentedStringFromList(children, "    ")
    }
}

open class Value(val value: String) : Expression() {
    override fun toString(): String {
        return "Value: $value"
    }
}

class IntValue(value: String) : Value(value) {
    override fun toString(): String {
        return "IntValue: $value"
    }
}

class BoolValue(value: String) : Value(value) {
    override fun toString(): String {
        return "BoolValue: $value"
    }
}

class StringValue(value: String) : Value(value) {
    override fun toString(): String {
        return "StringValue: $value"
    }
}


class Variable(val path: List<String>) : Expression() {
    override fun toString(): String {
        return "Variable: ${path.joinToString(".")}"
    }

    fun isBundleField() = path.size > 1

    fun getIdentifier() = path[0]

    fun getPathWithoutIdentifier() = path.drop(1)

}

class Parenthesis(val expression: Expression) : Expression() {
    init {
        expression.parent = this
    }

    override fun toString(): String {
        return "Parenthesis: \n ${expression.toString().prependIndent()}"
    }
}
// _ END EXPRESSIONS _


class Return(var expression: Expression) : TypedASTNode() {
    init {
        expression.parent = this
    }

    override fun toString(): String {
        return "Return: $expression"
    }
}


fun getIndentedStringFromList(list: List<Any>, indent: String = "  ", join: String = "\n"): String {
    return list.map { it.toString() }.joinToString(join) { it }.prependIndent(indent)
}




