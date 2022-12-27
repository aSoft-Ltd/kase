@file:JsExport

package kase

import kotlin.js.JsExport

sealed interface State<out D> {
    val data: D?
}