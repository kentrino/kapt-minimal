/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.kentrino

class App {
    val greeting: String
        get() {
            return "Hello world."
        }
}

@GenName
class Hello

fun main(args: Array<String>) {
    println(GeneratedHello().getName())
}
