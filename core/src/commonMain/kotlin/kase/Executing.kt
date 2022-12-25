@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

data class Executing(
    val message: String = "Loading . . ."
) : LazyState<Nothing>, EagerState<Nothing>, ExecutorState<Nothing> {
    override val data: Nothing? = null
    override val asPending: Pending? = null
    override val asLoading: Loading<Nothing>? = null
    override val asExecuting: Executing = this
    override val asSuccess: Success<Nothing>? = null
    override val asFailure: Failure<Nothing>? = null
}