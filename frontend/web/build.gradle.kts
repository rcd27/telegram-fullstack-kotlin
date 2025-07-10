plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

kotlin {
    wasmJs {
        browser {
            // Можно добавить devServer, если нужно
        }
        binaries.executable()
    }
    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(project(":backend:common"))
                implementation(compose.runtime)
                implementation("io.arrow-kt:arrow-core:2.0.0")
            }
        }
        val wasmJsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
