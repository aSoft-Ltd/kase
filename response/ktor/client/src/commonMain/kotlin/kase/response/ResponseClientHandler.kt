package kase.response

import io.ktor.client.statement.*
import kase.Error
import kase.Failed
import kase.Response
import kase.Status
import kase.Successful
import kase.toError
import kotlinx.serialization.StringFormat
import kotlinx.serialization.serializer
import lexi.LogTracer
import lexi.Logger

@Suppress("ThrowableNotThrown")
suspend inline fun <reified T> HttpResponse.getOrThrow(codec: StringFormat, tracer: LogTracer): T {
    val txt = bodyAsText()
    tracer.debug(txt)
    val status = toStatus()
    val res: Response<T> = try {
        Successful(
            status = status,
            data = codec.decodeFromString(serializer(), txt)
        )
    } catch (exp: Throwable) {
        try {
            Failed(
                status = status,
                error = codec.decodeFromString(Error.serializer(), txt)
            )
        } catch (cause: Throwable) {
            cause.addSuppressed(exp)
            Failed(status, cause.toError())
        }
    }
    when (res) {
        is Successful -> tracer.passed()
        is Failed -> tracer.failed(res.error.toException())
    }
    return res.getOrThrow()
}

@PublishedApi
internal fun HttpResponse.toStatus() = Status(status.value, status.description)