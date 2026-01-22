package com.example.simulacroconversaciones.datos

import com.example.simulacroconversaciones.conexion.SimulacroServicioAPI
import com.example.simulacroconversaciones.datos.repositorios.ConexionSimulacroRepositorio
import com.example.simulacroconversaciones.datos.repositorios.SimulacroRepositorio
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface IContenedorApp {
    // Repositorios
    /* EJEMPLO
    val usuarioRepositorio: UsuarioRepositorio
     */
    val simulacroRepositorio: SimulacroRepositorio

}

class ContenedorApp: IContenedorApp {
    private val baseUrl = "http://10.0.2.2:3000/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()
    private val servicioRetrofit: SimulacroServicioAPI by lazy {
        retrofit.create(SimulacroServicioAPI::class.java)
    }
    // Declaracion de REPOSITORIOS
    /* EJEMPLO DECLARACION DE REPOSITORIOS
    override val usuarioRepositorio: UsuarioRepositorio by lazy {
        ConexionUsuarioRepositorio(servicioRetrofit)
    }
    override val productoRepositorio: ProductoRepositorio by lazy {
        ConexionProductoRepositorio(servicioRetrofit)
    }
     */
    override val simulacroRepositorio: SimulacroRepositorio by lazy {
        ConexionSimulacroRepositorio(servicioRetrofit)
    }

}