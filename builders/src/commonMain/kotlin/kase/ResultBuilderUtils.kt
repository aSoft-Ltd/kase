package kase

import actions.Action0
import actions.builders.Actions0Builder

fun <D> Result<D>.toLazyState(
    data: D? = this.data,
    builder: (Actions0Builder<Unit>.() -> Action0<Unit>)
): LazyState<D> = when (this) {
    is Success -> this
    is Failure -> Failure(cause, message, data, builder)
}