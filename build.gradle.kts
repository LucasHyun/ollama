plugins {
    kotlin("jvm") version "2.0.10"
}

group = "edu.trincoll"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-core:2.3.4")
    implementation("io.ktor:ktor-client-cio:2.3.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("ch.qos.logback:logback-classic:1.2.11")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}