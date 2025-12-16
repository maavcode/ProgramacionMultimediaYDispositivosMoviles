package com.example.pdmtema6ejercicio2.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

sealed interface TiendaUIState {
    data object Cargando : TiendaUIState
    data object Error : TiendaUIState
    // Ejemplo exito data class ExitoPersonajes(val data: RespuestaPersonaje) : StarwarsUIState

}

class TiendaViewModel (
    // Añadir repositorios


): ViewModel() {
    var tiendaUIState: TiendaUIState by mutableStateOf(TiendaUIState.Cargando)
    fun resetearEstado() {
        tiendaUIState = TiendaUIState.Cargando
    }
}