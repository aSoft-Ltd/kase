package kase

import kollections.iEmptyList

private fun <D, R> Loading<D>.mapToKase(transform: (D) -> R): Loading<R> {
    val d = data ?: return Loading(message, null)
    return try {
        Loading(message, transform(d))
    } catch (err: Throwable) {
        Loading(message, null)
    }
}

internal fun <D, R> Success<D>.mapToKase(transform: (D) -> R): Kase<R> {
    val d = data ?: return Success<R?>(null) as Success<R>
    return try {
        Success(transform(d))
    } catch (err: Throwable) {
        Failure(err, err.message ?: Failure.DEFAULT_MESSAGE, null, iEmptyList())
    }
}

internal fun <D, R> Failure<D>.mapToKase(transform: (D) -> R): Failure<R> {
    val d = data ?: return Failure(cause, message, null, actions)
    return try {
        Failure(cause, message, transform(d), actions)
    } catch (err: Throwable) {
        err.addSuppressed(cause)
        Failure(err, err.message ?: message, null, actions)
    }
}

private fun <D, R> Kase<D>.mapToKase(transform: (D) -> R): Kase<R> = when (this) {
    is Failure -> mapToKase(transform)
    is Loading -> mapToKase(transform)
    is Success -> mapToKase(transform)
    is Pending -> Pending
}

fun <D, R> EagerState<D>.map(transform: (D) -> R): EagerState<R> = mapToKase(transform).asEagerState()

fun <D, R> LazyState<D>.map(transform: (D) -> R): LazyState<R> = mapToKase(transform).asLazyState()

fun <D, R> Result<D>.map(transform: (D) -> R): Result<R> = mapToKase(transform).asResult()