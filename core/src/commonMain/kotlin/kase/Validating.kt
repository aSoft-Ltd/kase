@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

object Validating : FormState<Nothing> {

    override val data: Nothing? = null

    override val asPending: Pending? = null
    override val asValidating: Validating = this
    override val asSuccess: Success<Nothing>? = null
    override val asFailure: Failure<Nothing>? = null
    override val asSubmitting: Submitting? = null

    override fun toString(): String = "Validating"
}