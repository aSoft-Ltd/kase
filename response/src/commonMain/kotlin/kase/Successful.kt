@file:JsExport

package kase

import kase.internal.AbstractPossible
import kotlinx.serialization.Serializable
import kotlin.js.JsExport
import kotlin.js.JsName

@Serializable
data class Successful<out D>(
    override val status: Status,
    val data: D
) : AbstractPossible<D>(), Response<D> {

    @JsName("withData")
    constructor(data: D) : this(Status(200, "ok"), data)

    override fun valueOrThrow(exp: Throwable) = throw exp

    override fun valueOrThrow(msg: String) = data

    override fun valueOrThrow() = data

    override fun valueOrNull() = data

    override fun exists() = true

    override fun valueOr(default: @UnsafeVariance D) = data
}