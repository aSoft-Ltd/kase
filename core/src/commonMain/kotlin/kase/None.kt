@file:JsExport
package kase

import kotlin.js.JsExport

object None : Possible<Nothing> {
    override fun <R : Any> map(transform: (Nothing) -> R) = None

    override fun <R : Any> flatMap(transform: (Nothing) -> Possible<R>): Possible<R> {
        TODO("Not yet implemented")
    }

    override fun valueOrThrow(): Nothing {
        TODO("Not yet implemented")
    }

    override fun valueOrNull(): Nothing? {
        TODO("Not yet implemented")
    }
}