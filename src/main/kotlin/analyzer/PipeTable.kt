package de.any.analyzer

// almost the same as TypeTable.kt but for now this is fine
object PipeTable {
    private val pipes = mutableListOf<Pipe>()

    fun findPipe(name: String): Pipe? {
        return pipes.find { it.name == name }
    }

    fun addPipe(pipe: Pipe) {
        pipes.add(pipe)
    }

    override fun toString(): String {
        val stringBuilder: StringBuilder = StringBuilder()
        pipes.forEach {
            stringBuilder.append(it.toString())
            stringBuilder.append("\n---\n")
        }
        return stringBuilder.toString()
    }
}