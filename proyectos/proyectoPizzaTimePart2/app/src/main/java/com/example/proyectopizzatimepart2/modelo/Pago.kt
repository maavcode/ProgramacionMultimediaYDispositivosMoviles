package com.example.proyectopizzatimepart2.modelo



data class Pago(
    val idPago: Int,
    val opcionPago: String,
    val fechaCaducidad: String,
    val cvv: Int,
    val numeroTarjeta: String,
    val importe: Double
)
