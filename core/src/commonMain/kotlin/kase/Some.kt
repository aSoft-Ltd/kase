@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

data class Some<out T : Any>(override val value: T) : Possible<T> {

    override fun <R : Any> map(transform: (T) -> R): Possible<R> = try {
        Some(transform(value))
    } catch (_: Throwable) {
        None
    }

    override fun <R : Any> flatMap(transform: (T) -> Possible<R>): Possible<R> = try {
        transform(value)
    } catch (_: Throwable) {
        None
    }

    override fun recover(fn: () -> @UnsafeVariance T): Some<T> = this

    override fun equals(other: Any?): Boolean = other is Some<*> && value == other.value

    override fun valueOrThrow() = value

    override fun valueOr(default: @UnsafeVariance T): T = value

    override fun exists(): Boolean = true
}