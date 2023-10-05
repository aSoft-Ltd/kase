@file:JsExport

package kase

import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
data class Status(
    val code: Int,
    val message: String
)