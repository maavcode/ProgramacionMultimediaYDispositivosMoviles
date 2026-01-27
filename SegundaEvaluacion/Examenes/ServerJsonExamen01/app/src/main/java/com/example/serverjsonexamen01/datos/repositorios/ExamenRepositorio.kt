package com.example.serverjsonexamen01.datos.repositorios

import com.example.serverjsonexamen01.conexion.ExamenServicioAPI
import com.example.serverjsonexamen01.modelo.Persona

interface ExamenRepositorio {
    /* EJEMPLO
    suspend fun obtenerProductos(): List<Producto>
    suspend fun insertarProducto(id: String, producto: Producto): Producto
    suspend fun actualizarProducto(id: String, producto: Producto): Producto
     */
    suspend fun obtenerPersonas(): List<Persona>
}

class ConexionExamenRepositorio(
    private val examenServicioAPI: ExamenServicioAPI
): ExamenRepositorio {
    /* EJEMPLO
    override suspend fun obtenerProductos(): List<Producto> = tiendaServicioAPI.obtenerProductos()
    override suspend fun insertarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.insertarProducto(id, producto)
    override suspend fun actualizarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.actualizarProducto(id, producto)
     */
    override suspend fun obtenerPersonas(): List<Persona> = examenServicioAPI.obtenerPersonas()
}