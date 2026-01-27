package com.example.ud6_ejemplo2.conexion

import com.example.ud6_ejemplo2.modelo.Respuesta
import retrofit2.http.GET

interface StarWarsServicioApi {
    @GET("people")
    suspend fun obtenerPersonajes(): Respuesta
}