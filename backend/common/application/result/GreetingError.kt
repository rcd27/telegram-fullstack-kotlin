package application.result

sealed class GreetingError {
    data object EmptyName : GreetingError()
} 