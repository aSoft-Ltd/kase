package kase

import actions.SimpleActionsBuilder

fun <D> Kase<D>.loading(
    message: String,
    progress: ProgressState? = null
): Loading<D> = if (progress != null) Loading(message, data, progress) else Loading(message, data)

fun Kase<*>.executing(
    message: String,
    progress: ProgressState? = null
): Executing = if (progress != null) Executing(message, progress) else Executing(message)

fun <D> Kase<D>.copy(
    cause: Throwable,
    builder: (SimpleActionsBuilder.() -> Unit)? = null
): Failure<D> = Failure(cause = cause, data = data, builder = builder)

fun <D> Kase<D>.copy(data: D): Success<D> = Success(data)