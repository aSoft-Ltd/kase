@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import actions.SimpleAction
import kollections.iListOf
import kotlin.js.JsExport

data class Failure<out D>(
    val cause: Throwable,
    val message: String = cause.message ?: DEFAULT_MESSAGE,
    override val data: D? = null,
    val actions: List<SimpleAction> = iListOf()
) : EagerState<D>, LazyState<D>, Result<D>, ExecutorState<D>, FormState<D> {
    override val asPending: Pending? = null
    override val asLoading: Loading<D>? = null
    override val asValidating: Validating? = null
    override val asSubmitting: Submitting? = null
    override val asExecuting: Executing? = null
    override val asSuccess: Success<D>? = null
    override val asFailure: Failure<D> = this

    override fun <R> map(transform: (D) -> R): Failure<R> = mapToState(transform)

    override fun catch(resolver: (Throwable) -> @UnsafeVariance D): Result<D> = catchToState(resolver) as Result<D>

    companion object {
        val DEFAULT_MESSAGE = "Unknown error"
    }
}