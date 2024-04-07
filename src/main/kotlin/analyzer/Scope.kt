package de.any.analyzer

class Scope(val parent: Scope? = null) {
    private val subScopes = mutableListOf<Scope>()
    private val variables = mutableListOf<Field>()


    fun addScope(): Scope {
        val newScope = Scope(this)
        subScopes.add(newScope)
        return newScope
    }

    fun bubbleUp(): Scope {
        if (parent == null) {
            throw IllegalStateException("Cannot bubble up from global scope")
        }
        return parent
    }

    fun addVariable(variable: Field) {
        variables.add(variable)
    }

    fun findVariable(name: String): Field? {
        return variables.find { it.name == name } ?: parent?.findVariable(name)
    }

    override fun toString(): String {
        val stringBuilder: StringBuilder = StringBuilder()
        variables.forEach {
            stringBuilder.append(it.toString())
            stringBuilder.append("\n")
        }
        stringBuilder.append("|---")

        subScopes.forEach {
            stringBuilder.append("   $it")
        }
        return stringBuilder.toString()
    }
}