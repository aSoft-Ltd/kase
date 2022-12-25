@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

sealed interface CanExec {
    val asExecuting: Executing?
}