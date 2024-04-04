plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "hello"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation ("org.springframework.boot:spring-boot-starter-jdbc") // 자바는 DB와 붙으려면 기본적으로 jdbc 드라이버가 꼭 필요
	runtimeOnly ("com.h2database:h2") // DB랑 붙을때 데이터베이스가 제공하는 클라이언트 필요. 여기에서는 h2 데이터베이스 클라이언트 필요
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
