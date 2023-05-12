package kase.internal

import kase.Possible

abstract class AbstractPossible<out T> : Possible<T> {

    override fun getOrThrow(exp: Throwable): T = valueOrThrow(exp)

    override fun getOrThrow(msg: String): T = valueOrThrow(msg)

    override fun getOrThrow(): T = valueOrThrow()

    override fun getOr(default: @UnsafeVariance T): T = valueOr(default)

    override fun getOrNull(): T? = valueOrNull()
}