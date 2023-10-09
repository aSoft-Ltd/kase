@file:Suppress("NOTHING_TO_INLINE")

package kase

inline fun <D> responseOf(value: D): Response<D> = Successful(value)

inline fun ResponseException.toFailed() = Failed(
    status = status,
    error = toError()
)

inline fun Throwable.toFailed(code: Int = 400, message: String = this.message ?: "Error") = Failed(
    status = Status(code, message),
    error = toError()
)

@PublishedApi
internal fun Throwable?.toError() = if (this != null) Error(
    message = message ?: "Unknown",
    type = this::class.simpleName ?: "Unknown",
    cause = cause?.message ?: "Unknown",
    stackTrace = stackTraceToString()
) else Error(
    message = "Unknown error",
    type = "Unknown type",
    cause = "Unknown cause",
    stackTrace = ""
)