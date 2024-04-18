package de.any.AST


interface ASTNode {

}

open class TypedASTNode(var type: Type = PrimitiveType.NONE.type) : ASTNode


class Program(
    val bundles: List<Bundle>,
    val pipes: List<Pipe>
) : ASTNode {
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
    val fields: List<Field>
) : ASTNode {
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
) : ASTNode {
    override fun toString(): String {
        return "Field:\n name: $name \n type: $type"
    }


}


class Pipe(
    val name: String,
    var returnType: Type,
    val parameters: List<Field>,
    val body: Scope
) : ASTNode {

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

class Assignment(val name: String, var expectedType: Type, val expression: Expression) : TypedASTNode() {
    override fun toString(): String {
        return "Assignment: $name: $expectedType = $expression"
    }
}


// _ EXPRESSIONS _
open class Expression : TypedASTNode()

class AddSubExpression(val left: Expression, val right: Expression, val operand: String) : Expression() {
    override fun toString(): String {
        return "AddSubExpression: $left $operand $right"
    }

}

class MulDivExpression(val left: Expression, val right: Expression, val operand: String) : Expression() {
    override fun toString(): String {
        return "MulDivExpression: $left $operand $right"
    }

}

class BoolExpression(val left: Expression, val right: Expression, val operand: String) : Expression() {
    override fun toString(): String {
        return "BoolExpression: $left $operand $right"
    }
}


// ___ PIPELINE ___
class PipeLine(val elements: List<PipeLineElement>) : Expression() {
    override fun toString(): String {
        return "PipeLine: \n" + getIndentedStringFromList(elements)
    }
}

open class PipeLineElement() : Expression() {
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
    val elseGuard: ElseGuard
) : PipeLineElement() {
    override fun toString(): String {
        return "GuardedPipeCall: $name \n" + getIndentedStringFromList(guards) + "\n" + elseGuard
    }
}

class Guard(val guardExpression: Expression, val returnExpression: Expression) : TypedASTNode() {
    override fun toString(): String {
        return "Guard: $guardExpression -> $returnExpression"
    }
}

class ElseGuard(val returnExpression: Expression) : TypedASTNode() {
    override fun toString(): String {
        return "ElseGuard: $returnExpression"
    }
}

class PipeLineTuple(val expressions: List<Expression>) : PipeLineElement() {
    override fun toString(): String {
        return "PipeLineTuple: \n" + getIndentedStringFromList(expressions)
    }

    fun typeFromElements(elements: List<Type>) {
        if (elements.isEmpty()) {
            type = PrimitiveType.NONE.type
        } else if (elements.size == 1) {
            type = elements[0]
        } else {
            type = Type(
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

class BundleInit(val name: String, val initializers: List<Expression>) : Expression() {
    override fun toString(): String {
        return "BundleInit: $name \n" + getIndentedStringFromList(initializers)
    }
}

class Tuple(val elements: List<Expression>) : Expression() {
    override fun toString(): String {
        return "Tuple: \n" + getIndentedStringFromList(elements)
    }

    fun typeFromElements() = Type(elements.map { it.type })
}

class Scope(val children: List<TypedASTNode>) : Expression() {
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
    override fun toString(): String {
        return "Parenthesis: \n ${expression.toString().prependIndent()}"
    }
}
// _ END EXPRESSIONS _


class Return(val expression: Expression) : TypedASTNode() {
    override fun toString(): String {
        return "Return: $expression"
    }
}


fun getIndentedStringFromList(list: List<Any>, indent: String = "  ", join: String = "\n"): String {
    return list.map { it.toString() }.joinToString(join) { it }.prependIndent(indent)
}




