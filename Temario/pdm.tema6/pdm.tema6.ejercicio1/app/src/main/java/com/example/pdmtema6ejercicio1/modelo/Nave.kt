package com.example.pdmtema6ejercicio1.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Nave(
    val name: String,
    val model: String
)