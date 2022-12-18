@file:JsExport

package kase

import kotlin.js.JsExport

interface CanFail<out D> {
    val asFailure: Failure<D>?
}