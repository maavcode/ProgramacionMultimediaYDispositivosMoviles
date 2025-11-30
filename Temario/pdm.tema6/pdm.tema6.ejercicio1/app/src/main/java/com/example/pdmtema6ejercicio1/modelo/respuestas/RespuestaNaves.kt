package com.example.pdmtema6ejercicio1.modelo.respuestas

import com.example.pdmtema6ejercicio1.modelo.Nave
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RespuestaNaves(
    @SerialName("results")
    val resultados: List<Nave>
)