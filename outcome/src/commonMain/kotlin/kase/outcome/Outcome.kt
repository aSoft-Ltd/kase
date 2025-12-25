package kase.outcome

import kotlinx.serialization.Serializable

/**
 * A monad to model success and failure as an outcome
 */
@Serializable
sealed interface Outcome<out F, out S> {
    val value: Any?
    fun <R> map(transform: (S) -> R): Outcome<F, R>

    fun <R> mapError(transform: (F) -> R): Outcome<R, S>

    fun <T, R> flatMap(transform: (S) -> Outcome<T, R>): Outcome<T, R>

    fun <R> flatMapError(transform: (F) -> Outcome<R, @UnsafeVariance S>): Outcome<R, S>

    fun <C> reduce(
        failure: (F) -> C,
        success: (S) -> C
    ): C

    fun swap(): Outcome<S, F>

    fun getOrNull(): S?

    fun get(): S

    fun error(): F

    fun errorOrNull(): F?
}