package com.example.ud6_ejemplo3.conexion

import com.example.ud6_ejemplo3.modelo.Trabajador
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TrabajadoresServicioApi {
    @GET("trabajadores")
    suspend fun obtenerTrabajadores(): List<Trabajador>

    @POST("trabajadores")
    suspend fun insertarTrabajador(
        @Body trabajador: Trabajador
    ): Trabajador

    @PUT("trabajadores/{id}")
    suspend fun actualizarTrabajador(
        @Path("id") id: String,
        @Body trabajador: Trabajador
    ): Trabajador

    @DELETE("trabajadores/{id}")
    suspend fun eliminarTrabajador(
        @Path("id") id: String
    ): Trabajador
}