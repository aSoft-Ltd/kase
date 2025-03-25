@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")
package kase

import kotlinx.JsExport

sealed interface UploaderState {
    val asUninitialized get() = this as? UploaderUninitialized
    val asNotUploaded get() = this as? UploaderNotUploaded
    val asUploading get() = this as? UploaderUploadingProgress
    val asUploaded get() = this as? UploaderUploaded
    val asFailed get() = this as? UploaderUploadFailed
}

data object UploaderUninitialized : UploaderState

data object UploaderNotUploaded : UploaderState

data object UploaderUploadingProgress : UploaderState

data object UploaderUploaded : UploaderState

data class UploaderUploadFailed(
    val cause: Throwable
) : UploaderState