@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kase.internal.AbstractPossible
import kotlinx.JsExport

data class Some<out T : Any>(val value: T) : AbstractPossible<T>(), Optional<T> {
    override val asSome: Some<T> = this

    override val asNone: Nothing? = null

    override fun <R : Any> map(transform: (T) -> R): Optional<R> = try {
        Some(transform(value))
    } catch (_: Throwable) {
        None
    }

    override fun <R : Any> flatMap(transform: (T) -> Optional<R>): Optional<R> = try {
        transform(value)
    } catch (_: Throwable) {
        None
    }

    override fun catch(fn: () -> @UnsafeVariance T): Some<T> = this

    override fun equals(other: Any?): Boolean = other is Some<*> && value == other.value

    override fun valueOrThrow() = value

    override fun toString() = value.toString()

    override fun valueOr(default: @UnsafeVariance T): T = value

    override fun exists(): Boolean = true

    override fun hashCode(): Int = value.hashCode()

    override fun valueOrThrow(exp: Throwable): T = value

    override fun valueOrThrow(msg: String): T = value

    override fun valueOrNull(): T = value
}