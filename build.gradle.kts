plugins {
    kotlin("jvm") version "1.9.23"
    antlr
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.antlr:antlr4:4.13.1")
}


kotlin {
    jvmToolchain(19)
}