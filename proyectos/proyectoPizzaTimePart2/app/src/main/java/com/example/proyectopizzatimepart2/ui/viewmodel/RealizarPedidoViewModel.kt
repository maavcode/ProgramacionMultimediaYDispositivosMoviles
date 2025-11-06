package com.example.proyectopizzatimepart2.ui.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.example.proyectopizzatimepart2.R
import com.example.proyectopizzatimepart2.datos.Datos
import com.example.proyectopizzatimepart2.modelo.Pizza
import com.example.proyectopizzatimepart2.modelo.RealizarPedidoUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.Int
import kotlin.String

class RealizarPedidoViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(RealizarPedidoUIState())

    val uiState: StateFlow<RealizarPedidoUIState> = _uiState.asStateFlow()

    var respuestaCantidadPizza by mutableIntStateOf(1)
        private set

    var respuestaCantidadBebida by mutableIntStateOf(1)
        private set

    /*

    var respuestaTipoPizza by mutableStateOf("")
        private set

    var respuestaBebida by mutableStateOf("")
        private set

    var respuestaSubtipoPizza by mutableStateOf("")
        private set

     */

    var respuestaPizza by mutableStateOf(Pizza())
        private set

    var respuestaBebida by mutableStateOf("")
        private set


    @Composable
    fun actualizarCantidadPizza(cantidadNueva: Int) {
        respuestaCantidadPizza = cantidadNueva

        _uiState.update { estadoActual ->
            estadoActual.copy(
                cantidadPizza = respuestaCantidadPizza
            )
        }

        calcularTotal()
    }

    @Composable
    fun actualizarCantidadBebida(cantidadNueva: Int) {
        respuestaCantidadBebida = cantidadNueva

        _uiState.update { estadoActual ->
            estadoActual.copy(
                cantidadBebida = respuestaCantidadBebida
            )
        }

        calcularTotal()
    }

    fun actualizarPizza (pizzaNueva: Pizza) {
        respuestaPizza = pizzaNueva

        _uiState.update { estadoActual ->
            respuestaPizza.copy(
                idPizza = pizzaNueva.idPizza,
                tipoPizza = pizzaNueva.tipoPizza,
                subTipoPizza = pizzaNueva.subTipoPizza,
                tamanoPizza = pizzaNueva.tamanoPizza
            )

            estadoActual.copy(
                pizza = respuestaPizza
            )
        }
    }

    fun actualizarBebida (bebidaNueva: String){
        respuestaBebida = bebidaNueva

        _uiState.update { estadoActual ->
            estadoActual.copy(
                bebida = respuestaBebida
            )
        }
    }

    @Composable
    private fun calcularTotal (){
        _uiState.update { estadoActual ->
            val tamanoPizza: String = estadoActual.pizza.tamanoPizza
            val tipoBebida: String = estadoActual.bebida
            val cantidadPizza = estadoActual.cantidadPizza
            val cantidadBebida = estadoActual.cantidadBebida

            var precioPizza: Double = 0.0
            when(tamanoPizza){
                stringResource(R.string.peque_a) -> precioPizza = 4.95
                stringResource(R.string.mediana) -> precioPizza = 6.95
                stringResource(R.string.grande) -> precioPizza = 10.95
            }
            var precioBebida: Double = 0.0
            when(tipoBebida){
                stringResource(R.string.agua) -> precioBebida = 2.0
                stringResource(R.string.cola) -> precioBebida = 2.5
                stringResource(R.string.sin_bebida) -> precioBebida = 0.0
            }
            val nuevoPrecioTotal: Double = (precioPizza*cantidadPizza) + (precioBebida*cantidadBebida)
            estadoActual.copy(
                precioTotal = nuevoPrecioTotal
            )

        }
    }
}