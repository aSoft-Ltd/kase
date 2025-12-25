@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase.progress

import kase.internal.ProgressImpl
import kotlinx.JsExport
import kotlin.math.round

data class ProgressState(
    val current: StageProgress,
    val stages: List<StageProgress>,
) : Progress by ProgressImpl(percentDone = percentDone(stages)) {

    companion object {

        fun initial() = makeProgressState("Initial", 0, 100)

        fun unset() = makeProgressState("Unset", 0, 1)

        private fun makeProgressState(name: String, done: Long, total: Long): ProgressState {
            val stage = Stage(name, 1, 1)
            val current = stage(done, total)
            return ProgressState(
                current = current,
                stages = listOf(current)
            )
        }

        private fun percentDone(stages: List<StageProgress>): Double {
            if (stages.isEmpty()) return 0.0
            var total = 0.0
            val interval = 100.0 / stages.size
            stages.forEach { stage ->
                total += interval * stage.doneFraction
            }
            return round(total)
        }
    }
}