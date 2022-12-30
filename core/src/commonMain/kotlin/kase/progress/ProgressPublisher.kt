@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase.progress

import kollections.List
import kotlin.js.JsExport

interface ProgressPublisher {
    fun setStages(vararg stageNames: String): List<Stage>
    fun updateProgress(p: StageProgress): ProgressState
}