@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

/**
 * An EagerState is a state model that starts eagerly.
 *
 * Conceptually, these are things that start from a [Loading] state, instead
 * of an Uninitialized/[Pending] state, Hence the name Eager, coz they begin
 * execution immediately after being started
 */
sealed interface EagerState<out D> : Kase<D>, CanLoad<D>, CanPass<D>, CanFail<D> {
    val data: D?
}