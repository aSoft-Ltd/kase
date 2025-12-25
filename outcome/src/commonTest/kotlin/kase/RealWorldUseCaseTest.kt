package kase

import kase.outcome.Outcome
import kase.outcome.Success

class RealWorldUseCaseTest {

    class UserService {
        sealed interface CreateUserError {
            data class UserWithNameExists(val name: String) : CreateUserError
            data class InvalidUsername(val name: String) : CreateUserError
            data class Unauthorized(val name: String) : CreateUserError
            data class UnknownError(val cause: Throwable) : CreateUserError
        }

        fun create(username: String): Outcome<CreateUserError, String> = Success(username)
    }
}