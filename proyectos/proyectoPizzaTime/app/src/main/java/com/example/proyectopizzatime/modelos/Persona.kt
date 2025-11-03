package com.example.proyectopizzatime.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.proyectopizzatime.modelos.Pedido

data class Persona (
    val personaId: Int,
    val nombre: String,
    val correo: String,
    val telefono: String,
    @DrawableRes val imageResourceId: Int,
    val listaPedidos: List<Pedido>
)
