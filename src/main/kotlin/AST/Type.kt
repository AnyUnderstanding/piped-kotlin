package de.any.AST

data class Type(val name: String) {
    fun isTuple() = name.startsWith('(')

    fun asList(): List<Type> {
        if (!isTuple()) return listOf(this)
        return name.substring(1, name.length - 1).split(",").map { Type(it) }
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Type) return false
        return this.name == (other).name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}

enum class PrimitiveType(val type: Type) {
    INT(Type("Int")),
    BOOL(Type("Bool")),
    STRING(Type("String")),
    NONE(Type("None"));


    companion object {
        fun hasType(type: Type): Boolean {
            return entries.any { it.type == type } && type != NONE.type
        }

    }
}