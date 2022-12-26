@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

data class Loading<out D>(
    val message: String = "Loading . . .",
    override val data: D? = null,
    val progress: ProgressState = ProgressState.initial(),
) : LazyState<D>, EagerState<D> {
    override val asPending: Pending? = null
    override val asLoading: Loading<D> = this
    override val asSuccess: Success<D>? = null
    override val asFailure: Failure<D>? = null
}