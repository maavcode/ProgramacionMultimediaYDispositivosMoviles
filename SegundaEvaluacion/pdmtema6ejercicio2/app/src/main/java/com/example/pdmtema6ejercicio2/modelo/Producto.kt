package com.example.pdmtema6ejercicio2.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Producto(
    @SerialName("id")
    val id: String = "",
    @SerialName("nombre")
    val nombre: String,
    @SerialName("precio")
    val precio: String,

)