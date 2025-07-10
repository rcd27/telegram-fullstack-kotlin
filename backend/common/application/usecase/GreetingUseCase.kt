package application.usecase

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import domain.model.User
import domain.service.GreetingService
import application.result.GreetingError

class GreetingUseCase(
    private val greetingService: GreetingService
) {
    fun invoke(user: User): Either<GreetingError, String> =
        if (user.name.isBlank()) GreetingError.EmptyName.left()
        else greetingService.greet(user).right()
} 