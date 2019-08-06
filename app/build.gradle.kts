plugins {
    kotlin("jvm")
    kotlin("kapt")
    application
}

repositories {
    jcenter()
}

dependencies {
    kapt(project(":generator"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClassName = "com.kentrino.AppKt"
}
