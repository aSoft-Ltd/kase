package kase.progress

import kotlin.js.JsName

@JsName("progressBagOf")
inline fun ProgressBus() : ProgressBus = StageProgressBag()