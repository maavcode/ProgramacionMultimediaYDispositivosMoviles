package com.example.simulacroconversaciones.datos.repositorios

import com.example.simulacroconversaciones.conexion.SimulacroServicioAPI

interface SimulacroRepositorio {
    /* EJEMPLO
    suspend fun obtenerProductos(): List<Producto>
    suspend fun insertarProducto(id: String, producto: Producto): Producto
    suspend fun actualizarProducto(id: String, producto: Producto): Producto
     */

}

class ConexionSimulacroRepositorio(
    private val simulacroServicioAPI: SimulacroServicioAPI
): SimulacroRepositorio {
    /* EJEMPLO
    override suspend fun obtenerProductos(): List<Producto> = tiendaServicioAPI.obtenerProductos()
    override suspend fun insertarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.insertarProducto(id, producto)
    override suspend fun actualizarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.actualizarProducto(id, producto)
     */

}