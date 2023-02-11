@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kase.None.Companion.NONE
import kotlin.js.JsExport

data class Some<out T : Any>(override val value: T) : Possible<T> {

    override fun <R : Any> map(transform: (T) -> R): Possible<R> = try {
        Some(transform(value))
    } catch (_: Throwable) {
        NONE
    }

    override fun <R : Any> flatMap(transform: (T) -> Possible<R>): Possible<R> = try {
        transform(value)
    } catch (_: Throwable) {
        NONE
    }

    override fun recover(fn: () -> @UnsafeVariance T): Some<T> = this

    override fun valueOrThrow() = value

    override fun valueOr(default: @UnsafeVariance T): T = value
}