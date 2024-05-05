plugins {
    id("java")
    kotlin("jvm")
}

group = "ru.kpfu.itis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://maven.aliyun.com/repository/gradle-plugin")
    maven("https://maven.aliyun.com/repository/spring-plugin")
    google()
    maven { url = uri("https://www.jitpack.io" ) }
}

dependencies {
    val junit = "5.8.2"
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junit")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junit")
    testImplementation("org.junit.platform:junit-platform-launcher:1.8.2")
    implementation("org.seleniumhq.selenium:selenium-java:4.18.1")
    implementation("io.github.bonigarcia:webdrivermanager:5.8.0")

    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
    implementation("com.sun.xml.bind:jaxb-impl:4.0.0")

    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    testCompileOnly("org.projectlombok:lombok:1.18.32")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.32")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}