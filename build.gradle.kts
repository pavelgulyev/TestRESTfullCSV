plugins {
	java
	id("org.springframework.boot") version "3.1.1"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.my"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
// https://mvnrepository.com/artifact/org.apache.commons/commons-csv
	implementation("org.apache.commons:commons-csv:1.9.0")
	implementation("com.opencsv:opencsv:5.6")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
