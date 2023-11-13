@file:Suppress("NOTHING_TO_INLINE")

package kase

inline fun <T> lazyStateOf(): LazyState<T> = Pending

inline fun <T> lazyStateOf(value: T): LazyState<T> = Success(value)