package kase.either

import kotlinx.serialization.Serializable

/**
 * Represents a failure outcome
 */
@Serializable
data class Failure<out F>(override val value: F) : Either<F, Nothing> {

    override fun <R> map(transform: (Nothing) -> R): Either<F, R> = this

    override fun <R> mapError(transform: (F) -> R): Either<R, Nothing> = Failure(transform(value))

    override fun <T, R> flatMap(transform: (Nothing) -> Either<T, R>): Either<T, R> = this as Either<T, R>

    override fun <R> flatMapError(transform: (F) -> Either<R, Nothing>): Either<R, Nothing> = transform(value)

    override fun <C> reduce(failure: (F) -> C, success: (Nothing) -> C): C = failure(this.value)

    override fun swap(): Either<Nothing, F> = Success(value)

    override fun getOrNull(): Nothing? = null

    override fun get(): Nothing = throw IllegalStateException("Cannot get value from a failure outcome")

    override fun error(): F = value

    override fun errorOrNull(): F? = value
}