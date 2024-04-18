package de.any.AST

open class Type {
    private var children = mutableListOf<Type>()

    constructor(children: List<Type>) {
        this.children = children.toMutableList()
    }

    open fun isBasicType(): Boolean {
        return false
    }

    fun size(): Int {
        return children.size
    }

    fun isTuple(): Boolean {
        return children.size > 1
    }

    open fun getBasicType(): String? {
        return null
    }

    open fun getBasicTypeStrict(): String {
        throw Exception("Type is not a BasicType")

    }

    open fun getChildren(): List<Type> {
        return children
    }

    protected constructor()

    override fun equals(other: Any?): Boolean {
        return other is Type && other.children.zip(children).all { it.first == it.second }
    }

    override fun hashCode(): Int {
        return children.hashCode()
    }

    open fun asPipedString(): String {
        return "(" + children.joinToString(", ") { it.asPipedString() } + ")"
    }

    override fun toString(): String {
        return "TupleType: (${children.joinToString(",") { it.toString() }})"
    }

    companion object {
        private val validTypeName = Regex("[a-zA-Z_][a-zA-Z0-9]*")

        fun fromString(string: String): Type {
            require(validTypeName.matches(string)) { throw IllegalArgumentException("Invalid Type name: $string") }
            return BasicType(string)
        }

        fun int() = PrimitiveType.INT.type
        fun bool() = PrimitiveType.BOOL.type
        fun string() = PrimitiveType.STRING.type
        fun none() = PrimitiveType.NONE.type
    }
}


/**
 * Represents a Type that is not a Tuple
 */
private class BasicType(val name: String) : Type() {

    override fun getChildren(): List<Type> {
        return listOf(this)
    }

    override fun isBasicType(): Boolean {
        return true
    }

    override fun getBasicTypeStrict(): String {
        return name
    }

    override fun getBasicType(): String {
        return name
    }

    override fun equals(other: Any?): Boolean {
        return other is BasicType && other.name == name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    override fun asPipedString(): String {
        return name
    }

    override fun toString(): String {
        return "Type: $name"
    }
}


enum class PrimitiveType(val type: Type) {
    INT(BasicType("Int")),
    BOOL(BasicType("Bool")),
    STRING(BasicType("String")),
    NONE(BasicType("None"));


    companion object {
        fun hasType(type: Type): Boolean {
            return entries.any { it.type == type } && type != NONE.type
        }

    }
}