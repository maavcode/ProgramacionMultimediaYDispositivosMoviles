package com.example.pdmtema6ejercicio1.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Nave( // Variables instanciadas
    @SerialName(value = "name")
    val name: String = "",
    @SerialName(value = "model")
    val model: String = ""
)