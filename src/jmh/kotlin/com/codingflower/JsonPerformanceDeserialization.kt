package com.codingflower

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.gson.Gson
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.io.File
import java.util.concurrent.TimeUnit


open class JsonPerformanceDeserialization : BenchmarkProperties() {
    private val jackson = jacksonObjectMapper()
    private val gson = Gson()
    private val kotlinx = Json

    private lateinit var simpleText: String

    @Setup(Level.Trial)
    fun loadFile() {
        simpleText = File("/home/bratek/IdeaProjects/Kotlin_JMH/src/jmh/resources/small.json").readText()
    }

//    @Benchmark
//    fun jackson(bl: Blackhole) {
//        val simpleJson = jackson.readValue(simpleText, SimpleJson::class.java)
//        bl.consume(simpleJson)
//    }
//
    @Benchmark
    fun gson(bl: Blackhole) {
        val simpleJson = gson.fromJson(simpleText, SimpleJson::class.java)
        bl.consume(simpleJson)
    }

    @Benchmark
    fun kotlinx(bl: Blackhole) {
        val simpleJson = kotlinx.decodeFromString<SimpleJson>(simpleText)
        bl.consume(simpleJson)
    }

//    @Benchmark
//    fun kotlinxSerializer(bl: Blackhole) {
//        val simpleJson = kotlinx.decodeFromString(SimpleJson.serializer(), simpleText)
//        bl.consume(simpleJson)
//    }
}

