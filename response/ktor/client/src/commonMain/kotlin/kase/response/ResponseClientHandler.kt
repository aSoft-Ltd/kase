package kase.response

import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kase.Failed
import kase.Successful
import kase.decodeResponseFromString
import kotlinx.serialization.StringFormat
import lexi.Logger

suspend inline fun <reified T> HttpResponse.getOrThrow(codec: StringFormat, logger: Logger, action: String): T {
    val txt = bodyAsText()
    logger.debug(txt)
    val res = codec.decodeResponseFromString<T>(bodyAsText())
    when (res) {
        is Successful -> logger.info("$action Succeeded")
        is Failed -> logger.error("$action Failed", *arrayOf("reason" to res.error.message))
    }
    return res.getOrThrow()
}