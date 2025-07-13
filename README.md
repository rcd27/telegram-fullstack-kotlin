# telegram-fullstack-kotlin

**Сейчас:**
- Базовая структура fullstack-проекта на Kotlin Multiplatform (бот, web, common).
- Собирается, но бот-заготовка закомментирована (ожидает доработки архитектуры и зависимостей).
- Вся бизнес-логика и модели — в общем модуле (DDD, Arrow, Railway Oriented Programming).

**Дальше:**
- Реализовать рабочий backend-бот на tgbotapi (JVM).
- Подключить полноценный WebView-интерфейс (Compose Web + Telegram Web Apps API).
- Покрыть критические сценарии e2e-тестами.

## Архитектура
- **Kotlin Multiplatform**: backend (JVM), frontend (Compose Web), общий модуль (commonMain)
- **Backend**: tgbotapi, DDD, Railway Oriented Programming, Arrow
- **Frontend**: Compose Multiplatform Web, интеграция с Telegram Web Apps JS API
- **Тесты**: unit, UI (Playwright/Selenium), e2e

## Структура
```
backend/
  bot/         # Бот (JVM, tgbotapi)
  common/      # Общие модели, бизнес-логика (KMP)
frontend/
  web/         # WebView-интерфейс (Compose Web)
```

## Глубокий ресёрч: современные практики Telegram-бота на Kotlin/Compose/Web (WASM)

### 1. Бэкенд: Telegram-бот на Kotlin
- **kotlin-telegram-bot** ([github.com/kotlin-telegram-bot/kotlin-telegram-bot](https://github.com/kotlin-telegram-bot/kotlin-telegram-bot)) — самая популярная библиотека для работы с Telegram Bot API на Kotlin. Поддержка всех современных методов, интеграция с Ktor, webhook/long polling.
- **ktgram/webhook** ([github.com/ktgram/webhook](https://github.com/ktgram/webhook)) — стартер на Ktor для быстрого запуска бота с webhook, модульная архитектура.
- **simbot-component-telegram** ([github.com/simple-robot/simbot-component-telegram](https://github.com/simple-robot/simbot-component-telegram)) — мультиплатформенная библиотека (JVM/JS/Native), построена на корутинах, поддерживает расширенную интеграцию и асинхронность.

**Архитектурные рекомендации:**
- Использовать Ktor или Spring Boot для webhook.
- DDD, разделение на слои (domain, application, infrastructure, api).
- Ошибки — через sealed class/Result/Either (Arrow).
- Конфиг — только через env/config-файлы.
- e2e-тесты — must have.

**Пример минимального бота:**
```kotlin
fun main() {
    val bot = bot {
        token = "YOUR_BOT_TOKEN"
        dispatch {
            command("start") {
                bot.sendMessage(chatId = message.chat.id, text = "Привет!")
            }
        }
    }
    bot.startPolling()
}
```

---

### 2. Фронтенд: Telegram Mini Apps на Kotlin Compose/Web (WASM)
- **tg-mini-app** ([github.com/kirillNay/tg-mini-app](https://github.com/kirillNay/tg-mini-app)) — библиотека для создания Telegram Mini Apps на Kotlin Multiplatform + Compose Multiplatform (WASM/JS). Позволяет использовать Telegram WebApp API в idiomatic Kotlin-стиле.
- **kelegram** ([github.com/jeovazero/kelegram](https://github.com/jeovazero/kelegram)) — демо-проект: KMP, Compose Web, GraalVM, интеграция с Telegram.
- **Compose Multiplatform Web** ([github.com/JetBrains/compose-multiplatform](https://github.com/JetBrains/compose-multiplatform)) — официальный способ писать UI на Kotlin для Web (WASM/JS).

**Как это работает:**
- Фронтенд (Mini App) — SPA на Kotlin/Compose, запускается внутри Telegram через WebApp API.
- Для доступа к Telegram WebApp API нужно подключить скрипт:
  ```html
  <script src="https://telegram.org/js/telegram-web-app.js"></script>
  ```
- В Kotlin используешь tg-mini-app:
  ```kotlin
  fun main() {
      telegramWebApp { style ->
          // Compose UI
      }
  }
  ```
- Все взаимодействия с Telegram (темы, viewport, события) доступны через webApp API.

---

### 3. Использование современного Telegram API
- **Telegram Bot API** — для ботов: https://core.telegram.org/bots/api
- **Telegram WebApp API** — для мини-приложений: https://core.telegram.org/bots/webapps
- **TDLib/TDLight** — для клиентов (userbot, не для обычных ботов)

**Рекомендация:**
- Для ботов — использовать Bot API через kotlin-telegram-bot.
- Для мини-приложений — tg-mini-app + Compose Multiplatform.

---

### 4. Примеры и шаблоны
- [ktgram/webhook](https://github.com/ktgram/webhook) — стартер для бэкенда.
- [tg-mini-app](https://github.com/kirillNay/tg-mini-app) — стартер для фронта.
- [kelegram](https://github.com/jeovazero/kelegram) — пример fullstack на KMP.

---

### 5. Рекомендованный стек
- **Бэкенд:** Kotlin, Ktor, kotlin-telegram-bot, Arrow, DDD-структура, e2e-тесты.
- **Фронтенд:** Kotlin Multiplatform, Compose Web (WASM/JS), tg-mini-app, Telegram WebApp API.

---

### 6. Полезные ссылки
- [kotlin-telegram-bot](https://github.com/kotlin-telegram-bot/kotlin-telegram-bot)
- [ktgram/webhook](https://github.com/ktgram/webhook)
- [tg-mini-app](https://github.com/kirillNay/tg-mini-app)
- [Compose Multiplatform Web](https://github.com/JetBrains/compose-multiplatform)
- [Официальная документация Telegram Bot API](https://core.telegram.org/bots/api)
- [Официальная документация Telegram WebApp API](https://core.telegram.org/bots/webapps)

---

## Запуск

### Backend (бот)
```
cd backend/bot
./gradlew run
```

### Frontend (WebView)
```
cd frontend/web
./gradlew jsBrowserRun
```

## Тесты

### Unit-тесты
```
./gradlew test
```

### UI/e2e-тесты
(см. инструкции в соответствующих модулях)

---

- DDD, функциональный стиль, Railway Oriented Programming
- Ошибки — только через sealed class/Result/Either
- e2e — must have, покрытие >80%
- Чистый, идиоматичный Kotlin
- Вся инфраструктура — через порты/интерфейсы
- Линтинг, тесты, покрытие — строго обязательно
