@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kase.progress.ProgressState
import kotlinx.JsExport

data class Executing(
    val message: String = "Executing . . .",
    val progress: ProgressState = ProgressState.initial()
) : ExecutorState<Nothing> {
    override val data: Nothing? = null

    override val asPending: Nothing? = null
    override val asExecuting: Executing = this
    override val asSuccess: Nothing? = null
    override val asFailure: Nothing? = null
}