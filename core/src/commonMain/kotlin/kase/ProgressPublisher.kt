package kase

import kollections.List

interface ProgressPublisher {
    fun setStages(vararg stageNames: String): List<Stage>
    fun updateProgress(progress: StageProgress): ProgressState
}