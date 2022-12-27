package kase.internal

import kase.progress.Progress
import kotlin.math.round

@PublishedApi
internal class ProgressImpl(
    override val done: Long,
    override val total: Long,
    override val doneAmountAsDouble: Double,
    override val totalAmountAsDouble: Double
) : Progress {
    override val doneFraction = if (total != 0L) (done.toDouble() / total.toDouble()) else 0.0

    override val donePercentage = round(100 * doneFraction)

    override val remainingFraction = 1 - doneFraction

    override val remainingPercentage = 100 - donePercentage

    companion object {
        inline operator fun invoke(done: Long, total: Long): Progress = ProgressImpl(
            done, total, done.toDouble(), total.toDouble()
        )

        inline operator fun invoke(percentDone: Double): Progress = ProgressImpl(
            done = percentDone.toLong(),
            total = 100,
            doneAmountAsDouble = percentDone,
            totalAmountAsDouble = 100.0
        )
    }
}