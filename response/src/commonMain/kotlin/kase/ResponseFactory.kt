@file:Suppress("NOTHING_TO_INLINE")

package kase

import kollections.iEmptyList
import kollections.iListOf

inline fun <D> responseOf(value: D): Response<D> = Successful(value)

inline fun Throwable.toFailed(code: Int = 400, message: String = this.message ?: "Error") = Failed(
    status = Status(code, message),
    errors = cause.toErrors()
)

private fun Throwable.toError() = Error(
    message = message ?: "Unknown",
    type = this::class.simpleName ?: "Unknown",
    cause = cause?.message ?: "Unknown",
    stackTrace = stackTraceToString()
)

@PublishedApi
internal fun Throwable?.toErrors() = if (this != null) iListOf(toError()) else iEmptyList()