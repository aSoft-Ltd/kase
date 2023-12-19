@file:JsExport

package kase

import kotlinx.JsExport
import kotlin.jvm.JvmOverloads

@JvmOverloads
inline fun <T : Any> optionalOf(value: T? = null): Optional<T> = when (value) {
    null -> none()
    else -> some(value)
}

inline fun <T : Any> none(): None<T> = None.instance

inline fun <T : Any> some(value: T) = Some(value)