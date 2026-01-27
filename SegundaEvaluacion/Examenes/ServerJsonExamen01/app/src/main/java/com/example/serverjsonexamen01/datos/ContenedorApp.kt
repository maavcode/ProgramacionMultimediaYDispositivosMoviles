package com.example.serverjsonexamen01.datos

import com.example.serverjsonexamen01.datos.repositorios.ExamenRepositorio
import com.example.serverjsonexamen01.conexion.ExamenServicioAPI
import com.example.serverjsonexamen01.datos.repositorios.ConexionExamenRepositorio
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface IContenedorApp {
    // Repositorios
    /* EJEMPLO
    val usuarioRepositorio: UsuarioRepositorio
     */
    val examenRepositorio: ExamenRepositorio

}

class ContenedorApp: IContenedorApp {
    private val baseUrl = "http://10.0.2.2:3000/"
    private val json = Json {
        ignoreUnknownKeys = true
        classDiscriminator = "tipo"
    }
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()
    private val servicioRetrofit: ExamenServicioAPI by lazy {
        retrofit.create(ExamenServicioAPI::class.java)
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
    override val examenRepositorio: ExamenRepositorio by lazy {
        ConexionExamenRepositorio(servicioRetrofit)
    }

}