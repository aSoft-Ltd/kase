@file:JsExport
@file:Suppress("NOTHING_TO_INLINE")

package kase

import kotlin.js.JsExport

inline fun <T : Any> bagOf(value: T? = null): Bag<T> = Bag(value)