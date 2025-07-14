plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":backend:common"))
    implementation("dev.inmo:tgbotapi:26.1.0")
    implementation("io.arrow-kt:arrow-core:2.0.0")
    implementation("io.ktor:ktor-server-netty:2.3.8")
    implementation("io.ktor:ktor-server-core:2.3.8")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}
