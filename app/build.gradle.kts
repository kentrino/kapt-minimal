import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
    kotlin("jvm")
    kotlin("kapt")
    application
}

repositories {
    jcenter()
}

kapt {
    // TODO
    // https://medium.com/@MiBLT/hello-world-of-annotation-processing-in-kotlin-3ec0290c1fdd
    // generateStubs = true
    // https://github.com/JamiesWhiteShirt/kapt-example/blob/master/kapt-example-app/build.gradle.kts
    // correctErrorTypes = true
}

sourceSets {
    main {
        withConvention(KotlinSourceSet::class) {
            kotlin.srcDir("${buildDir.absolutePath}/build/generated/source/kaptKotlin/main")
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
