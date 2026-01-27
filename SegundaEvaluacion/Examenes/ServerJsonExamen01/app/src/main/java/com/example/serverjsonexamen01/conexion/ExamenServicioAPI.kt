package com.example.serverjsonexamen01.conexion

import com.example.serverjsonexamen01.modelo.Persona
import retrofit2.http.GET

interface ExamenServicioAPI {
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

    @GET("personasExamen01")
    suspend fun obtenerPersonas(
    ): List<Persona>
}