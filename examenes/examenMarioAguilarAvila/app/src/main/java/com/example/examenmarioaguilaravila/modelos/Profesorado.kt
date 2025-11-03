package com.example.examenmarioaguilaravila.modelos

data class Profesorado(
    val nombre: String,
    val cursosImparte: List<String>,
    val tutor: Boolean,
    val nia: Int,
    val codigoIdentificativo: String
)
