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
