package domain.service

import domain.model.User
import domain.model.UserId
import kotlin.test.Test
import kotlin.test.assertEquals

class GreetingServiceTest {
    @Test
    fun `greet returns correct greeting`() {
        val service = DefaultGreetingService()
        val user = User(UserId(1), "Иван")
        val greeting = service.greet(user)
        assertEquals("Привет, Иван!", greeting)
    }
} 