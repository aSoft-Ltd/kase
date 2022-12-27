package kase

import actions.SimpleActionsBuilder

inline fun <D> Failure(
    cause: Throwable,
    message: String = cause.message ?: Failure.DEFAULT_MESSAGE,
    data: D? = null,
    noinline builder: (SimpleActionsBuilder.() -> Unit)
): Failure<D> = Failure(cause, message, data, SimpleActionsBuilder().apply(builder).actions)