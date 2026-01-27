package com.example.plantillanavigationdrawer.datos

import com.example.plantillanavigationdrawer.conexion.PlantillaServicioApi
import com.example.plantillanavigationdrawer.datos.repositorios.ConexionPlantillaRepositorio
import com.example.plantillanavigationdrawer.datos.repositorios.PlantillaRepositorio
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface IContenedorApp {
    // Repositorios
    /* EJEMPLO
    val usuarioRepositorio: UsuarioRepositorio
     */
    val plantillaRepositorio: PlantillaRepositorio

}

class ContenedorApp: IContenedorApp {
    private val baseUrl = "http://10.0.2.2:3000/"
    private val json = Json { ignoreUnknownKeys = true }
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()
    private val servicioRetrofit: PlantillaServicioApi by lazy {
        retrofit.create(PlantillaServicioApi::class.java)
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
    override val plantillaRepositorio: PlantillaRepositorio by lazy {
        ConexionPlantillaRepositorio(servicioRetrofit)
    }

}