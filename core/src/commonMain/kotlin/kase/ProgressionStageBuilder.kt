package kase

import kase.progress.SimpleProgression

interface ProgressionStageBuilder<T> {
    operator fun invoke(done: T, total: T): SimpleProgression<T>
}