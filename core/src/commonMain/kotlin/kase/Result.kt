@file:JsExport

package kase

import kotlin.js.JsExport

/**
 * A Result is a state model that models outcome
 *
 * Conceptually, these are things that have already finished worked and
 * have a result/response which may either be a [Success] or [Failure].
 */
sealed interface Result<out D> : State<D>, CanSucceed<D>, CanFail<D> {

    fun <R> map(transform: (D) -> R): Result<R>

    fun catch(resolver: (Throwable) -> @UnsafeVariance D): Result<D>
}