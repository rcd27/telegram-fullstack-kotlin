plugins {
    kotlin("multiplatform") version "2.0.0" apply false
    id("org.jetbrains.compose") version "1.9.0-alpha03" apply false
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0" apply false
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
