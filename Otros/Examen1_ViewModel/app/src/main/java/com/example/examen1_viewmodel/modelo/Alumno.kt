package com.example.examen1_viewmodel.modelo

class Alumno(
    override val nombre: String = "",
    val cursoSeleccionado: String = "",
    val NIA: String = "",
    val codIden: String = ""
): Persona(nombre)