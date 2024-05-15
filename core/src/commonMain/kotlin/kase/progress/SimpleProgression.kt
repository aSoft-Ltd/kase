@file:JsExport

package kase.progress

import kotlinx.JsExport

interface SimpleProgression<out T> : Progression {
    val done: T
    val total: T
    val left: T
}