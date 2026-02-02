package com.example.ud8_ejemplo1.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ud8_ejemplo1.InventarioAplicacion
import com.example.ud8_ejemplo1.datos.ProductoRepositorio
import com.example.ud8_ejemplo1.modelo.Producto
import kotlinx.coroutines.launch

sealed interface InventarioUIState {
    data class ObtenerExitoTodos(val productos: List<Producto>) : InventarioUIState
    data class ObtenerExito(val producto: Producto) : InventarioUIState

    object CrearExito: InventarioUIState
    object ActualizarExito: InventarioUIState
    object Error : InventarioUIState
    object Cargando : InventarioUIState
}

class InventarioViewModel(private val productoRepositorio: ProductoRepositorio) : ViewModel() {

    var inventarioUIState: InventarioUIState by mutableStateOf(InventarioUIState.Cargando)
        private set

    var productoPulsado: Producto by mutableStateOf(Producto(0, "", 0.0, 0))
        private set

    init {
        obtenerProductos()
    }

    fun obtenerProductos() {
        viewModelScope.launch {
            inventarioUIState = try {
                val lista = productoRepositorio.obtenerTodosProductos()
                InventarioUIState.ObtenerExitoTodos(lista)
            } catch (e: Exception) {
                InventarioUIState.Error
            }
        }
    }

    fun obtenerProducto(id: Int) {
        viewModelScope.launch {
            inventarioUIState = try {
                val producto = productoRepositorio.obtenerProducto(id)
                productoPulsado = producto
                InventarioUIState.ObtenerExito(producto)
            } catch (e: Exception) {
                InventarioUIState.Error
            }
        }
    }

    fun insertarProducto(producto: Producto) {
        viewModelScope.launch {
            inventarioUIState = try {
                productoRepositorio.insertar(producto)
                InventarioUIState.CrearExito
            } catch (e: Exception) {
                InventarioUIState.Error
            }
        }
    }

    fun actualizarProducto(producto: Producto) {
        viewModelScope.launch {
            inventarioUIState = try {
                productoRepositorio.actualizar(producto)
                InventarioUIState.ActualizarExito
            } catch (e: Exception) {
                InventarioUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this[APPLICATION_KEY] as InventarioAplicacion)
                val productoRepositorio = aplicacion.contenedor.productoRepositorio
                InventarioViewModel(productoRepositorio = productoRepositorio)
            }
        }
    }
}