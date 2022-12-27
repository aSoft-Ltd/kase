package kase.progress

import kollections.List

interface ProgressPublisher {
    fun setStages(vararg stageNames: String): List<Stage>
    fun updateProgress(p: StageProgress): ProgressState
}