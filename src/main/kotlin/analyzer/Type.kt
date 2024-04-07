package de.any.analyzer

open class Type(val name: String) {
    open fun getField(name: String): Field? {
        return null
    }
    override fun toString(): String {
        return name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Type

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }


}

class Bundle(name: String, var fields: List<Field>) : Type(name) {
    override fun getField(name: String): Field? {
        return fields.firstOrNull { it.name == name }
    }
    override fun toString(): String {
        val builder = StringBuilder()
        fields.forEach {
            builder.append("$it, ")
        }
        return "$name{$builder}"
    }
}

data class Field(val name: String, val type: Type, val isMutable: Boolean)
