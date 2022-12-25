@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

sealed interface CanPend {
    val asPending: Pending?
}