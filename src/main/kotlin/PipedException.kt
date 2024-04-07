package de.any

import org.antlr.v4.runtime.Token


class PipedException(message: String, val token: Token) : Exception(message) {

    constructor(cause: Cause, token: Token) : this(cause.message, token)

    override fun printStackTrace() {
        println("FAILED at ${token.line}:${token.charPositionInLine}")
        println(token.text)
        println(message)
    }
}

enum class Cause(val message: String, ) {
    UNKNOWN_TYPE("The provided type is unknown"),
    UNKNOWN_PIPE("The provided pipe is unknown"),
    ARGUMENT_MISMATCH("The arguments do not match"),
    TYPE_MISMATCH("The types do not match"),
    IMMUTABLE_MUTATION("Trying to mutate an immutable variable"),
}