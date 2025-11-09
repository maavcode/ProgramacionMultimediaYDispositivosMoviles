package com.example.proyectopizzatimepart2.modelo


enum class OpcionesPago{
    ninguno,
    Visa,
    MasterCard,
    Euro_6000
}
data class Pago(
    val idPago: Int = 0,
    val opcionPago: OpcionesPago = OpcionesPago.ninguno,
    val fechaCaducidad: String = "",
    val cvv: String = "",
    val numeroTarjeta: String = ""
)
