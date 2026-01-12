package com.example.pdmtema6ejercicio2.conexion

import com.example.pdmtema6ejercicio2.modelo.Producto
import com.example.pdmtema6ejercicio2.modelo.Usuario
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface TiendaServicioAPI {
    // Metodos Usuario
    @GET("usuario")
    suspend fun obtenerUsuario()
    : Usuario
    /*
    @POST("usuarios")
    suspend fun insertarUsuario(
        @Body usuario: Usuario
    ): Usuario
    */
    @PUT("usuario")
    suspend fun actualizarUsuario(
        @Body usuario: Usuario
    ): Usuario
    /*
    @DELETE("usuarios/{id}")
    suspend fun eliminarUsuario(
        @Path("id") id: Int
    ): Usuario
     */
}
