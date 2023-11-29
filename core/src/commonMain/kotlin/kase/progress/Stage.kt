@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase.progress

import kase.ExecutorState
import kotlin.js.JsExport
import kotlin.js.JsName

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

    @JsExport.Ignore
    operator fun invoke(done: Int, total: Int): StageProgress
    @JsExport.Ignore
    operator fun invoke(done: Long, total: Long): StageProgress

    @JsExport.Ignore
    operator fun invoke(progress: StageProgress): StageProgress

    @JsExport.Ignore
    operator fun invoke(progress: ProgressState): StageProgress

    @JsExport.Ignore
    operator fun <D> invoke(state: ExecutorState<D>): StageProgress
}