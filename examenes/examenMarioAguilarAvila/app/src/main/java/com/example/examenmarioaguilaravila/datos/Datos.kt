package com.example.examenmarioaguilaravila.datos

import com.example.examenmarioaguilaravila.modelos.Alumnado
import com.example.examenmarioaguilaravila.modelos.Persona
import com.example.examenmarioaguilaravila.modelos.Profesorado

class Datos {

    fun cargarAlumnado(): List<Alumnado>{
        return listOf(
            Alumnado(
                nombre = "Pepe",
                cursoMatriculado = "2ºDAM",
                nia = 12345,
                codigoIdentificativo = "e135"
            ),
            Alumnado(
                nombre = "Pepe",
                cursoMatriculado = "2ºDAM",
                nia = 12345,
                codigoIdentificativo = "e135"
            ),
            Alumnado(
                nombre = "Pepe",
                cursoMatriculado = "2ºDAM",
                nia = 12345,
                codigoIdentificativo = "e135"
            ),
            Alumnado(
                nombre = "Pepe",
                cursoMatriculado = "2ºDAM",
                nia = 12345,
                codigoIdentificativo = "e135"
            ),
            Alumnado(
                nombre = "Pepe",
                cursoMatriculado = "2ºDAM",
                nia = 12345,
                codigoIdentificativo = "e135"
            )
        )
    }

    fun cargarProfesorado(): List<Profesorado>{
        return listOf(
            Profesorado(
                nombre = "Juan",
                cursosImparte = listOf("Segundo, Primero"),
                nia = 12345,
                tutor = true,
                codigoIdentificativo = "nauJSI"

            ),
            Profesorado(
                nombre = "Juan",
                cursosImparte = listOf("Segundo, Primero"),
                nia = 12345,
                tutor = true,
                codigoIdentificativo = "nauJSI"

            ),
            Profesorado(
                nombre = "Juan",
                cursosImparte = listOf("Segundo, primero"),
                nia = 12345,
                tutor = true,
                codigoIdentificativo = "nauJSI"

            ),
            Profesorado(
                nombre = "Juan",
                cursosImparte = listOf("Segundo, Primero"),
                nia = 12345,
                tutor = true,
                codigoIdentificativo = "nauJSI"

            ),
            Profesorado(
                nombre = "Juan",
                cursosImparte = listOf("Segundo, Primero"),
                nia = 12345,
                tutor = true,
                codigoIdentificativo = "nauJSI"

            )
        )
    }

    fun cargarPersonas(): List<Persona>{
        return listOf(
            Persona(
                    tipoPersona = "Profesor",
                    nombre = "Victoria"
                ),
            Persona(
                tipoPersona = "Alumno",
                nombre = "manolo"
            ),
            Persona(
                tipoPersona = "Profesor",
                nombre = "Victoria"
            ),
            Persona(
                tipoPersona = "Alumno",
                nombre = "manolo"
            ),
            Persona(
                tipoPersona = "Profesor",
                nombre = "Victoria"
            ),
            Persona(
                tipoPersona = "Alumno",
                nombre = "manolo"
            ),
            Persona(
                tipoPersona = "Profesor",
                nombre = "Victoria"
            ),
            Persona(
                tipoPersona = "Alumno",
                nombre = "manolo"
            ),
                )


    }

    fun getCodigoIdentificativoAlumnado (nombre: String, nia: Int): String{
        var codigoIdentificativo: String = ""

        return codigoIdentificativo

    }

    fun getCodigoIdentificativoProfesorado (nombre: String, nia: Int): String{
        var codigoIdentificativo: String = ""

        return codigoIdentificativo

    }
}