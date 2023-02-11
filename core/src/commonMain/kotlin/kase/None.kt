@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

class None<out T : Any> private constructor() : Possible<T> {
    override val value: T? = null

    @PublishedApi
    internal companion object {
        val NONE = None<Nothing>()
    }

    override fun <R : Any> map(transform: (T) -> R): None<R> = NONE

    override fun <R : Any> flatMap(transform: (T) -> Possible<R>): None<R> = NONE

    override fun recover(fn: () -> @UnsafeVariance T): Possible<T> = try {
        Some(fn())
    } catch (_: Throwable) {
        NONE
    }

    @Throws(NoSuchElementException::class)
    override fun valueOrThrow(): Nothing = throw NoSuchElementException("Possible has no value")

    override fun valueOr(default: @UnsafeVariance T) = default
}