@file:JsExport
package kase

import kotlin.js.JsExport

sealed interface Response<out D> : Possible<D> {
    val status: Status

    val asSuccessful get() = this as? Successful
    val asFailure get() = this as? Failed
}