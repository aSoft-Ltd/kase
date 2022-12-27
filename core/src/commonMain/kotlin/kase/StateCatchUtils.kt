package kase

internal fun <D> Failure<D>.catchToState(resolver: (Throwable) -> D): State<D> = try {
    Success(resolver(cause))
} catch (err: Throwable) {
    err.addSuppressed(cause)
    Failure(err, err.message ?: message, data, actions)
}

private fun <D> State<D>.catchToState(resolver: (Throwable) -> D): State<D> {
    return if (this is Failure) catchToState(resolver) else this
}

fun <D> EagerState<D>.catch(resolver: (Throwable) -> D): EagerState<D> = catchToState(resolver) as EagerState<D>

fun <D> LazyState<D>.catch(resolver: (Throwable) -> D): LazyState<D> = catchToState(resolver) as LazyState<D>

fun <D> Result<D>.catch(resolver: (Throwable) -> D): Result<D> = catchToState(resolver) as Result<D>

fun <D> ExecutorState<D>.catch(resolver: (Throwable) -> D): ExecutorState<D> = catchToState(resolver) as ExecutorState<D>