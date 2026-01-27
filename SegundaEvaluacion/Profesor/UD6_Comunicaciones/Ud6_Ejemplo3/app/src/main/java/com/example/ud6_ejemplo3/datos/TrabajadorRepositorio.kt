package com.example.ud6_ejemplo3.datos

import com.example.ud6_ejemplo3.conexion.TrabajadoresServicioApi
import com.example.ud6_ejemplo3.modelo.Trabajador

interface TrabajadorRepositorio {
    suspend fun obtenerTrabajadores(): List<Trabajador>
    suspend fun insertarTrabajador(trabajador: Trabajador): Trabajador
    suspend fun actualizarTrabajador(id: String, trabajador: Trabajador): Trabajador
    suspend fun eliminarTrabajador(id: String): Trabajador
}

class ConexionTrabajadorRepositorio(
    private val trabajadoresServicioApi: TrabajadoresServicioApi
) : TrabajadorRepositorio {
    override suspend fun obtenerTrabajadores(): List<Trabajador> = trabajadoresServicioApi.obtenerTrabajadores()
    override suspend fun insertarTrabajador(trabajador: Trabajador):Trabajador = trabajadoresServicioApi.insertarTrabajador(trabajador)
    override suspend fun actualizarTrabajador(id: String, trabajador: Trabajador): Trabajador  = trabajadoresServicioApi.actualizarTrabajador(id, trabajador)
    override suspend fun eliminarTrabajador(id: String): Trabajador = trabajadoresServicioApi.eliminarTrabajador(id)
}