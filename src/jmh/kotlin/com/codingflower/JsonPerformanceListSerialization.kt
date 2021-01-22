//package com.codingflower
//
//import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
//import com.google.gson.Gson
//import kotlinx.serialization.encodeToString
//import kotlinx.serialization.json.Json
//import org.openjdk.jmh.annotations.*
//import org.openjdk.jmh.infra.Blackhole
//
//
//open class JsonPerformanceListSerialization: BenchmarkProperties() {
//    private val jackson = jacksonObjectMapper()
//    private val gson = Gson()
//    private val kotlinx = Json
//
//    private val simpleJsons: List<SimpleJson> = (1..1000).map { SimpleJson("www.codingflower$it.com") }.toList()
//
//    @Benchmark
//    fun jackson(bl: Blackhole) {
//        val text = jackson.writeValueAsString(simpleJsons)
//        bl.consume(text)
//    }
//
//    @Benchmark
//    fun gson(bl: Blackhole) {
//        val text = gson.toJson(simpleJsons)
//        bl.consume(text)
//    }
//
//    @Benchmark
//    fun kotlin(bl: Blackhole) {
//        val text = kotlinx.encodeToString(simpleJsons)
//        bl.consume(text)
//    }
//}