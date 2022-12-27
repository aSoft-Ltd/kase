@file:JsExport

package kase

import kotlin.js.JsExport

sealed interface FormState<out D> : State<D>, CanPend, CanValidate, CanSubmit, CanSucceed<D>, CanFail<D>