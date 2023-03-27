@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport
import kotlin.jvm.JvmOverloads

@JvmOverloads
inline fun <T : Any> optionalOf(value: T? = null): Optional<T> = when (value) {
    null -> None
    else -> Some(value)
}

inline fun <T : Any> none(): None<T> = None

inline fun <T : Any> some(value: T) = Some(value)