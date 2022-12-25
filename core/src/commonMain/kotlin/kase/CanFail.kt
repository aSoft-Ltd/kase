@file:JsExport

package kase

import kotlin.js.JsExport

sealed interface CanFail<out D> {
    val asFailure: Failure<D>?
}