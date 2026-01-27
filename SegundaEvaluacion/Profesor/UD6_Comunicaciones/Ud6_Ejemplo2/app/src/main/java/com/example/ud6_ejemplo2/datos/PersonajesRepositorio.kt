package com.example.ud6_ejemplo2.datos

import com.example.ud6_ejemplo2.conexion.StarWarsServicioApi
import com.example.ud6_ejemplo2.modelo.Respuesta

interface PersonajesRepositorio {
    suspend fun obtenerPersonajes(): Respuesta
}

class ConexionPersonajesRepositorio(
    private val starWarsServicioApi: StarWarsServicioApi
) : PersonajesRepositorio {
    override suspend fun obtenerPersonajes(): Respuesta = starWarsServicioApi.obtenerPersonajes()
}