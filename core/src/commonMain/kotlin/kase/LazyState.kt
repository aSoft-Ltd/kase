@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlinx.JsExport

/**
 * A LazyState is a state model that starts lazily.
 *
 * Conceptually, these are things that start from a [Pending] state.
 * The need to be explicitly started for them to begin their work and
 * enter into a [Loading] state. Hence the name, Lazy
 */
sealed interface LazyState<out D> : State<D>, CanPend, CanLoad<D>, CanSucceed<D>, CanFail<D>