import androidx.compose.runtime.*
import androidx.compose.web.dom.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.renderComposable
import telegram.TelegramWebApp

fun main() {
    renderComposable(rootElementId = "root") {
        var greeting by remember { mutableStateOf("Привет из Compose Web!") }
        var userName by remember { mutableStateOf<String?>(null) }

        LaunchedEffect(Unit) {
            userName = TelegramWebApp.currentUserName()
            if (userName != null) greeting = "Привет, $userName!"
        }

        H1 { Text(greeting) }
        Button(attrs = {
            onClick {
                greeting = "Хорошего дня, ${userName ?: "гость"}!"
            }
            style {
                padding(16.px)
                fontSize(18.px)
            }
        }) {
            Text("Пожелать хорошего дня")
        }
    }
} 