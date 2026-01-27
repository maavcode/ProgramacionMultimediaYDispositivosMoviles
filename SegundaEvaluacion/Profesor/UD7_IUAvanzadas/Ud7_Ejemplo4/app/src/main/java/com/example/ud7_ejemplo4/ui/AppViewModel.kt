package com.example.ud7_ejemplo4.ui

import androidx.lifecycle.ViewModel
import com.example.ud7_ejemplo4.datos.listaInicial
import com.example.ud7_ejemplo4.modelo.Contacto
import com.example.ud7_ejemplo4.modelo.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AppViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        _uiState.update { estado ->
            estado.copy(
                listaContactos = listaInicial.toMutableList()
            )
        }
    }

    fun eliminarContacto (contacto: Contacto) {
        _uiState.update { estado ->
            val listaActualizada = estado.listaContactos.toMutableList()
            listaActualizada.remove(contacto)

            estado.copy(
                listaContactos = listaActualizada
            )
        }
    }
}