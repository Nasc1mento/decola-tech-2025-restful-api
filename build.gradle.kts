plugins {
	java
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "me.dio"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.5")

	// https://mvnrepository.com/artifact/org.modelmapper/modelmapper
	implementation("org.modelmapper:modelmapper:3.2.2")

	// https://mvnrepository.com/artifact/org.modelmapper/modelmapper-module-record
	implementation("org.modelmapper:modelmapper-module-record:1.0.0")

	// https://mvnrepository.com/artifact/org.projectlombok/lombok
	compileOnly("org.projectlombok:lombok:1.18.36")
	annotationProcessor("org.projectlombok:lombok:1.18.36")

	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.jar {
	manifest {
		attributes["Main-Class"] = "me.dio.decola_tech_2025.Application"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
