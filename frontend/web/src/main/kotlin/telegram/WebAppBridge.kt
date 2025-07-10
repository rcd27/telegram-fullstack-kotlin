package telegram

import org.w3c.dom.Window
import kotlin.js.Promise
import kotlin.js.json
import kotlinx.browser.window

external interface TelegramUser {
    val id: Int
    val first_name: String
    val last_name: String?
    val username: String?
}

external interface TelegramWebApp {
    val initDataUnsafe: dynamic
    val initData: String
    val version: String
    val platform: String
    val colorScheme: String
    val themeParams: dynamic
    val isExpanded: Boolean
    val viewportHeight: Int
    val viewportStableHeight: Int
    val MainButton: dynamic
    val BackButton: dynamic
    val SettingsButton: dynamic
    val HapticFeedback: dynamic
    val CloudStorage: dynamic
    val Popup: dynamic
    val QRScanner: dynamic
    val ready: () -> Unit
    val close: () -> Unit
    val expand: () -> Unit
    val sendData: (String) -> Unit
    val onEvent: (String, (dynamic) -> Unit) -> Unit
    val offEvent: (String, (dynamic) -> Unit) -> Unit
    val showAlert: (String, ((Boolean) -> Unit)?) -> Unit
    val showConfirm: (String, (Boolean) -> Unit) -> Unit
    val showPopup: (dynamic, (String) -> Unit) -> Unit
    val showScanQrPopup: ((String) -> Unit, dynamic) -> Unit
    val readTextFromClipboard: ((String) -> Unit) -> Unit
}

@JsName("Telegram")
external val Telegram: dynamic

object TelegramWebApp {
    private val webApp: TelegramWebApp? = Telegram?.WebApp as? TelegramWebApp

    fun currentUserName(): String? =
        webApp?.initDataUnsafe?.user?.let { user ->
            user.username as? String ?: user.first_name as? String
        }
} 