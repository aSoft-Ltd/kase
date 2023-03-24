@file:JsExport

package kase

import kotlin.js.JsExport

sealed interface Possible<out T : Any> {
    val value: T?

    fun <R : Any> map(transform: (T) -> R): Possible<R>

    fun <R : Any> flatMap(transform: (T) -> Possible<R>): Possible<R>

    fun catch(fn: () -> @UnsafeVariance T): Possible<T>

    @Throws(NoSuchElementException::class)
    fun valueOrThrow(): T

    fun valueOr(default: @UnsafeVariance T): T

    fun exists(): Boolean
}