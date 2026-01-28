package com.example.plantillanavigationdrawer.datos.repositorios

import com.example.plantillanavigationdrawer.conexion.PlantillaServicioApi
import com.example.plantillanavigationdrawer.modelo.Usuario

interface PlantillaRepositorio {
    /* EJEMPLO
suspend fun obtenerProductos(): List<Producto>
suspend fun insertarProducto(id: String, producto: Producto): Producto
suspend fun actualizarProducto(id: String, producto: Producto): Producto
 */
    suspend fun obtenerUsuarios(): List<Usuario>
    suspend fun actualizarUsuario(id: String, usuario: Usuario): Usuario
    suspend fun insertarUsuario(usuario: Usuario): Usuario
    suspend fun eliminarUsuario(id: String): Usuario
}

class ConexionPlantillaRepositorio(
    private val plantillaServicioApi: PlantillaServicioApi
): PlantillaRepositorio{
    /* EJEMPLO
   override suspend fun obtenerProductos(): List<Producto> = tiendaServicioAPI.obtenerProductos()
   override suspend fun insertarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.insertarProducto(id, producto)
   override suspend fun actualizarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.actualizarProducto(id, producto)
    */
    override suspend fun obtenerUsuarios(): List<Usuario> = plantillaServicioApi.obtenerUsuarios()
    override suspend fun actualizarUsuario(id: String, usuario: Usuario): Usuario = plantillaServicioApi.actualizarUsuario(id,usuario)
    override suspend fun insertarUsuario(usuario: Usuario): Usuario = plantillaServicioApi.insertarUsuario(usuario)
    override suspend fun eliminarUsuario(id: String): Usuario =plantillaServicioApi.eliminarUsuario(id)
}