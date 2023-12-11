@file:JsExport

package kase

import kotlinx.JsExport
import kotlin.js.JsName

interface Possible<out T> {
    @Throws(Throwable::class)
    @JsName("valueOrThrowException")
    fun valueOrThrow(exp: Throwable): T

    @Throws(Throwable::class)
    @JsName("getOrThrowException")
    fun getOrThrow(exp: Throwable): T

    @Throws(Throwable::class)
    @JsName("valueOrThrowMessage")
    fun valueOrThrow(msg: String): T

    @Throws(Throwable::class)
    @JsName("getOrThrowMessage")
    fun getOrThrow(msg: String): T

    @Throws(NoSuchElementException::class)
    fun valueOrThrow(): T

    @Throws(NoSuchElementException::class)
    fun getOrThrow(): T

    fun valueOr(default: @UnsafeVariance T): T

    fun getOr(default: @UnsafeVariance T): T

    fun valueOrNull(): T?

    fun getOrNull(): T?

    fun exists(): Boolean
}