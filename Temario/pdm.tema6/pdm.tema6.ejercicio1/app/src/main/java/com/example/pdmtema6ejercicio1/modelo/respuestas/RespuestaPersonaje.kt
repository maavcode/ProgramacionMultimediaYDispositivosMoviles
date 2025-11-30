package com.example.pdmtema6ejercicio1.modelo.respuestas

import com.example.pdmtema6ejercicio1.modelo.Personaje
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RespuestaPersonaje(
    @SerialName(value = "results")
    val resultados: List<Personaje>
)