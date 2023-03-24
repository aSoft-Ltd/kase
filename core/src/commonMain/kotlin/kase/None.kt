@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

abstract class None<out T : Any> private constructor() : Possible<T> {

    override val value: Nothing? = null

    @PublishedApi
    internal companion object : None<Nothing>()

    override fun <R : Any> map(transform: (T) -> R): None<R> = None

    override fun <R : Any> flatMap(transform: (T) -> Possible<R>): None<R> = None

    override fun catch(fn: () -> @UnsafeVariance T): Possible<T> = try {
        Some(fn())
    } catch (_: Throwable) {
        None
    }

    override fun equals(other: Any?): Boolean = other is None<Any>

    @Throws(NoSuchElementException::class)
    override fun valueOrThrow(): Nothing = throw NoSuchElementException("Possible has no value")

    override fun valueOr(default: @UnsafeVariance T) = default

    override fun toString(): String = "None"

    override fun exists(): Boolean = false
}