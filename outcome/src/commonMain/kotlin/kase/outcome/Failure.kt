package kase.outcome

import kotlinx.serialization.Serializable

/**
 * Represents a failure outcome
 */
@Serializable
data class Failure<out F>(override val value: F) : Outcome<F, Nothing> {

    override fun <R> map(transform: (Nothing) -> R): Outcome<F, R> = this

    override fun <R> mapError(transform: (F) -> R): Outcome<R, Nothing> = Failure(transform(value))

    override fun <T, R> flatMap(transform: (Nothing) -> Outcome<T, R>): Outcome<T, R> = this as Outcome<T, R>

    override fun <R> flatMapError(transform: (F) -> Outcome<R, Nothing>): Outcome<R, Nothing> = transform(value)

    override fun <C> reduce(failure: (F) -> C, success: (Nothing) -> C): C = failure(this.value)

    override fun swap(): Outcome<Nothing, F> = Success(value)

    override fun getOrNull(): Nothing? = null

    override fun get(): Nothing = throw IllegalStateException("Cannot get value from a failure outcome")

    override fun error(): F = value

    override fun errorOrNull(): F? = value
}