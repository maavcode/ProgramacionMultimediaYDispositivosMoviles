package com.example.pdmtema6ejercicio1.datos.repositorios

import com.example.pdmtema6ejercicio1.conexion.ServicioAPI
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaPlaneta


interface PlanetasRepositorio {
    suspend fun obtenerPlanetas(): RespuestaPlaneta
}

class ConexionPlanetasRepositorio(
    private val servicioAPI: ServicioAPI
) : PlanetasRepositorio {
    override suspend fun obtenerPlanetas(): RespuestaPlaneta = servicioAPI.obtenerPlanetas()
}