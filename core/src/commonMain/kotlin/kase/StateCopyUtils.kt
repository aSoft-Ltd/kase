package kase

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

fun <D> State<D>.failure(cause: Throwable): Failure<D> = Failure(cause = cause, data = data)

fun <D> State<D>.success(data: D): Success<D> = Success(data)