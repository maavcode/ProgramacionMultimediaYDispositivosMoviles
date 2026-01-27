package com.example.simulacroconversaciones.datos.repositorios

import com.example.simulacroconversaciones.conexion.SimulacroServicioAPI
import com.example.simulacroconversaciones.modelo.Usuario

interface SimulacroRepositorio {
    /* EJEMPLO
    suspend fun obtenerProductos(): List<Producto>
    suspend fun insertarProducto(id: String, producto: Producto): Producto
    suspend fun actualizarProducto(id: String, producto: Producto): Producto
     */
    suspend fun obtenerUsuarios(): List<Usuario>
    suspend fun actualizarUsuario(id: String, usuario: Usuario):Usuario
    suspend fun insertarUsuario(usuario: Usuario): Usuario
}

class ConexionSimulacroRepositorio(
    private val simulacroServicioAPI: SimulacroServicioAPI
): SimulacroRepositorio {
    /* EJEMPLO
    override suspend fun obtenerProductos(): List<Producto> = tiendaServicioAPI.obtenerProductos()
    override suspend fun insertarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.insertarProducto(id, producto)
    override suspend fun actualizarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.actualizarProducto(id, producto)
     */
    override suspend fun obtenerUsuarios(): List<Usuario> = simulacroServicioAPI.obtenerUsuarios()
    override suspend fun actualizarUsuario(id: String, usuario: Usuario): Usuario = simulacroServicioAPI.actualizarUsuario(id, usuario)
    override suspend fun insertarUsuario(usuario: Usuario): Usuario = simulacroServicioAPI.insertarUsuario(usuario)
}