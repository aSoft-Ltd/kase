@file:JsExport
@file:Suppress("NOTHING_TO_INLINE")

package kase

import kollections.JsExport

inline fun <T : Any> bagOf(value: T? = null): Bag<T> = Bag(value)