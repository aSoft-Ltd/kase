@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

data class Success<out D>(
    override val data: D
) : LazyState<D>, EagerState<D>, Result<D>, ExecutorState<D>, FormState<D> {
    override val asPending: Pending? = null
    override val asLoading: Loading<D>? = null
    override val asValidating: Validating? = null
    override val asSubmitting: Submitting? = null
    override val asExecuting: Executing? = null
    override val asSuccess: Success<D> = this
    override val asFailure: Failure<D>? = null

    override fun <R> map(transform: (D) -> R): Result<R> = mapToState(transform) as Result<R>

    override fun catch(resolver: (Throwable) -> @UnsafeVariance D): Result<D> = this
}