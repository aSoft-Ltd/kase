@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

abstract class None<out T : Any> private constructor() : Optional<T> {
    override val value: Nothing? = null

    @PublishedApi
    internal companion object : None<Nothing>() {
        override val asSome: Nothing? = null
        override val asNone: None<Nothing> = this
    }

    override fun <R : Any> map(transform: (T) -> R): None<R> = None

    override fun <R : Any> flatMap(transform: (T) -> Optional<R>): None<R> = None

    override fun catch(fn: () -> @UnsafeVariance T): Optional<T> = try {
        Some(fn())
    } catch (_: Throwable) {
        None
    }

    override fun equals(other: Any?): Boolean = other is Optional<*> && other.value == null

    @Throws(NoSuchElementException::class)
    override fun valueOrThrow(): Nothing = throw NoSuchElementException("Optional has no value")

    override fun valueOr(default: @UnsafeVariance T): T = default

    override fun valueOrThrow(exp: Throwable): Nothing = throw exp

    override fun valueOrThrow(msg: String): Nothing = throw NoSuchElementException(msg)

    override fun exists(): Boolean = false
}