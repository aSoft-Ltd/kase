@file:JsExport

package kase

import kotlin.js.JsExport

data class Submitting(val json: String) : FormState<Nothing> {
    override val data: Nothing? = null

    override val asPending: Nothing? = null
    override val asValidating: Nothing? = null
    override val asSubmitting: Submitting = this
    override val asSuccess: Nothing? = null
    override val asFailure: Nothing? = null

    override fun toString(): String = "Submitting $json"
}