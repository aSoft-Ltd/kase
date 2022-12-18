package kase

internal fun <D> Kase<D>.asEagerState(): EagerState<D> = when (this) {
    is Failure -> this
    is Loading -> this
    is Success -> this
    Pending -> throw IllegalStateException("A Pending state is not a member of the EagerState")
}

internal fun <D> Kase<D>.asLazyState(): LazyState<D> = when (this) {
    is Failure -> this
    is Loading -> this
    is Success -> this
    Pending -> Pending
}

internal fun <D> Kase<D>.asResult(): Result<D> = when (this) {
    is Success -> this
    is Failure -> this
    else -> throw IllegalStateException("A Result can only be a Success or a Failure, but was neither")
}