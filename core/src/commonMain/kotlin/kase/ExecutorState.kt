@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

/**
 * An ExecutorState is a state model that passes through an [Executing] phase.
 *
 * Conceptually, these are things that start from a [Pending] state.
 * The need to be explicitly started for them to begin Execution and
 * enter into an [Executing] state. Hence the name, Executor
 */
sealed interface ExecutorState<out D> : Kase<D>, CanPend, CanExec, CanPass<D>, CanFail<D>