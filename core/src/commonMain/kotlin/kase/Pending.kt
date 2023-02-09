@file:JsExport

package kase

import kotlin.js.JsExport

object Pending : LazyState<Nothing>, ExecutorState<Nothing>, FormState<Nothing> {

    override val data: Nothing? = null

    override val asPending: Pending = this
    override val asValidating: Nothing? = null
    override val asLoading: Nothing? = null
    override val asSubmitting: Nothing? = null
    override val asExecuting: Nothing? = null
    override val asSuccess: Nothing? = null
    override val asFailure: Nothing? = null

    override fun toString(): String = "Pending"
}