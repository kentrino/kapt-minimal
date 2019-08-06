group = "com.kentrino"
version = "0.0.1"

plugins {
    kotlin("jvm") version "1.3.41" apply false
}

repositories {
    jcenter()
}


subprojects {
    repositories {
        jcenter()
        maven("https://jitpack.io")
    }
}
