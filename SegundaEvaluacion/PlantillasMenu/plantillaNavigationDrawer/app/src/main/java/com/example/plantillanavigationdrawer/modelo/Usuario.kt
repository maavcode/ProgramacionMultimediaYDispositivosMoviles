package com.example.plantillanavigationdrawer.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    @SerialName("id")
    val id: String = "0",
    @SerialName("nombre")
    val nombre: String = "",
    @SerialName("apellido1")
    val apellido1: String = "",
    @SerialName("apellido2")
    val apellido2: String = "",
    @SerialName("reservas")
    val reservas: List<Reserva>
)