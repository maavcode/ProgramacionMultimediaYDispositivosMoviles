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
    @SerialName("dni")
    val dni: String,
    @SerialName("productos")
    val idProductos: List<Producto>,
)