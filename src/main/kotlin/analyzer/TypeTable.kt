package de.any.analyzer


object TypeTable {
    private val knownTypes = mutableListOf<Type>()

    init {
        knownTypes.add(PrimitiveType.STRING.type)
        knownTypes.add(PrimitiveType.INT.type)
        knownTypes.add(PrimitiveType.BOOLEAN.type)
    }

    fun findType(name: String): Type? {
        return knownTypes.find { it.name == name }
    }


    fun addType(type: Type) {
        knownTypes.add(type)
    }

    override fun toString(): String {
        val stringBuilder: StringBuilder = StringBuilder()
        knownTypes.forEach {
            stringBuilder.append(it.toString())
            stringBuilder.append("\n---\n")
        }
        return stringBuilder.toString()
    }
}

enum class PrimitiveType(val type: Type) {
    INT(Type("Int")),
    STRING(Type("String")),
    BOOLEAN(Type("Boolean")),
    VOID(Type("Void"))


}