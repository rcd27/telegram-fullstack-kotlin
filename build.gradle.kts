plugins {
    kotlin("multiplatform") version "2.0.0" apply false
    id("org.jetbrains.compose") version "1.9.0-alpha03" apply false
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
