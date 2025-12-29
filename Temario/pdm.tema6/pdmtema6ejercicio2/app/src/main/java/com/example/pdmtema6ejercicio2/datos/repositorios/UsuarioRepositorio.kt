package com.example.pdmtema6ejercicio2.datos.repositorios

import com.example.pdmtema6ejercicio2.conexion.TiendaServicioAPI
import com.example.pdmtema6ejercicio2.modelo.Usuario

interface UsuarioRepositorio {
    suspend fun obtenerUsuarios(): List<Usuario>
    suspend fun obtenerUsuario(id: Int): Usuario
    suspend fun instertarUsuario(usuario: Usuario): Usuario
    suspend fun actualizarUsuario(id: Int, usuario: Usuario): Usuario
    suspend fun eliminarUsuario(id: Int): Usuario
}

class ConexionUsuarioRepositorio(
    private val tiendaServicioAPI: TiendaServicioAPI
): UsuarioRepositorio{
    override suspend fun obtenerUsuarios(): List<Usuario> = tiendaServicioAPI.obtenerUsuarios()
    override suspend fun obtenerUsuario(id: Int): Usuario = tiendaServicioAPI.obtenerUsuario(id)
    override suspend fun instertarUsuario(usuario: Usuario): Usuario = tiendaServicioAPI.insertarUsuario(usuario)
    override suspend fun actualizarUsuario(id: Int, usuario: Usuario): Usuario = tiendaServicioAPI.actualizarUsuario(id,usuario)
    override suspend fun eliminarUsuario(id: Int): Usuario = tiendaServicioAPI.eliminarUsuario(id)
}