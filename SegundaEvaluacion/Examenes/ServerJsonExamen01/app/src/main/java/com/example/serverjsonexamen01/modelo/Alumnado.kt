package com.example.serverjsonexamen01.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("alumnado")
data class Alumnado(
    override val tipo: String = "alumnado",
    override val nombre: String,
    val cursoMatriculado: String,
    val nia: String,
    val codigoIdentificativo: String
) : Persona()
