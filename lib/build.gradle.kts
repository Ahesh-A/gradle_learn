plugins {
    id("java")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(libs.guava)
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.register("task3"){
    println("REGISTER TASK3: This is executed during the configuration phase")
}

tasks.named("task3"){
    println("NAMED TASK3: This is executed during the configuration phase")
    doFirst {
        println("NAMED TASK3 - doFirst: This is executed during the execution phase")
    }
    doLast {
        println("NAMED TASK3 - doLast: This is executed during the execution phase")
    }
}