package com.example.proyectopizzatimepart2.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.proyectopizzatimepart2.datos.Datos
import com.example.proyectopizzatimepart2.modelo.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RealizarPedidoViewModel : ViewModel() {

    // SOLUCIÓN: Inicializar correctamente o usar valores por defecto
    private val _uiState = MutableStateFlow(RealizarPedidoUIState())
    private val _listaPedidos = mutableStateOf(Datos().cargarPedidos())
    val listaPedidos: List<Pedido> get() = _listaPedidos.value

    // Agregar un pedido
    fun agregarPedido(pedido: Pedido) {
        _listaPedidos.value = _listaPedidos.value + pedido
    }
    val uiState: StateFlow<RealizarPedidoUIState> = _uiState.asStateFlow()

    // Funciones para actualizar estados
    fun actualizarPizza(pizzaNueva: Pizza) {
        _uiState.update { estadoActual ->
            estadoActual.copy(
                pizza = pizzaNueva
            )
        }
        calcularTotal() // Añadir esto para recalcular
    }

    fun actualizarBebida(bebidaNueva: TipoBebida) {
        _uiState.update { estadoActual ->
            estadoActual.copy(
                bebida = bebidaNueva
            )
        }
        calcularTotal()
    }

    fun actualizarCantidadPizza(cantidadNueva: Int) {
        _uiState.update { estadoActual ->
            estadoActual.copy(
                cantidadPizza = cantidadNueva // No actualiza el subtipo de la pizza barbacoa y no se porque
            )
        }
        calcularTotal()
    }

    fun actualizarCantidadBebida(cantidadNueva: Int) {
        _uiState.update { estadoActual ->
            estadoActual.copy(
                cantidadBebida = cantidadNueva
            )
        }
        calcularTotal()
    }

    fun actualizarPago(pagoNuevo: Pago) {
        _uiState.update { estadoActual ->
            estadoActual.copy(
                pago = pagoNuevo
            )
        }
    }

    private fun calcularTotal() {
        _uiState.update { estadoActual ->
            val precioPizza = when (estadoActual.pizza.tamanoPizza) {
                TamanoPizza.pequena -> 4.95
                TamanoPizza.mediana -> 6.95
                TamanoPizza.grande -> 10.95
                else -> 0.0
            }

            val precioBebida = when (estadoActual.bebida) {
                TipoBebida.agua -> 2.0
                TipoBebida.cola -> 2.5
                TipoBebida.sin_bebida -> 0.0
                else -> 0.0
            }

            val total = (precioPizza * estadoActual.cantidadPizza) +
                    (precioBebida * estadoActual.cantidadBebida)

            estadoActual.copy(
                precioTotal = total
            )
        }
    }


    fun reiniciarPedido() {
        _uiState.value = RealizarPedidoUIState()
    }
}