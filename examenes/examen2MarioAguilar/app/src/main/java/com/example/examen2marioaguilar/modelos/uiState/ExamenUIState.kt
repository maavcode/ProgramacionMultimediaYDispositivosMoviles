package com.example.examen2marioaguilar.modelos.uiState

import android.os.Build
import androidx.annotation.RequiresApi

import java.time.LocalDate

enum class TipoJuego {
    non,
    decimo,
    tuDia
}

data class ExamenUIState @RequiresApi(Build.VERSION_CODES.O) constructor(
    open val tipoJuego: TipoJuego = TipoJuego.non,
    val fechaJugada: LocalDate = LocalDate.now()
)