package com.example.simulacroconversaciones.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Usuario (
    @SerialName("id")
    val id: String = "0",
    @SerialName("nombre")
    val nombre: String = "",
    @SerialName("telefono")
    val telefono: String = "",
    @SerialName("mensajes")
    val mensajes: List<Mensaje>
)