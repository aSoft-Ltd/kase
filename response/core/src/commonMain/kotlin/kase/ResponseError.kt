@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlinx.serialization.Serializable
import kotlinx.JsExport
import kotlinx.JsExportIgnore
import kotlin.js.JsName
import kotlin.jvm.JvmOverloads

@Serializable
data class ResponseError(
    val message: String,
    val type: String,
    val cause: String,
    val stackTrace: String = ""
) {

    @JvmOverloads
    @JsExportIgnore
    constructor(error: Throwable, message: String? = null) : this(
        message = message ?: error.message ?: "Unknown",
        type = error::class.simpleName ?: "Unknown",
        cause = (if (message == null) error.cause?.message else error.message) ?: "Unknown",
        stackTrace = error.stackTraceToString()
    )

    fun toException() = RuntimeException(message, RuntimeException(cause))
}