package kase.internal

import kase.Progress
import kase.ProgressState
import kase.StageProgress

@PublishedApi
internal data class StageProgressImpl(
    /**
     * The name of the current stage
     */
    override val name: String,
    /**
     * The number of the current state. e.g. Stage `1`
     */
    override val number: Int,

    /**
     * Total number of stages
     */
    override val outOf: Int,

    /**
     * Amount completed in this stage
     */
    override val done: Long,

    /**
     * Total quantity required to be done for completion
     */
    override val total: Long
) : Progress by ProgressImpl(done, total), StageProgress {

    override fun invoke(progress: StageProgress) = StageProgressImpl(name, number, outOf, progress.done, progress.total)

    override fun invoke(done: Long, total: Long) = StageProgressImpl(name, number, outOf, done, total)

    override fun invoke(progress: ProgressState) = StageProgressImpl(name, number, outOf, progress.current.done, progress.current.total)
}