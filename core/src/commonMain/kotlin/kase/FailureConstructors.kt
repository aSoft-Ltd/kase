package kase

import presenters.actions.SimpleActionsBuilder

inline fun <D> Failure(
    cause: Throwable,
    message: String = cause.message ?: Failure.DEFAULT_MESSAGE,
    data: D? = null,
    noinline builder: (SimpleActionsBuilder.() -> Unit)? = null
): Failure<D> = Failure(cause, message, data, builder?.let { SimpleActionsBuilder().apply(it).actions } ?: emptyList())
