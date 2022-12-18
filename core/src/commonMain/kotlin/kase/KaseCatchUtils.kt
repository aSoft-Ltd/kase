package kase

internal fun <D> Failure<D>.catchToKase(resolver: (Throwable) -> D): Kase<D> = try {
    Success(resolver(cause))
} catch (err: Throwable) {
    err.addSuppressed(cause)
    Failure(err, err.message ?: message, data, actions)
}

private fun <D> Kase<D>.catchToKase(resolver: (Throwable) -> D): Kase<D> = when (this) {
    is Failure -> catchToKase(resolver)
    is Loading -> this
    is Success -> this
    Pending -> Pending
}

fun <D> EagerState<D>.catch(resolver: (Throwable) -> D): EagerState<D> = catchToKase(resolver).asEagerState()

fun <D> LazyState<D>.catch(resolver: (Throwable) -> D): LazyState<D> = catchToKase(resolver).asLazyState()

fun <D> Result<D>.catch(resolver: (Throwable) -> D): Result<D> = catchToKase(resolver).asResult()