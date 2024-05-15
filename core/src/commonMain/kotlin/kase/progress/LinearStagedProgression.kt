@file:JsExport

package kase.progress

import kollections.List
import kotlinx.JsExport

interface LinearStagedProgression : Progression {
    val stages: List<ProgressionStage>
}