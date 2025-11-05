package com.example.proyectopizzatimepart2.modelo


data class Pedido (
    val idPedido: Int,
    val pizza: Pizza,
    val cantidadPizza: Int,
    val bebida: String,
    val cantidadBebida: Int,
    val precioTotal: Double,
    val pago: Pago
    )