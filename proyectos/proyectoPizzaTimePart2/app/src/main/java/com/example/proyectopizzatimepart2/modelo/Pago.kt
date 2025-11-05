package com.example.proyectopizzatimepart2.modelo



data class Pago(
    val idPago: Int = 0,
    val opcionPago: String = "",
    val fechaCaducidad: String = "",
    val cvv: String = "",
    val numeroTarjeta: String = "",
    val importe: Double = 0.0
)
