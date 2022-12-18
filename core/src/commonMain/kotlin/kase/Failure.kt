@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import presenters.actions.SimpleAction

data class Failure<out D>(
    val cause: Throwable,
    val message: String = cause.message ?: DEFAULT_MESSAGE,
    override val data: D? = null,
    val actions: List<SimpleAction>
) : EagerState<D>, LazyState<D>, Result<D> {
    override val asPending: Pending? = null
    override val asLoading: Loading<D>? = null
    override val asSuccess: Success<D>? = null
    override val asFailure: Failure<D> = this

    override fun <R> map(transform: (D) -> R): Failure<R> = mapToKase(transform)

    override fun catch(resolver: (Throwable) -> @UnsafeVariance D): Result<D> = catchToKase(resolver).asResult()

    companion object {
        val DEFAULT_MESSAGE = "Unknown error"
    }
}