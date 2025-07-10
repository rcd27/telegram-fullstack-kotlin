// import dev.inmo.tgbotapi.bot.TelegramBot
// import dev.inmo.tgbotapi.bot.createTelegramBot
// import dev.inmo.tgbotapi.extensions.behaviour_builder.behaviourWithLongPolling
// import dev.inmo.tgbotapi.extensions.behaviour_builder.handlers.CommandHandlerEnvironment
// import dev.inmo.tgbotapi.extensions.behaviour_builder.handlers.command
// import dev.inmo.tgbotapi.types.ChatId
// import dev.inmo.tgbotapi.types.message.text.TextMessage
// import dev.inmo.tgbotapi.requests.send.SendMessage
// import domain.model.User
// import domain.model.UserId
// import domain.service.DefaultGreetingService
// import application.usecase.GreetingUseCase

// suspend fun main() {
//     val token = System.getenv("TELEGRAM_BOT_TOKEN") ?: error("TELEGRAM_BOT_TOKEN not set")
//     val bot = createTelegramBot(token)
//     val greetingUseCase = GreetingUseCase(DefaultGreetingService())
//
//     bot.behaviourWithLongPolling {
//         command("start") { msg ->
//             handleStartCommand(bot, msg, greetingUseCase)
//         }
//     }
// }

// suspend fun CommandHandlerEnvironment.handleStartCommand(
//     bot: TelegramBot,
//     msg: TextMessage,
//     greetingUseCase: GreetingUseCase
// ) {
//     val user = User(
//         id = UserId(msg.from.id.chatId),
//         name = msg.from.username?.username ?: msg.from.firstName
//     )
//     val result = greetingUseCase.invoke(user)
//     val text = result.fold(
//         ifLeft = { "Ошибка: имя пользователя не указано" },
//         ifRight = { it }
//     )
//     bot.execute(SendMessage(ChatId(msg.chat.id), text))
// } 