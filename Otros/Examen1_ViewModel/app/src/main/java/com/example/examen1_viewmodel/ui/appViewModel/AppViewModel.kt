package com.example.examen1_viewmodel.ui.appViewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.examen1_viewmodel.modelo.Alumno
import com.example.examen1_viewmodel.modelo.AppUIState
import com.example.examen1_viewmodel.modelo.Persona
import com.example.examen1_viewmodel.modelo.Profesor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.examen1_viewmodel.modelo.Rol

class AppViewModel : ViewModel() {

    private val _appUIState = MutableStateFlow(AppUIState())
    val appUIState: StateFlow<AppUIState> = _appUIState.asStateFlow()

    var nombreSeleccionado by mutableStateOf("")
        private set

    var cursoMatSeleccionado by mutableStateOf("")
        private set

    var NIASeleccionado by mutableStateOf("")
        private set

    var codIden by mutableStateOf("")
        private set

    var codigoIdent by mutableStateOf("")
        private set

    var cursosImpaSeleccionado by mutableStateOf("")
        private set

    var esTutor by mutableStateOf(false)
        private set


    fun actualizarNombre(nuevo: String) {
        nombreSeleccionado = nuevo
    }

    fun actualizarNIA(nuevo: String) {
        NIASeleccionado = nuevo
    }

    fun actualizarCodIden(nuevoCodigo: String) {
        codIden = nuevoCodigo
    }

    fun actualizarCodigoIdent(nuevoCodigo: String) {
        codigoIdent = nuevoCodigo
    }

    fun actualizarEsTutor(valor: Boolean) {
        esTutor = valor
    }

    fun generarCodigoAlumno(nombre: String, NIA: String): String {
        val n = NIA.trim()
        if (n.length != 5 || n == "00000" || !n.all { it.isDigit() }) return ""
        val ultimaLetra = if (nombre.isNotBlank()) nombre.trim().last().toString() else ""
        val impares = n.filterIndexed { i, _ -> i % 2 == 0 }
        return ultimaLetra + impares
    }

    fun generarCodigoProfesor(nombre: String, esTutor: Boolean): String {
        val n = nombre.trim()
        if (n.isEmpty()) return ""
        val invertido = n.reversed()
        val tutorTxt = if (esTutor) "SI" else "NO"
        return invertido + tutorTxt
    }

    var rolSeleccionado by mutableStateOf(Rol.ALUMNO)
        private set

    fun actualizarRol(nuevo: Rol) {
        rolSeleccionado = nuevo
    }

    var cursoSeleccionado by mutableStateOf("")
        private set

    fun actualizarTutor(nuevo: Boolean) {
        esTutor = nuevo
    }

    fun actualizarCurso (nuevo : String){
        cursoSeleccionado=nuevo
    }

    fun registrarPersonaActual(persona: Persona = Persona()) {
        val state = _appUIState.value

        if (persona is Profesor) {
            val profesor = Profesor(
                nombre = nombreSeleccionado,
                cursosImparte = cursoSeleccionado,
                esTutor = esTutor,
                codigoIdent = codigoIdent
            )

            _appUIState.value = state.copy(
                personas = state.personas + profesor
            )

        } else if (persona is Alumno){
            val alumno = Alumno(
                nombre = nombreSeleccionado,
                cursoSeleccionado = cursoSeleccionado,
                NIA = NIASeleccionado,
                codIden = codIden
            )

            _appUIState.value = state.copy(
                personas = state.personas + alumno
            )
        }

        // Log de depuración
        _appUIState.value.personas.forEach { persona ->
            when (persona) {
                is Alumno -> Log.d("debug.app", "Alumno: ${persona.nombre} Curso: ${persona.cursoSeleccionado} NIA: ${persona.NIA}, Cod: ${persona.codIden}")
                is Profesor -> Log.d("debug.app", "Profesor: ${persona.nombre} Cursos: ${persona.cursosImparte} Tutor: ${persona.esTutor}, Cod: ${persona.codigoIdent}")
            }
        }
    }

    init {
        val personasDemo = listOf(
            Alumno("Luis", "Primero", "10001", "a001"),
            Alumno("María", "Segundo", "10002", "a002"),
            Profesor("Ana", "Primero", true, "p001"),
            Profesor("Miguel", "Segundo", false, "p002"),
            Alumno("Carlos", "Primero", "10003", "a003"),
            Alumno("Elena", "Segundo", "10006", "a006"),
            Profesor("Sofía", "Primero", true, "p003"),
            Profesor("David", "Segundo", false, "p004"),
            Profesor("Laura", "Primero", true, "p005"),
            Alumno("Lucía", "Segundo", "10004", "a004"),
            Alumno("Javier", "Primero", "10005", "a005"),
            Profesor("Pedro", "Segundo", false, "p006")
        )

        _appUIState.value = _appUIState.value.copy(
            personas = personasDemo
        )

        rolSeleccionado = Rol.PROFESOR // Puedes cambiarlo a Rol.PROFESOR para probar
    }

}