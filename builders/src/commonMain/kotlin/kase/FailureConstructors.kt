package kase

import actions.Action0
import actions.builders.Action0I1RBuilder

inline fun <D> Failure(
    cause: Throwable,
    message: String = cause.message ?: Failure.DEFAULT_MESSAGE,
    data: D? = null,
    noinline builder: (Action0I1RBuilder<Unit>.() -> Action0<Unit>)
): Failure<D> = Failure(cause, message, data, Action0I1RBuilder<Unit>().apply { builder() }.actions)