package kase.progress

import kase.internal.StageProgressImpl

inline fun StagedProgress(
    name: String,
    number: Int,
    outOf: Int,
    done: Long,
    total: Long
): StageProgress = StageProgressImpl(name, number, outOf, done, total)

inline fun Stage(
    name: String,
    number: Int,
    outOf: Int
): Stage = StageProgressImpl(name, number, outOf, 0L, 0L)