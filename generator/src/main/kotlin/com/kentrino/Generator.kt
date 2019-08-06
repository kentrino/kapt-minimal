package com.kentrino

import com.google.auto.service.AutoService
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.TypeSpec
import java.io.File
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.TypeElement

@AutoService(Processor::class)
class Generator : AbstractProcessor() {
    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        // TODO:
        // println("getSupportedAnnotationTypes")
        return mutableSetOf(GenName::class.java.name)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        // TODO:
        return SourceVersion.latest()
    }

    override fun process(p0: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment): Boolean {
        roundEnv.getElementsAnnotatedWith(GenName::class.java)
                .forEach {
                    val className = it.simpleName.toString()
                    val packageName = processingEnv.elementUtils.getPackageOf(it).toString()
                    generateClass(className, packageName)
                }
        // TODO
        return true
    }

    private fun generateClass(className: String, packageName: String) {
        val fileName = "Generated$className"
        val file = FileSpec.builder(packageName, fileName)
                        .addType(
                                TypeSpec.classBuilder(fileName)
                                        .addFunction(
                                                FunSpec.builder("getName")
                                                        .addStatement("return \"World\"")
                                                        .build())
                        .build())
                .build()

        val kaptKotlinGeneratedDir = processingEnv.options[kaptKotlinGeneratedOptionName]
        file.writeTo(File(kaptKotlinGeneratedDir, "$fileName.kt"))
    }

    companion object {
        // TODO
        const val kaptKotlinGeneratedOptionName = "kapt.kotlin.generated"
    }
}
