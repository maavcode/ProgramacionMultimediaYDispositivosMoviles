package com.example.plantillanavigationdrawer.conexion

import com.example.plantillanavigationdrawer.modelo.Usuario
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PlantillaServicioApi {
    /* EJEMPLO CRUD COMPLETO
     @GET("productos")
     suspend fun obtenerProductos(
     ): List<Producto>

     @POST("productos")
     suspend fun insertarProducto(
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
     ): Producto
      */
    @GET("usuariosPlantillasMenu")
    suspend fun obtenerUsuarios(
    ): List<Usuario>
    // ACTUALIZAR
    @PUT("usuariosPlantillasMenu/{id}")
    suspend fun actualizarUsuario(
        @Path("id" )id : String,
        @Body usuario: Usuario
    ): Usuario
    // AÑADIR
    @POST("usuariosPlantillasMenu")
    suspend fun insertarUsuario(
        @Body usuario: Usuario
    ): Usuario
    @DELETE("usuariosPlantillasMenu/{id}")
    suspend fun eliminarUsuario(
        @Path("id" )id : String
    ): Usuario
}