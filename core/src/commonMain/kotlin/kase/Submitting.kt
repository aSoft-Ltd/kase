@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

data class Submitting(val json: String) : FormState<Nothing> {
    override val data: Nothing? = null

    override val asPending: Pending? = null
    override val asValidating: Validating? = null
    override val asSubmitting: Submitting = this
    override val asSuccess: Success<Nothing>? = null
    override val asFailure: Failure<Nothing>? = null
}