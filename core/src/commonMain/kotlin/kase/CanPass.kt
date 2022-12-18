@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

interface CanPass<out D> {
    val asSuccess: Success<D>?
}