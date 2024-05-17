package de.any.analyzer

import de.any.AST.Field
import de.any.AST.Variable

class VariableScope {
    private val Fields = mutableMapOf<String, Field>()
    private var parent: VariableScope? = null
    private val children = mutableListOf<VariableScope>()
    val capturedVariables = mutableListOf<Variable>()

    fun addField(field: Field) {
        if (fieldExists(field)) {
            throw Exception("Variable already exists")
        }
        Fields[field.name] = field
    }

    fun fieldExists(field: Field): Boolean {
        return Fields.containsKey(field.name)
    }

    fun getField(identifier: String): Field? {
        return parent?.getField(identifier) ?: Fields[identifier]
    }

    fun getVariableStrict(identifier: String): Field {
        return parent?.getField(identifier) ?: Fields[identifier] ?: throw Exception("Field $identifier not found")
    }

    fun getVariableStrict(variable: Variable): Field {
        val identifier = variable.getIdentifier()
        return parent?.getField(identifier) ?: Fields[identifier] ?: throw Exception("Field $identifier not found")
    }

    fun captureVariable(variable: Variable) {
        val identifier = variable.getIdentifier()
        if (!Fields.containsKey(identifier)) {
            capturedVariables.add(variable)
        }
    }

    fun addChild(): VariableScope {
        val child = VariableScope()
        children.add(child)
        child.parent = this
        return child
    }

    fun bubbleUp(): VariableScope {
        return parent ?: throw Exception("Can't bubble up from root scope")
    }

}