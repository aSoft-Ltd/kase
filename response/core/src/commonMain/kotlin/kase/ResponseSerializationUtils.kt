package kase

import kotlinx.serialization.KSerializer
import kotlinx.serialization.StringFormat
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.serializer

/*
inline fun <reified D> StringFormat.decodeResponseFromString(json: String) = decodeResponseFromString(
    serializer = serializer<D>(),
    json = json
)

fun <D> StringFormat.decodeResponseFromString(serializer: KSerializer<D>, json: String): Response<D> = try {
    responseOf(decodeFromString(serializer, json))
} catch (err: Throwable) {
    try {
        decodeFromString(Error.serializer(), json)
    } catch (cause: Throwable) {
        Failed(Status(606, "Internal API Error"), cause.toError())
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
 */