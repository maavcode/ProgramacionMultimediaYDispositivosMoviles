package com.example.proyectopizzatime.modelos



data class Pago (
    val idPago: Int,
    val opcionPago: String,
    val fechaCaducidad: String,
    val cvv: Int,
    val importe: Double
)