package com.example.proyectopizzatime.modelos

import androidx.annotation.StringRes
import com.example.proyectopizzatime.ui.theme.Persona


data class Pedido (
    val idPedido: Int,
    val pizza: String,
    val tamanoPizza: String,
    val bebida: String,
    val precioPizza: Double,
    val precioBebida: Double,
    val precioTotal: Double
    )