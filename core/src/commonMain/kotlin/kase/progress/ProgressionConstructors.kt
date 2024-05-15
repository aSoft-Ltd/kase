@file:Suppress("NOTHING_TO_INLINE")

package kase.progress

import kase.ProgressionStageBuilder
import kase.internal.SimpleNumberProgressionImpl


inline fun Progression(
    done: Number,
    total: Number
): SimpleProgression<Double> = SimpleNumberProgressionImpl(done, total)

fun <T> Progression(vararg stages: String) : List<ProgressionStageBuilder<T>> {
    val builder = StageProgressionBuilder<T>(stages)
    return builder.stages
}

class StageProgressionBuilder<T>(private val names: Array<out String>) {
    val stages = names.mapIndexed { index, s -> ProgressionStageBuilderImpl(s, index) }

    inner class ProgressionStageBuilderImpl(
        val name: String,
        val index: Int
    ) : ProgressionStageBuilder<T> {
        override fun invoke(done: T, total: T): SimpleProgression<T> {
            TODO()
        }
    }
}