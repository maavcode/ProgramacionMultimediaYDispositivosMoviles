package com.example.pdmtema3ejercicio1.datos

import com.example.pdmtema3ejercicio1.R
import com.example.pdmtema3ejercicio1.modelo.Persona

class Datos{
    fun cargarPersonas(): List<Persona> {
        return listOf(
            Persona(
                R.string.nombre1,
                R.string.dni1,
                R.string.telefono1,
                R.string.id1,
                R.drawable.person1
            ),
            Persona(
                R.string.nombre2,
                R.string.dni2,
                R.string.telefono2,
                R.string.id2,
                R.drawable.person2
            ),
            Persona(
                R.string.nombre3,
                R.string.dni3,
                R.string.telefono3,
                R.string.id3,
                R.drawable.person3
            ),

        )
    }
}
