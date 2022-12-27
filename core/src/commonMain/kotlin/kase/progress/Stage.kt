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

    @JsName("_ignore_invoke1")
    operator fun invoke(done: Long, total: Long): StageProgress

    @JsName("_ignore_invoke2")
    operator fun invoke(progress: StageProgress): StageProgress

    @JsName("_ignore_invoke3")
    operator fun invoke(progress: ProgressState): StageProgress

    @JsName("_ignore_invoke4")
    operator fun <D> invoke(state: ExecutorState<D>): StageProgress
}