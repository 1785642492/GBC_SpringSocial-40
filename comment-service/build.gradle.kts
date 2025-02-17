dependencies {
    implementation(project(":shared"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation(enforcedPlatform("org.testcontainers:testcontainers-bom:1.16.2"))
    implementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:junit-jupiter") // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-webflux
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.1.5")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.2.1")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:4.0.3")
    // https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-circuitbreaker-resilience4j
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j:3.0.3")
    // https://mvnrepository.com/artifact/io.micrometer/micrometer-observation
    implementation("io.micrometer:micrometer-observation:1.11.3")
    // https://mvnrepository.com/artifact/io.micrometer/micrometer-tracing-bridge-brave
    implementation("io.micrometer:micrometer-tracing-bridge-brave:1.1.4")
    // https://mvnrepository.com/artifact/io.zipkin.reporter2/zipkin-reporter-brave
    implementation("io.zipkin.reporter2:zipkin-reporter-brave:2.16.4")
}
