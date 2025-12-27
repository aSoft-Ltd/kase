package kase.either

import kotlinx.serialization.Serializable

/**
 * Represents a success outcome
 */
@Serializable
data class Success<out S>(override val value: S) : Either<Nothing, S> {
    override fun <R> map(transform: (S) -> R): Either<Nothing, R> = Success(transform(value))
    override fun <R> mapError(transform: (Nothing) -> R): Either<R, S> = this
    override fun <T, R> flatMap(transform: (S) -> Either<T, R>): Either<T, R> = transform(value)

    override fun <R> flatMapError(transform: (Nothing) -> Either<R, @UnsafeVariance S>): Either<R, S> = this

    override fun <C> reduce(failure: (Nothing) -> C, success: (S) -> C): C = success(this.value)

    override fun swap(): Either<S, Nothing> = Failure(value)

    override fun getOrNull(): S = value

    override fun get(): S = value

    override fun error(): Nothing = throw IllegalStateException("Cannot get error from a success outcome")

    override fun errorOrNull(): Nothing? = null
}