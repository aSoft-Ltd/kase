@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

interface CanLoad<out D> {
    val asLoading: Loading<D>?
}