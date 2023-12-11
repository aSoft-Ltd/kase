@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase.progress

import kase.ExecutorState
import kotlinx.JsExport
import kotlin.js.JsName
import kotlinx.JsExportIgnore

interface Stage {
    /**
     * The name of the current stage
     */
    val name: String

    /**
     * The number of the current state. e.g. Stage `1`
     */
    val number: Int

    /**
     * Total number of stages
     */
    val outOf: Int

    @JsExportIgnore
    operator fun invoke(done: Int, total: Int): StageProgress
    @JsExportIgnore
    operator fun invoke(done: Long, total: Long): StageProgress

    @JsExportIgnore
    operator fun invoke(progress: StageProgress): StageProgress

    @JsExportIgnore
    operator fun invoke(progress: ProgressState): StageProgress

    @JsExportIgnore
    operator fun <D> invoke(state: ExecutorState<D>): StageProgress
}