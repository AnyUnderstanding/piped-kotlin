package de.any.analyzer

import de.any.AST.Field

class VariableScope {
    private val Fields = mutableMapOf<String, Field>()
    private var parent: VariableScope? = null
    private val children = mutableListOf<VariableScope>()

    fun addField(field: Field) {
        if (FieldExists(field)) {
            throw Exception("Variable already exists")
        }
        Fields[field.name] = field
    }

    fun FieldExists(field: Field): Boolean {
        return Fields.containsKey(field.name)
    }

    fun getField(identifier: String): Field? {
        return parent?.getField(identifier) ?: Fields[identifier]
    }

    fun getVaribaleStrict(identifier: String): Field {
        return parent?.getField(identifier) ?: Fields[identifier] ?: throw Exception("Field $identifier not found")
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