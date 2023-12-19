package kase.progress

import kollections.List
import kollections.toList
import kollections.MutableMap
import kollections.mutableMapOf
import kollections.set
import kollections.putAll
import kollections.mapIndexed
import kollections.associate
import kollections.values

class StageProgressBag : ProgressPublisher {
    private val stages: MutableMap<String, StageProgress> = mutableMapOf()
    var progress: ProgressState = ProgressState.initial()

    override fun setStages(vararg stageNames: String): List<Stage> {
        stages.clear()
        val sgs = stageNames.mapIndexed { index, s ->
            Stage(s, index + 1, stageNames.size)
        }.associate { it.name to it(0, 0) }
        stages.putAll(sgs)
        return sgs.values.toList()
    }

    override fun updateProgress(p: StageProgress): ProgressState {
        stages[p.name] = p
        progress = ProgressState(
            current = p,
            stages = stages.values.toList()
        )
        return progress
    }
}