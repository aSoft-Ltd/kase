@file:JsExport
package kase.progress

import kotlinx.JsExport

interface ProgressionStage {
    val name: String
    val index: Int
    val progress: Progression
}