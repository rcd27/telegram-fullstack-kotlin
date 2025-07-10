package domain.model

@JvmInline
value class UserId(val value: Long)

data class User(
    val id: UserId,
    val name: String
) 