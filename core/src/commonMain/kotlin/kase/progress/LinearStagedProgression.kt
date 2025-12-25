@file:JsExport

package kase.progress

import kotlinx.JsExport

interface LinearStagedProgression : Progression {
    val stages: List<ProgressionStage>
}