package com.example.pdmtema6ejercicio1.conexion

import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaNave
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaPersonaje
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaPlaneta
import retrofit2.http.GET
import kotlin.getValue

interface ServicioAPI {
    @GET("people")
    suspend fun obtenerPersonajes(): RespuestaPersonaje // Creada automaticamente con @GET
    @GET("starships")
    suspend fun obtenerNaves(): RespuestaNave
    @GET("planets")
    suspend fun obtenerPlanetas(): RespuestaPlaneta
}