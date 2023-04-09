@file:JsExport

package kase

import kotlin.js.JsExport
import kotlin.js.JsName

sealed interface Possible<out T> {
    val value: T?

    @Throws(Throwable::class)
    @JsName("valueOrThrowException")
    fun valueOrThrow(exp: Throwable): T

    @Throws(Throwable::class)
    @JsName("valueOrThrowMessage")
    fun valueOrThrow(msg: String): T

    @Throws(NoSuchElementException::class)
    fun valueOrThrow(): T

    fun valueOr(default: @UnsafeVariance T): T

    fun exists(): Boolean
}