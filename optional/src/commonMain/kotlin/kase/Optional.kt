@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlinx.JsExport

sealed interface Optional<out T : Any> : Possible<T> {
    fun <R : Any> map(transform: (T) -> R): Optional<R>

    fun <R : Any> flatMap(transform: (T) -> Optional<R>): Optional<R>

    fun catch(fn: () -> @UnsafeVariance T): Optional<T>
}