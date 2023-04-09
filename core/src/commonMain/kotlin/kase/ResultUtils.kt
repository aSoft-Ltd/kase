package kase

fun <D> Result<D>.toLazyState(data: D? = this.data): LazyState<D> = when (this) {
    is Success -> this
    is Failure -> Failure(cause, message, data, actions)
}

inline fun <D> catching(block: () -> D): Result<D> = try {
    Success(block())
} catch (err: Throwable) {
    Failure(err)
}