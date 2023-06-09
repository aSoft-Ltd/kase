@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kevlar.Action0
import kase.internal.AbstractPossible
import kollections.iListOf
import kotlin.js.JsExport

data class Failure<out D>(
    val cause: Throwable,
    val message: String = cause.message ?: DEFAULT_MESSAGE,
    override val data: D? = null,
    val actions: List<Action0<Unit>> = iListOf()
) : AbstractPossible<D>(), EagerState<D>, LazyState<D>, Result<D>, ExecutorState<D>, FormState<D> {
    override val value: D? = data
    override val asPending: Nothing? = null
    override val asLoading: Nothing? = null
    override val asValidating: Nothing? = null
    override val asSubmitting: Nothing? = null
    override val asExecuting: Nothing? = null
    override val asSuccess: Nothing? = null
    override val asFailure: Failure<D> = this

    override fun <R> map(transform: (D) -> R): Failure<R> = mapToState(transform)

    override fun catch(resolver: (Throwable) -> @UnsafeVariance D): Result<D> = catchToState(resolver) as Result<D>

    override fun andCatch(resolver: (Throwable) -> Result<@UnsafeVariance D>): Result<D> = resolver(cause)

    override fun exists(): Boolean = false

    override fun valueOr(default: @UnsafeVariance D): D = default

    override fun valueOrThrow(): D = throw cause

    override fun valueOrThrow(exp: Throwable): D {
        exp.addSuppressed(cause)
        throw exp
    }

    override fun valueOrNull(): D? = data

    override fun valueOrThrow(msg: String): D = valueOrThrow(RuntimeException(msg, cause))

    companion object {
        val DEFAULT_MESSAGE = "Unknown error"
    }
}