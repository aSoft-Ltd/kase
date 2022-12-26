@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kotlin.js.JsExport

interface Progress {

    /**
     * Amount completed in this stage
     */
    val done: Long

    /**
     * Total quantity required to be done for completion
     */
    val total: Long

    val doneAmountAsDouble: Double

    val totalAmountAsDouble: Double


    val doneFraction: Double

    val remainingFraction: Double


    val donePercentage: Double

    val remainingPercentage: Double
}