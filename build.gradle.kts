plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.10")
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testCompileOnly( "junit:junit:4.12")

    testImplementation( "org.jetbrains.kotlin:kotlin-test")
    testImplementation( "org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")
    
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.1.0")
}

tasks.test {
    useJUnitPlatform()
}

