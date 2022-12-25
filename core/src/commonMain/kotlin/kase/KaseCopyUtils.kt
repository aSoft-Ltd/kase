package kase

import actions.SimpleActionsBuilder

fun <D> Kase<D>.copy(message: String): Loading<D> = Loading(message, data = data)

fun <D> Kase<D>.copy(
    cause: Throwable,
    builder: (SimpleActionsBuilder.() -> Unit)? = null
): Failure<D> = Failure(cause = cause, data = data, builder = builder)

fun <D> Kase<D>.copy(data: D): Success<D> = Success(data)