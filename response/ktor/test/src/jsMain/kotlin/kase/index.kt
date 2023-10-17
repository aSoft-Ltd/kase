@file:JsExport

package kase

import kotlin.random.Random

fun randomIntResponse() = responseOf(Random.nextInt())

fun randomIntResult() = catching { Random.nextInt() }