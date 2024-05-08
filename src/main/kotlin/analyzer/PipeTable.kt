package de.any.analyzer

import de.any.AST.Pipe

object PipeTable {
    val pipeTable = mutableMapOf<String, Pipe>()

    fun addPipe(name: String, pipe: Pipe) {
        if (pipeTable.containsKey(name)) {
            throw IllegalArgumentException("Pipe with name $name already exists")
        }
        pipeTable[name] = pipe
    }

    fun getPipe(name: String): Pipe? {
        return pipeTable[name]
    }

    fun getPipeStrict(name: String): Pipe {
        return pipeTable[name] ?: throw IllegalArgumentException("Pipe with name $name not found")
    }

    fun containsPipe(name: String): Boolean {
        return pipeTable.containsKey(name)
    }

    fun clear() {
        pipeTable.clear()
    }
}