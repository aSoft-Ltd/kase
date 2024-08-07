package kase.response

import io.ktor.server.application.ApplicationCall
import io.ktor.server.routing.*
import io.ktor.util.pipeline.PipelineContext
import kotlinx.serialization.StringFormat


inline fun <reified D> Routing.post(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> D
) = post(path) { respondJson(codec) { block() } }

inline fun <reified D> Routing.patch(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> D
) = patch(path) { respondJson(codec) { block() } }

inline fun <reified D> Routing.delete(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> D
) = delete(path) { respondJson(codec) { block() } }

inline fun <reified D> Routing.get(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> D
) = get(path) { respondJson(codec) { block() } }