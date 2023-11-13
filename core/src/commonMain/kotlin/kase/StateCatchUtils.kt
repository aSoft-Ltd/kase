package kase

internal fun <D> Failure<D>.catchToState(resolver: (Throwable) -> D): State<D> = try {
    Success(resolver(cause))
} catch (err: Throwable) {
    err.addSuppressed(cause)
    Failure(err, err.message ?: message, data)
}

private fun <D> State<D>.catchToState(resolver: (Throwable) -> D): State<D> {
    return if (this is Failure) catchToState(resolver) else this
}

fun <D> LazyState<D>.catch(resolver: (Throwable) -> D): LazyState<D> = catchToState(resolver) as LazyState<D>

fun <D> ExecutorState<D>.catch(resolver: (Throwable) -> D): ExecutorState<D> = catchToState(resolver) as ExecutorState<D>