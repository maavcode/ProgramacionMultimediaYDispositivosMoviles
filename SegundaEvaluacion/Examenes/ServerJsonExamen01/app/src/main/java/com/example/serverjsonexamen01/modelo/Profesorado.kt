package com.example.serverjsonexamen01.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("profesorado")
data class Profesorado(
    override val tipo: String,
    override val nombre: String,
    val cursosImparte: List<String>,
    val tutor: Boolean,
    val nia: String,
    val codigoIdentificativo: String
) : Persona()
