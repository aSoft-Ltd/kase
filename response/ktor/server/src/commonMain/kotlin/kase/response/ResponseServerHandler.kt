package kase.response

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.util.pipeline.PipelineContext
import kase.Failed
import kase.ResponseException
import kase.Status
import kase.Successful
import kase.toFailed
import kotlinx.serialization.StringFormat
import kotlinx.serialization.encodeToString

suspend inline fun <reified D> PipelineContext<*, ApplicationCall>.respondJson(codec: StringFormat, block: () -> D) = try {
//    call.response.header("Content-Security-Policy","default-src 'self'")
    call.respond(codec, Successful(block()))
} catch (exp: ResponseException) {
//    call.response.header("Content-Security-Policy","default-src 'self'")
    call.respond(codec, exp.toFailed())
} catch (err: Throwable) {
//    call.response.header("Content-Security-Policy","default-src 'self'")
    call.respond(codec, err.toFailed())
}

suspend inline fun <reified D> ApplicationCall.respond(codec: StringFormat, res: Successful<D>) = respondText(
    text = codec.encodeToString<Successful<D>>(res),
    contentType = ContentType.Application.Json,
    status = res.status.toKtorStatus()
)

suspend fun ApplicationCall.respond(codec: StringFormat, res: Failed) = respondText(
    text = codec.encodeToString<Failed>(res),
    contentType = ContentType.Application.Json,
    status = res.status.toKtorStatus()
)

inline fun Status.toKtorStatus() = HttpStatusCode(code, message)