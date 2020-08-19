import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.2.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("com.github.johnrengelman.shadow") version "4.0.4"
    kotlin("jvm") version "1.4.0"
    kotlin("plugin.spring") version "1.4.0"
}

group = "net.spleefx"
version = "1.0-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://dl.bintray.com/kotlin/kotlin-dev/") }
}

dependencies {
    implementation("org.jetbrains.kotlin", "kotlin-reflect", "1.4.0")
    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk8", "1.4.0-release-329")
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", "1.3.9")

    implementation("com.github.ben-manes.caffeine", "caffeine", "2.8.5")

    implementation("com.github.moltenjson", "lightweight-moltenjson", "2.5.3-SNAPSHOT") {
        exclude(group = "com.google.code.gson", module = "gson")
    }

    implementation("com.google.code.gson", "gson", "2.8.5")
    implementation("com.github.vladimir-bukhtoyarov", "bucket4j-core", "4.10.0")

    implementation("io.lettuce", "lettuce-core", "6.0.0.M1")

    implementation("org.springframework.boot", "spring-boot-starter-security")
    implementation("org.springframework.security", "spring-security-test")
    implementation("org.springframework.boot", "spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot", "spring-boot-starter-web")
    implementation("org.springframework.boot", "spring-boot-starter-actuator")
    implementation("org.springframework.boot", "spring-boot-starter")

    testImplementation("org.springframework.boot", "spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks {
    jar {
        archiveFileName.set("app")
    }
}