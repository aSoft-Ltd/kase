package kase

import kevlar.Action0
import kevlar.builders.Actions0Builder

private fun <D> Result<D>.toState(
    data: D? = this.data,
    builder: (Actions0Builder<Unit>.() -> Action0<Unit>)
): State<D> = when (this) {
    is Success -> this
    is Failure -> Failure(cause, message, data, builder)
}

fun <D> Result<D>.toLazyState(
    data: D? = this.data,
    builder: (Actions0Builder<Unit>.() -> Action0<Unit>)
): LazyState<D> = toState(data, builder) as LazyState<D>

fun <D> Result<D>.toFormState(
    data: D? = this.data,
    builder: (Actions0Builder<Unit>.() -> Action0<Unit>)
): FormState<D> = toState(data, builder) as FormState<D>