package kase

import actions.Action0
import actions.builders.Actions0Builder
import kase.progress.ProgressState

fun <D> State<D>.loading(
    message: String,
    data: D? = this.data,
    progress: ProgressState? = null
): Loading<D> = if (progress != null) Loading(message, data, progress) else Loading(message, data)

fun State<Any?>.executing(
    message: String,
    progress: ProgressState? = null
): Executing = if (progress != null) Executing(message, progress) else Executing(message)

fun <D> State<D>.failure(
    cause: Throwable,
    builder: (Actions0Builder<Unit>.() -> Action0<Unit>)? = null
): Failure<D> = if (builder != null) Failure(cause = cause, data = data, builder = builder) else Failure(cause)

fun <D> State<D>.success(data: D): Success<D> = Success(data)