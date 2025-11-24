package com.example.examen2marioaguilar.modelos

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.examen2marioaguilar.modelos.uiState.ExamenUIState
import com.example.examen2marioaguilar.modelos.uiState.TipoJuego

@RequiresApi(Build.VERSION_CODES.O)
data class DecimoNavidad(
    val numeroDecimo: Int = 0,
): ExamenUIState(tipoJuego = TipoJuego.decimo)