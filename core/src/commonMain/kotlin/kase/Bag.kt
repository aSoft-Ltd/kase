@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kase

import kase.internal.AbstractPossible
import kotlin.js.JsExport

class Bag<out T : Any>(override var value: @UnsafeVariance T? = null) : AbstractPossible<T>() {

    override fun valueOrThrow(exp: Throwable): T = when (val v = value) {
        null -> throw exp
        else -> v
    }

    override fun valueOrThrow(msg: String): T = valueOrThrow(RuntimeException(msg))

    override fun valueOrThrow(): T = valueOrThrow(RuntimeException("You called valueOrThrow on an empty bag"))

    override fun valueOrNull(): T? = value

    override fun exists(): Boolean = value != null

    override fun valueOr(default: @UnsafeVariance T): T = value ?: default

    fun put(value: @UnsafeVariance T?) {
        this.value = value
    }

    fun <R : Any> map(transform: (T) -> R): Bag<R> = try {
        Bag(transform(value!!))
    } catch (_: Exception) {
        Bag()
    }

    fun <R : Any> flatMap(transform: (T) -> Bag<R>): Bag<R> = try {
        transform(value!!)
    } catch (_: Exception) {
        Bag()
    }

    fun catch(resolver: () -> @UnsafeVariance T): Bag<T> = try {
        Bag(resolver())
    } catch (_: Exception) {
        Bag()
    }

    fun clean() {
        value = null
    }
}