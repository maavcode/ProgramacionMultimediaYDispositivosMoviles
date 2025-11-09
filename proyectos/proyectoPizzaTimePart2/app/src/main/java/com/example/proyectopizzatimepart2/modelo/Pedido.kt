package com.example.proyectopizzatimepart2.modelo

enum class TipoBebida { ninguno, agua, cola, sin_bebida }
data class Pedido (
    val idPedido: Int,
    val pizza: Pizza,
    val cantidadPizza: Int,
    val bebida: TipoBebida = TipoBebida.ninguno,
    val cantidadBebida: Int,
    val precioTotal: Double,
    val pago: Pago
    )