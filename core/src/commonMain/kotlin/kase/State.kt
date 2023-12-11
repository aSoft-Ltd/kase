@file:JsExport

package kase

import kotlinx.JsExport

sealed interface State<out D> {
    val data: D?
}