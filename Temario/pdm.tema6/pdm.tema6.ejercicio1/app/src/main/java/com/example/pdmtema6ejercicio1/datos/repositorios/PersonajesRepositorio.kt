package com.example.pdmtema6ejercicio1.datos.repositorios

import com.example.pdmtema6ejercicio1.conexion.ServicioAPI
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaPersonaje

interface PersonajesRepositorio {
    suspend fun obtenerPersonajes(): RespuestaPersonaje
}

class ConexionPersonajesRepositorio(
    private val servicioAPI: ServicioAPI
) : PersonajesRepositorio {
    override suspend fun obtenerPersonajes(): RespuestaPersonaje = servicioAPI.obtenerPersonajes()
}