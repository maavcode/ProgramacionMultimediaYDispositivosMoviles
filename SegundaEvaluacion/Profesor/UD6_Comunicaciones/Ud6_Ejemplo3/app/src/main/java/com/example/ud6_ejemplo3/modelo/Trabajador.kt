package com.example.ud6_ejemplo3.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Trabajador(
    @SerialName(value = "id")
    val id: String = "",
    @SerialName(value = "nombre")
    val nombre: String,
    @SerialName(value = "apellidos")
    val apellidos: String,
    @SerialName(value = "email")
    val email: String
)


