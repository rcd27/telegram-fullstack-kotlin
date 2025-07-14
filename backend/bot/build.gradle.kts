plugins {
    kotlin("jvm") version "2.1.20"
}

dependencies {
    implementation(project(":backend:common"))
    implementation("dev.inmo:tgbotapi:26.1.0")
    implementation("io.arrow-kt:arrow-core:2.0.0")
    implementation("io.ktor:ktor-server-netty:3.1.3")
    implementation("io.ktor:ktor-server-core:3.1.3")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}
