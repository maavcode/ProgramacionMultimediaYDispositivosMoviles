package com.example.pdmtema4ejercicio2.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pdmtema4ejercicio2.modelo.OperacionUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OperacionViewModel: ViewModel() {
    private val _operacionUIState = MutableStateFlow(OperacionUIState())

    val operacionUIState: StateFlow<OperacionUIState> = _operacionUIState.asStateFlow()

    var respuestaNumero1 by mutableStateOf("")
        private set

    var respuestaNumero2 by mutableStateOf("")
        private set

    fun actualiarNumero1(num: String){
        respuestaNumero1 = num

        _operacionUIState.update { estadoActual ->
            estadoActual.copy(
                numero1 = respuestaNumero1
            )

        }

        calcular()

    }


}