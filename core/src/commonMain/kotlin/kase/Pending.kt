@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

object Pending : LazyState<Nothing> {

    override val asPending: Pending = this
    override val asLoading: Loading<Nothing>? = null
    override val asSuccess: Success<Nothing>? = null
    override val asFailure: Failure<Nothing>? = null

    override val data: Nothing? = null
    override fun toString(): String = "Pending"
}