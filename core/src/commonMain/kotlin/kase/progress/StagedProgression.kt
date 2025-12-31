@file:JsExport

package kase.progress

import kotlinx.JsExport

interface StagedProgression : Progression {
    val stages: List<ProgressionStage>
}