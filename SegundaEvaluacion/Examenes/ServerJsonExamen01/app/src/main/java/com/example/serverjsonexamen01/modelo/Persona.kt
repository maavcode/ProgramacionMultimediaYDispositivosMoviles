package com.example.serverjsonexamen01.modelo

import kotlinx.serialization.Serializable

@Serializable
sealed class Persona {
    abstract val tipo: String
    abstract val nombre: String
}
