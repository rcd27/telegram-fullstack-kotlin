package application.usecase

import application.result.GreetingError
import domain.model.User
import domain.model.UserId
import domain.service.DefaultGreetingService
import kotlin.test.Test
import kotlin.test.assertEquals

class GreetingUseCaseTest {
    private val useCase = GreetingUseCase(DefaultGreetingService())

    @Test
    fun `returns greeting for valid user`() {
        val user = User(UserId(1), "Анна")
        val result = useCase.invoke(user)
        assertEquals("Привет, Анна!", result.getOrNull())
    }

    @Test
    fun `returns error for empty name`() {
        val user = User(UserId(2), "")
        val result = useCase.invoke(user)
        assertEquals(GreetingError.EmptyName, result.swap().getOrNull())
    }
} 