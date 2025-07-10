plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":backend:common"))
    implementation("dev.inmo:tgbotapi:2.2.0")
    implementation("io.arrow-kt:arrow-core:1.2.1")
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(17)
}
