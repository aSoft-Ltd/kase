package kase

import kollections.iListOf
import kotlinx.serialization.KSerializer
import kotlinx.serialization.StringFormat
import kotlinx.serialization.serializer

inline fun <reified D> StringFormat.decodeResponseFromString(json: String) = decodeResponseFromString(
    serializer = serializer<D>(),
    json = json
)

fun <D> StringFormat.decodeResponseFromString(serializer: KSerializer<D>, json: String): Response<D> = try {
    decodeFromString(Successful.serializer(serializer), json)
} catch (err: Throwable) {
    try {
        decodeFromString(Failed.serializer(), json)
    } catch (_: Throwable) {
        val e = Error(
            message = err.message ?: "Unknown",
            type = "Bad server response",
            cause = err.cause?.message ?: "Unknown",
            stackTrace = err.stackTraceToString()
        )
        Failed(Status(606, "Internal API Error"), iListOf(e))
    }
}

inline fun <reified D> StringFormat.encodeResponseToString(value: Response<D>) = encodeResponseToString(
    serializer = serializer<D>(),
    value = value
)

fun <D> StringFormat.encodeResponseToString(serializer: KSerializer<D>, value: Response<D>): String = when (value) {
    is Failed -> encodeToString(Failed.serializer(), value)
    is Successful -> encodeToString(Successful.serializer(serializer), value)
}