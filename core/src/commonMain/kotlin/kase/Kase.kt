package kase

sealed interface Kase<out D> {
    val data: D?
}