@file:JsExport

package kase

import kotlinx.serialization.Serializable
import kotlinx.JsExport

@Serializable
data class Status(
    val code: Int,
    val message: String
) {
    companion object {
        val CODE_200_Ok by lazy { Status(200, "Ok") }
        val CODE_401_Unauthorized by lazy { Status(401,"Unauthorized") }
        val CODE_409_Conflict by lazy { Status(409, "Conflict") }
    }
}