package com.example.pdmtema6ejercicio1.datos.repositorios

import com.example.pdmtema6ejercicio1.conexion.ServicioAPI
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaNave

interface NavesRepositorio {
    suspend fun obtenerNaves(): RespuestaNave
}

class ConexionNavesRepositorio(
    private val servicioAPI: ServicioAPI
) : NavesRepositorio {
    override suspend fun obtenerNaves(): RespuestaNave = servicioAPI.obtenerNaves()
}