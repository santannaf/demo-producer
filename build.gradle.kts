plugins {
	java
	application
	kotlin("jvm") version "2.0.10"
	kotlin("plugin.spring") version "2.0.10"
	kotlin("plugin.jpa") version "2.0.10"
	kotlin("plugin.serialization") version "2.0.10"
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.graalvm.buildtools.native") version "0.10.4"
	id("com.github.davidmc24.gradle.plugin.avro") version "1.9.1"
}

group = "com.santannaf.demo.kafka.producer"
version = "0.0.1"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
	mavenLocal()
}

dependencies {
	implementation("com.tanna.spring:kafka:0.0.3") {
		implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
		implementation("com.github.avro-kotlin.avro4k:avro4k-core:1.10.1")
		implementation("org.apache.avro:avro:1.12.0")
	}

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
