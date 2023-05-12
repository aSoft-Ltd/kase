@file:Suppress("NOTHING_TO_INLINE")

package kase

import kevlar.Action0
import kevlar.builders.Actions0Builder

inline fun <D> Failure(
    cause: Throwable,
    message: String = cause.message ?: Failure.DEFAULT_MESSAGE,
    data: D? = null,
    noinline builder: (Actions0Builder<Unit>.() -> Action0<Unit>)
): Failure<D> = Failure(cause, message, data, Actions0Builder<Unit>().apply { builder() }.actions)