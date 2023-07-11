@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

sealed interface Optional<out T : Any> : Possible<T> {
    val asSome: Some<T>?
    val asNone: None<Nothing>?

    fun <R : Any> map(transform: (T) -> R): Optional<R>

    fun <R : Any> flatMap(transform: (T) -> Optional<R>): Optional<R>

    fun catch(fn: () -> @UnsafeVariance T): Optional<T>
}