@file:JsExport

package kase

import kotlin.js.JsExport

sealed interface Possible<out T : Any> {
    fun <R : Any> map(transform: (T) -> R): Possible<R>
    fun <R : Any> flatMap(transform: (T) -> Possible<R>): Possible<R>
    fun valueOrThrow(): T
    fun valueOrNull(): T?
}