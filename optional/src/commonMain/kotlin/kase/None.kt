@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kase.internal.AbstractPossible
import kotlinx.JsExport

class None<out T : Any> private constructor() : AbstractPossible<T>(), Optional<T> {

    @PublishedApi
    internal companion object {
        @PublishedApi
        internal val instance by lazy { None<Nothing>() }
    }

    override fun <R : Any> map(transform: (T) -> R): None<R> = None.instance

    override fun <R : Any> flatMap(transform: (T) -> Optional<R>): None<R> = None.instance

    override fun catch(fn: () -> @UnsafeVariance T): Optional<T> = try {
        Some(fn())
    } catch (_: Throwable) {
        None.instance
    }

    override fun equals(other: Any?): Boolean = other is None<*> || other == null

    override fun valueOrThrow(): Nothing = throw NoSuchElementException("Optional has no value")

    override fun valueOr(default: @UnsafeVariance T): T = default

    override fun valueOrThrow(exp: Throwable): Nothing = throw exp

    override fun valueOrThrow(msg: String): Nothing = throw NoSuchElementException(msg)

    override fun valueOrNull(): T? = null

    override fun toString(): String = "None"

    override fun hashCode() = 0

    override fun exists(): Boolean = false
}