@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kase.internal.AbstractPossible
import kotlin.js.JsExport

data class Success<out D>(
    override val data: D
) : AbstractPossible<D>(), LazyState<D>, Result<D>, ExecutorState<D> {
    override val asPending: Nothing? = null
    override val asLoading: Nothing? = null
    override val asExecuting: Nothing? = null
    override val asSuccess: Success<D> = this
    override val asFailure: Nothing? = null

    override fun <R> map(transform: (D) -> R): Result<R> = mapToState(transform) as Result<R>

    override fun catch(resolver: (Throwable) -> @UnsafeVariance D): Result<D> = this

    override fun andCatch(resolver: (Throwable) -> Result<@UnsafeVariance D>): Result<D> = this

    override fun exists(): Boolean = true

    override fun valueOr(default: @UnsafeVariance D): D = data

    override fun valueOrNull(): D = data

    override fun valueOrThrow(): D = data

    override fun valueOrThrow(exp: Throwable): D = data

    override fun valueOrThrow(msg: String): D = data
}