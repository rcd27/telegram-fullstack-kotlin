package domain.service

import domain.model.User

interface GreetingService {
    fun greet(user: User): String
}

class DefaultGreetingService : GreetingService {
    override fun greet(user: User): String = "Привет, ${user.name}!"
} 