package com.example.pdmtema6ejercicio1.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Planeta(
    @SerialName(value = "name")
    val nombre: String,
    @SerialName(value = "terrain")
    val terreno: String
)