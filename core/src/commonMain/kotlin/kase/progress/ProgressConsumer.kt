@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase.progress

import kotlinx.JsExport

interface ProgressConsumer {
    fun onUpdate(callback: (ProgressState) -> Unit)
}