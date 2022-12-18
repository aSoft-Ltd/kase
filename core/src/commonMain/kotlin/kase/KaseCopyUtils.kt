package kase

import presenters.actions.SimpleActionsBuilder

fun <D> Kase<D>.copy(message: String): Loading<D> = when (this) {
    is Pending -> Loading(message, data = null)
    is Loading -> Loading(message, data = data)
    is Failure -> Loading(message, data = data)
    is Success -> Loading(message, data = data)
}

fun <D> Kase<D>.copy(
    cause: Throwable,
    builder: (SimpleActionsBuilder.() -> Unit)? = null
): Failure<D> = when (this) {
    is Failure -> Failure(cause = cause, data = data, builder = builder)
    is Loading -> Failure(cause = cause, data = data, builder = builder)
    is Success -> Failure(cause = cause, data = data, builder = builder)
    is Pending -> Failure(cause = cause, data = null, builder = builder)
}

fun <D> Kase<D>.copy(data: D): Success<D> = Success(data)