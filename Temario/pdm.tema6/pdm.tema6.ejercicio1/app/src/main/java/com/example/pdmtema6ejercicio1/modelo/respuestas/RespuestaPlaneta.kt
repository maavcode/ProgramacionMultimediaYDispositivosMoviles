package com.example.pdmtema6ejercicio1.modelo.respuestas

import com.example.pdmtema6ejercicio1.modelo.Planeta
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RespuestaPlaneta (
    @SerialName(value = "results")
    val resultados: List<Planeta>
)