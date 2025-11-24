package com.example.examen2marioaguilar.ui.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import com.example.examen2marioaguilar.modelos.uiState.ExamenUIState
import com.example.examen2marioaguilar.modelos.uiState.TipoJuego
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
class ExamenViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(ExamenUIState())

    val uiState: StateFlow<ExamenUIState> = _uiState.asStateFlow()

    var tipoJuego: TipoJuego by mutableStateOf(TipoJuego.non)
        private set

    var cantidadDecimos: Int by mutableStateOf(0)
        private set

    var dia: Int by mutableStateOf(0)
        private set

    var mes: Int by mutableStateOf(0)
        private set

    var anyo: Int by mutableStateOf(0)
        private set

    var numeroDecimo: Int by mutableStateOf(0)
        private set


    fun actualizarTipoJuego(nuevo: TipoJuego){
        tipoJuego = nuevo
    }

    fun actualizarCantidadDecimos(nuevo: Int){
        cantidadDecimos = nuevo
    }

    fun actualizarnumeroDecimo(nuevo: Int){
        numeroDecimo = nuevo
    }

    fun actualizarDia(nuevo: Int){
        dia = nuevo
    }

    fun actualizarMes(nuevo: Int){
        mes = nuevo
    }

    fun actualizarAnyo(nuevo: Int){
        anyo = nuevo
    }

    fun actualizarJuego() {
        _uiState.update { current ->
            current.copy(
                tipoJuego = tipoJuego,
                cantidadDecimos = cantidadDecimos,
                numeroDecimo = numeroDecimo,
                dia = dia,
                mes = mes,
                anyo = anyo
            )
        }
    }
}