plugins {
    kotlin("jvm")
    kotlin("kapt")
    application
}

repositories {
    jcenter()
}

kapt {
    generateStubs = true
    // TODO
    // https://github.com/JamiesWhiteShirt/kapt-example/blob/master/kapt-example-app/build.gradle.kts
    // correctErrorTypes = true
}

sourceSets {
    main {
        java {
            // TODO: can I change the place?
            this.srcDir("${buildDir.absolutePath}/tmp/kapt/main/kotlinGenerated/")
        }
    }
}

dependencies {
    kapt(project(":generator"))
    compileOnly(project(":generator"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

application {
    mainClassName = "com.kentrino.AppKt"
}
