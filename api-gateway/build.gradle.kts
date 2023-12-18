plugins {
    id("java")
}

group = "com.gbc"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.cloud:spring-cloud-starter-gateway:4.0.8")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:4.0.3")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server:3.1.5")
    implementation("org.springframework.boot:spring-boot-starter-security:3.1.5")
    // https://mvnrepository.com/artifact/io.micrometer/micrometer-observation
    implementation("io.micrometer:micrometer-observation:1.11.3")
    // https://mvnrepository.com/artifact/io.micrometer/micrometer-tracing-bridge-brave
    implementation("io.micrometer:micrometer-tracing-bridge-brave:1.1.4")
    // https://mvnrepository.com/artifact/io.zipkin.reporter2/zipkin-reporter-brave
    implementation("io.zipkin.reporter2:zipkin-reporter-brave:2.16.4")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
}

tasks.test {
    useJUnitPlatform()
}