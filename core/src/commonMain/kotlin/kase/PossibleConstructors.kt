@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kase.None.Companion.NONE
import kotlin.js.JsExport
import kotlin.jvm.JvmOverloads

@JvmOverloads
inline fun <T : Any> possibleOf(value: T? = null): Possible<T> = if (value != null) Some(value) else NONE

inline fun <T : Any> none(): None<T> = NONE

inline fun <T : Any> some(value: T) = Some(value)