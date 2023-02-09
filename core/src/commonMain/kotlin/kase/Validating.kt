@file:JsExport

package kase

import kotlin.js.JsExport

object Validating : FormState<Nothing> {

    override val data: Nothing? = null

    override val asPending: Nothing? = null
    override val asValidating: Validating = this
    override val asSuccess: Nothing? = null
    override val asFailure: Nothing? = null
    override val asSubmitting: Nothing? = null

    override fun toString(): String = "Validating"
}