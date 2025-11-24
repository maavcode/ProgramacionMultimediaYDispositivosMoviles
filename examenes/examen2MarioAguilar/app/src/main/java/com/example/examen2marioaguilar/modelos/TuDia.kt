package com.example.examen2marioaguilar.modelos

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.examen2marioaguilar.modelos.uiState.ExamenUIState
import com.example.examen2marioaguilar.modelos.uiState.TipoJuego

@RequiresApi(Build.VERSION_CODES.O)
class TuDia (
    val dia: Int = 1,
    val mes: Int = 1,
    val anyo: Int = 1900,
): ExamenUIState(tipoJuego = TipoJuego.tuDia)