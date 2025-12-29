package com.example.pdmtema6ejercicio2.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    @SerialName("id")
    val id: Int = 0,
    @SerialName("nombre")
    val nombre: String,
    @SerialName("apellido")
    val apellido: String,
    @SerialName("saldo")
    val saldo: Double,
    @SerialName("idPedidos")
    val idPedidos: List<Int>,
)