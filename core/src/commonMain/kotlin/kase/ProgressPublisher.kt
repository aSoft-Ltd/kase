package kase

interface ProgressPublisher {
    fun setStages(vararg stages: String): List<Stage>
    fun updateProgress(progress: StageProgress): ProgressState
}