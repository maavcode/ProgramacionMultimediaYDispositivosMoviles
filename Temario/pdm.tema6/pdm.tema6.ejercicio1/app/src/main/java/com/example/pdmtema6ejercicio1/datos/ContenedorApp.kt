package com.example.pdmtema6ejercicio1.datos

import com.example.pdmtema6ejercicio1.conexion.ServicioAPI
import com.example.pdmtema6ejercicio1.datos.repositorios.ConexionNavesRepositorio
import com.example.pdmtema6ejercicio1.datos.repositorios.ConexionPersonajesRepositorio
import com.example.pdmtema6ejercicio1.datos.repositorios.ConexionPlanetasRepositorio
import com.example.pdmtema6ejercicio1.datos.repositorios.NavesRepositorio
import com.example.pdmtema6ejercicio1.datos.repositorios.PersonajesRepositorio
import com.example.pdmtema6ejercicio1.datos.repositorios.PlanetasRepositorio
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import kotlin.getValue

interface ContenedorApp {
    val personajesRepositorio: PersonajesRepositorio
    val navesRepositorio: NavesRepositorio
    val planetasRepositorio: PlanetasRepositorio
}

class StarWarsContenedorApp : ContenedorApp {
    private val baseUrl = "https://swapi.dev/api/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()
    private val servicioRetrofit: ServicioAPI by lazy {
        retrofit.create(ServicioAPI::class.java)
    }
    override val personajesRepositorio: PersonajesRepositorio by lazy {
        ConexionPersonajesRepositorio(servicioRetrofit)
    }

    override val navesRepositorio: NavesRepositorio by lazy {
        ConexionNavesRepositorio(servicioRetrofit)
    }

    override val planetasRepositorio: PlanetasRepositorio by lazy {
        ConexionPlanetasRepositorio(servicioRetrofit)
    }
}