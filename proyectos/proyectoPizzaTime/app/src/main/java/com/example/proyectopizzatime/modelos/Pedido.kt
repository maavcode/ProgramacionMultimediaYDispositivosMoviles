package com.example.proyectopizzatime.modelos


data class Pedido (
    val idPedido: Int,
    val tipoPizza: String,
    val cantidadPizza: Int,
    val tamanoPizza: String,
    val tipoBebida: String,
    val cantidadBebida: Int,
    val precioTotal: Double,
    val pago: Pago
    )