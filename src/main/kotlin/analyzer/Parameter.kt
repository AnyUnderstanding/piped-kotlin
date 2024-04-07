package de.any.analyzer

data class Parameter(val name: String, val type: Type){
    fun toField(): Field {
        return Field(name, type, false)
    }
}