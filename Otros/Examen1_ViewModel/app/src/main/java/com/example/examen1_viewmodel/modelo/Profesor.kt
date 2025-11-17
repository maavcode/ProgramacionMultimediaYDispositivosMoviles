package com.example.examen1_viewmodel.modelo

class Profesor(
    override val nombre: String = "",
    val cursosImparte: String = "",
    val esTutor: Boolean = false,
    val codigoIdent: String = ""
): Persona(nombre)