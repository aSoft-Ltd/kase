package kase.internal

import kase.Executing
import kase.ExecutorState
import kase.Failure
import kase.Pending
import kase.progress.Progress
import kase.progress.ProgressState
import kase.progress.StageProgress
import kase.Success

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

    override fun <D> invoke(state: ExecutorState<D>) = when (state) {
        is Pending -> StageProgressImpl(name, number, outOf, 0, 1)
        is Executing -> StageProgressImpl(name, number, outOf, state.progress.done, state.progress.total)
        is Success -> StageProgressImpl(name, number, outOf, 100, 100)
        is Failure -> StageProgressImpl(name, number, outOf, 100, 100)
    }
}