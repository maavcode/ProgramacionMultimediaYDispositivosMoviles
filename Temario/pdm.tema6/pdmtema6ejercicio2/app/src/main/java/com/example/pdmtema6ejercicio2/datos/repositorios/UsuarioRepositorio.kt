package com.example.pdmtema6ejercicio2.datos.repositorios

import com.example.pdmtema6ejercicio2.conexion.TiendaServicioAPI
import com.example.pdmtema6ejercicio2.modelo.Usuario

interface UsuarioRepositorio {
    suspend fun obtenerUsuarios(): List<Usuario>
    suspend fun obtenerUsuario(id: String): Usuario
    suspend fun actualizarUsuario(id: String, usuario: Usuario): Usuario

}

class ConexionUsuarioRepositorio(
    private val tiendaServicioAPI: TiendaServicioAPI
): UsuarioRepositorio {
    override suspend fun obtenerUsuarios(): List<Usuario> = tiendaServicioAPI.obtenerUsuarios()
    override suspend fun obtenerUsuario(id:String): Usuario = tiendaServicioAPI.obtenerUsuario(id)
    override suspend fun actualizarUsuario(id: String, usuario: Usuario): Usuario = tiendaServicioAPI.actualizarUsuario(id, usuario)
}
