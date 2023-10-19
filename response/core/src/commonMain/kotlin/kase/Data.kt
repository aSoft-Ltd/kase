package kase

import kotlinx.serialization.Serializable

@Serializable
data class Data<out D>(val data: D)