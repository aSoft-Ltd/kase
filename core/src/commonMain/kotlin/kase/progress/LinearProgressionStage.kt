@file:JsExport

package kase.progress

import kotlinx.JsExport

interface LinearProgressionStage<out T> : ProgressionStage {
    override val progress: SimpleProgression<T>
}