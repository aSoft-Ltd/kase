@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kase.internal.AbstractPossible
import kotlin.js.JsExport

data class Failure<out D>(
    val cause: Throwable,
    val message: String = cause.message ?: DEFAULT_MESSAGE,
    override val data: D? = null
) : AbstractPossible<D>(), LazyState<D>, Result<D>, ExecutorState<D> {
    override val asPending: Nothing? = null
    override val asLoading: Nothing? = null
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

    override fun onSuccess(callback: (D) -> Unit) = this

    override fun onFailure(callback: (Throwable) -> Unit): Failure<D> {
        callback(cause)
        return this
    }

    companion object {
        val DEFAULT_MESSAGE = "Unknown error"
    }
}