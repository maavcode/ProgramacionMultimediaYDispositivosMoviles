package com.example.proyectopizzatimepart2.modelo

import androidx.annotation.DrawableRes
import com.example.proyectopizzatimepart2.modelo.Pedido

data class Persona (
    val idPersona: Int,
    val nombre: String,
    val correo: String,
    val telefono: String,
    @DrawableRes val imageResourceId: Int,
    val listaPedidos: List<Pedido>
)
