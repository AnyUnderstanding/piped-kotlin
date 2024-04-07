package de.any.analyzer

class Scope(val parent: Scope? = null, var id: Int = nextScopeId) {
    var returnType: Type? = null
    private val subScopes = mutableListOf<Scope>()
    private val variables = mutableListOf<Field>()
    private val referencedVariables = mutableListOf<Field>()
    var visitCount = 0

    init {
        nextScopeId++
    }


    fun addScope(): Scope {
        val newScope = Scope(this, id++)
        subScopes.add(newScope)
        return newScope
    }

    fun addReferencedVariable(variable: Field) {
        referencedVariables.add(variable)
    }

    fun getReferencedVariables(): List<Field> {
        return referencedVariables
    }

    fun nextChild(): Scope {
        if (visitCount < subScopes.size) {
            return subScopes[visitCount++]
        }
        throw IllegalStateException("No more children")
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

    fun getGlobalScope(): Scope {
        var currentScope = this
        while (currentScope.parent != null) {
            currentScope = currentScope.parent!!
        }
        return currentScope
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

    companion object {
        var nextScopeId = 0
    }
}