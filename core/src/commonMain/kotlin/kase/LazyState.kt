@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

/**
 * A LazyState is a state model that starts lazily.
 *
 * Conceptually, these are things that start from a [Pending] state.
 * The need to be explicitly started for them to begin their work and
 * enter into an execution/[Loading] state. Hence the name, Lazy
 */
sealed interface LazyState<out D> : Kase<D>, CanPend, CanLoad<D>, CanPass<D>, CanFail<D> {
    val data: D?
}