package com.example.simulacroconversaciones.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Mensaje (
    @SerialName("mensaje")
    val mensaje: String = "",
    @SerialName("enviado")
    val enviado: Boolean
)