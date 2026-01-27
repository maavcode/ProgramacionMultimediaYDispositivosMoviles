package com.example.simulacroconversaciones.conexion

import com.example.simulacroconversaciones.modelo.Usuario
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface SimulacroServicioAPI {
    /* EJEMPLO CRUD COMPLETO
    @GET("productos")
    suspend fun obtenerProductos(
    ): List<Producto>

    @POST("productos/{id}")
    suspend fun insertarProducto(
        @Path("id")id: String,
        @Body producto: Producto
    ): Producto

    @PUT("productos/{id}")
    suspend fun actualizarProducto(
        @Path("id")id : String,
        @Body producto: Producto
    ): Producto

    @DELETE("productos/{id}")
    suspend fun eliminarProducto(
        @Path("id") id: String,
        @Body producto: Producto
    ): Producto
     */
    @GET("usuariosConversaciones")
    suspend fun obtenerUsuarios(
    ): List<Usuario>
    @PUT("usuariosConversaciones/{id}")
    suspend fun actualizarUsuario(
        @Path("id") id: String,
        @Body usuario: Usuario
    ): Usuario
    @POST("usuariosConversaciones")
    suspend fun insertarUsuario(
        @Body usuario: Usuario
    ): Usuario

}