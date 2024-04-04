package kase.response

import io.ktor.server.application.ApplicationCall
import io.ktor.server.routing.Routing
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.patch
import io.ktor.util.pipeline.PipelineContext
import kotlinx.serialization.StringFormat

inline fun <reified D> Routing.post(
    path: String,
    codec: StringFormat,
    noinline block: suspend PipelineContext<*, ApplicationCall>.() -> D
) = post(path) { respondJson(codec) { block() } }

inline fun <reified D> Routing.patch(
    path: String,
    codec: StringFormat,
    noinline block: suspend PipelineContext<*, ApplicationCall>.() -> D
) = patch(path) { respondJson(codec) { block() } }

inline fun <reified D> Routing.delete(
    path: String,
    codec: StringFormat,
    noinline block: suspend PipelineContext<*, ApplicationCall>.() -> D
) = delete(path) { respondJson(codec) { block() } }

inline fun <reified D> Routing.get(
    path: String,
    codec: StringFormat,
    noinline block: suspend PipelineContext<*, ApplicationCall>.() -> D
) = get(path) { respondJson(codec) { block() } }