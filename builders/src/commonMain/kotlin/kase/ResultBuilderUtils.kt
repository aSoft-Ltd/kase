package kase

import actions.Action0
import actions.builders.Action0I1RBuilder

fun <D> Result<D>.toLazyState(
    builder: (Action0I1RBuilder<Unit>.() -> Action0<Unit>)
): LazyState<D> = when (this) {
    is Success -> this
    is Failure -> Failure(cause, message, data, builder)
}