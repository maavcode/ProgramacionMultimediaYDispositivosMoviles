package com.example.plantillanavigationdrawer.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Reserva(
    @SerialName("numPersonas")
    val numPersonas: String = "",
    @SerialName("fechaReserva")
    val fechaReserva: String = "",
    @SerialName("horaReserva")
    val horaReserva: String = ""
)