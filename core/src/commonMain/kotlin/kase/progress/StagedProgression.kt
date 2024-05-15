@file:JsExport

package kase.progress

import kollections.List
import kotlinx.JsExport

interface StagedProgression : Progression {
    val stages: List<ProgressionStage>
}