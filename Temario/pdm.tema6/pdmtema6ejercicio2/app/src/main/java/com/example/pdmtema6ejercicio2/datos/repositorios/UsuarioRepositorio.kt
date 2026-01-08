package com.example.pdmtema6ejercicio2.datos.repositorios

import com.example.pdmtema6ejercicio2.conexion.TiendaServicioAPI
import com.example.pdmtema6ejercicio2.modelo.Usuario

interface UsuarioRepositorio {
    suspend fun obtenerUsuario(): Usuario
    suspend fun actualizarUsuario(id: Int, usuario: Usuario): Usuario

}

class ConexionUsuarioRepositorio(
    private val tiendaServicioAPI: TiendaServicioAPI
): UsuarioRepositorio {
    override suspend fun obtenerUsuario(): Usuario = tiendaServicioAPI.obtenerUsuario()
    override suspend fun actualizarUsuario(id: Int, usuario: Usuario): Usuario = tiendaServicioAPI.actualizarUsuario(usuario)
}
