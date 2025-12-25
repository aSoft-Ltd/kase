package kase.progress

abstract class AbstractProgressBag : ProgressBus {
    private val stages: MutableMap<String, StageProgress> = mutableMapOf()
    var progress: ProgressState = ProgressState.initial()
    protected val handlers: MutableList<(ProgressState) -> Unit> = mutableListOf()

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
        handlers.forEach { it(progress) }
        return progress
    }
}