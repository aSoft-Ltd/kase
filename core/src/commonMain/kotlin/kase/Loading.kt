@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kase.progress.ProgressState
import kotlin.js.JsExport

data class Loading<out D>(
    val message: String,
    override val data: D? = null,
    val progress: ProgressState = ProgressState.initial()
) : LazyState<D>, EagerState<D> {
    override val asPending: Nothing? = null
    override val asLoading: Loading<D> = this
    override val asSuccess: Nothing? = null
    override val asFailure: Nothing? = null
}