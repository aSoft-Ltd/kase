package kase

private fun <D, R> Loading<D>.mapToState(transform: (D) -> R): Loading<R> {
    val d = data ?: return Loading(message, null)
    return try {
        Loading(message, transform(d))
    } catch (err: Throwable) {
        Loading(message, null)
    }
}

internal fun <D, R> Success<D>.mapToState(transform: (D) -> R): Result<R> {
    val d = data ?: return Success<R?>(null) as Success<R>
    return try {
        Success(transform(d))
    } catch (err: Throwable) {
        Failure(err, err.message ?: Failure.DEFAULT_MESSAGE, null)
    }
}

internal fun <D, R> Failure<D>.mapToState(transform: (D) -> R): Failure<R> {
    val d = data ?: return Failure(cause, message, null)
    return try {
        Failure(cause, message, transform(d))
    } catch (err: Throwable) {
        err.addSuppressed(cause)
        Failure(err, err.message ?: message, null)
    }
}

private fun <D, R> State<D>.mapToState(transform: (D) -> R): State<R> = when (this) {
    is Failure -> mapToState(transform)
    is Loading -> mapToState(transform)
    is Success -> mapToState(transform)
    else -> this as State<R>
}

fun <D, R> LazyState<D>.map(transform: (D) -> R): LazyState<R> = mapToState(transform) as LazyState<R>

fun <D, R> ExecutorState<D>.map(transform: (D) -> R): ExecutorState<R> = mapToState(transform) as ExecutorState<R>