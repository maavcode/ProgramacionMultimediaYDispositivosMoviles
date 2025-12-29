package com.example.pdmtema6ejercicio2.datos

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import com.example.pdmtema6ejercicio2.conexion.TiendaServicioAPI
import com.example.pdmtema6ejercicio2.datos.repositorios.ConexionUsuarioRepositorio
import com.example.pdmtema6ejercicio2.datos.repositorios.UsuarioRepositorio
import com.example.pdmtema6ejercicio2.modelo.Usuario

interface ContenedorApp {
    // Repositorios
    val usuarioRepositorio: UsuarioRepositorio
    // EJEMPLO: val personajesRepositorio: PersonajesRepositorio
}

class TiendaContenedorApp: ContenedorApp{
    private val baseUrl = "http://10.0.2.2:3000/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()
    private val servicioRetrofit: TiendaServicioAPI by lazy {
        retrofit.create(TiendaServicioAPI::class.java)
    }
    // Declaracion de REPOSITORIOS
    override val usuarioRepositorio: UsuarioRepositorio by lazy {
        ConexionUsuarioRepositorio(servicioRetrofit)
    }
    /* EJEMPLO
    override val personajesRepositorio: PersonajesRepositorio by lazy {
        ConexionPersonajesRepositorio(servicioRetrofit)
    }
    */
}