@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlinx.JsExport

sealed interface CanPend {
    val asPending: Pending?
}

sealed interface CanLoad<out D> {
    val asLoading: Loading<D>?
}

sealed interface CanExecute {
    val asExecuting: Executing?
}

sealed interface CanSucceed<out D> {
    val asSuccess: Success<D>?
}

sealed interface CanFail<out D> {
    val asFailure: Failure<D>?
}