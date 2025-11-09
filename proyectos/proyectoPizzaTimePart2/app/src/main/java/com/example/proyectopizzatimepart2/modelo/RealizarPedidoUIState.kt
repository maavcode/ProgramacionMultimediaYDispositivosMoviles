package com.example.proyectopizzatimepart2.modelo

data class RealizarPedidoUIState(
    val pizza: Pizza = Pizza(),
    val bebida: TipoBebida = TipoBebida.sin_bebida,
    val cantidadPizza: Int = 1,
    val cantidadBebida: Int = 1,
    val precioTotal: Double = 0.0,
    val pago: Pago = Pago()
)
