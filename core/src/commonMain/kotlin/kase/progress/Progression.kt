@file:JsExport

package kase.progress

import kotlinx.JsExport

interface Progression {
    val fraction: ProgressionSplit
    val percentage: ProgressionSplit

    val asSimple get() = this as? SimpleProgression<*>
    val asStaged get() = this as? StagedProgression
}