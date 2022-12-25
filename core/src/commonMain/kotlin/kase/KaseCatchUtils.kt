package kase

internal fun <D> Failure<D>.catchToKase(resolver: (Throwable) -> D): Kase<D> = try {
    Success(resolver(cause))
} catch (err: Throwable) {
    err.addSuppressed(cause)
    Failure(err, err.message ?: message, data, actions)
}

private fun <D> Kase<D>.catchToKase(resolver: (Throwable) -> D): Kase<D> {
    return if (this is Failure) catchToKase(resolver) else this
}

fun <D> EagerState<D>.catch(resolver: (Throwable) -> D): EagerState<D> = catchToKase(resolver) as EagerState<D>

fun <D> LazyState<D>.catch(resolver: (Throwable) -> D): LazyState<D> = catchToKase(resolver) as LazyState<D>

fun <D> Result<D>.catch(resolver: (Throwable) -> D): Result<D> = catchToKase(resolver) as Result<D>

fun <D> ExecutorState<D>.catch(resolver: (Throwable) -> D): ExecutorState<D> = catchToKase(resolver) as ExecutorState<D>