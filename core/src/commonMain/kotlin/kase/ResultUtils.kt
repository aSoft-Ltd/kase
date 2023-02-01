package kase

fun <D> Result<D>.toLazyState(): LazyState<D> = when (this) {
    is Success -> this
    is Failure -> this
}