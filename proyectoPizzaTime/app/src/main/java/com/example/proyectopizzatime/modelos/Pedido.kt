package com.example.proyectopizzatime.modelos

import androidx.annotation.StringRes
import com.example.proyectopizzatime.ui.theme.Persona


data class Pedido (
    val idPedido: Int,
    val tipoPizza: String,
    val cantidadPizza: Int,
    val tamanoPizza: String,
    val tipoBebida: String,
    val cantidadBebida: Int,
    val precioTotal: Double
    )