package kase.either

import kotlinx.serialization.Serializable

/**
 * A monad to model success and failure as an outcome
 */
@Serializable
sealed interface Either<out F, out S> {
    val value: Any?
    fun <R> map(transform: (S) -> R): Either<F, R>

    fun <R> mapError(transform: (F) -> R): Either<R, S>

    fun <T, R> flatMap(transform: (S) -> Either<T, R>): Either<T, R>

    fun <R> flatMapError(transform: (F) -> Either<R, @UnsafeVariance S>): Either<R, S>

    fun <C> reduce(
        failure: (F) -> C,
        success: (S) -> C
    ): C

    fun swap(): Either<S, F>

    fun getOrNull(): S?

    fun get(): S

    fun error(): F

    fun errorOrNull(): F?
}