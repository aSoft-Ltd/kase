@file:Suppress("NOTHING_TO_INLINE")

package kase

inline fun <D> responseOf(value: D): Response<D> = Successful(value)