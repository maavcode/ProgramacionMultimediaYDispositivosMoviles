package com.example.pdmtema6ejercicio1.conexion

import com.example.pdmtema6ejercicio1.modelo.Respuesta
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import kotlin.getValue

private const val BASE_URL = "https://swapi.dev/api/"

private val json = Json { ignoreUnknownKeys = true }

private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ServicioAPI {
    @GET("people")
    suspend fun obtenerPersonaje(): Respuesta // Creada automaticamente con @GET
}

object Api {
    val servicioRetrofit: ServicioAPI by lazy {
        retrofit.create(ServicioAPI::class.java)
    }
}