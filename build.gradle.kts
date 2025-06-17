import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
	java
	application
	kotlin("jvm") version "2.0.21"
	kotlin("plugin.spring") version "2.0.21"
	kotlin("plugin.jpa") version "2.0.21"
	kotlin("plugin.serialization") version "2.0.21"
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.graalvm.buildtools.native") version "0.10.6"
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

dependencyManagement {
    imports {
        mavenBom("io.opentelemetry.instrumentation:opentelemetry-instrumentation-bom:2.16.0")
        mavenBom("io.opentelemetry:opentelemetry-bom:1.51.0")
        mavenBom("io.micrometer:micrometer-tracing-bom:1.5.0")
    }
}

dependencies {
	implementation("com.tanna.spring:kafka:0.0.3") {
		implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")
		implementation("com.github.avro-kotlin.avro4k:avro4k-core:1.10.1")
		implementation("org.apache.avro:avro:1.12.0")
	}

    // Metrics
    implementation("io.micrometer:micrometer-registry-otlp")
    implementation("io.micrometer:micrometer-tracing-bridge-otel")
    implementation("io.micrometer:micrometer-tracing")

    // Traces
    implementation("io.opentelemetry:opentelemetry-exporter-otlp")

    // Traces and some metrics
    implementation("io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter")
    implementation("io.opentelemetry:opentelemetry-extension-kotlin")

	implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
        jvmTarget.set(JvmTarget.JVM_21)
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
