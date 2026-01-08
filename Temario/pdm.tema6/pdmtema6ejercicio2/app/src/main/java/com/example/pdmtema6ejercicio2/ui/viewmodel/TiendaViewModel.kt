package com.example.pdmtema6ejercicio2.ui.viewmodel

import android.net.http.HttpException
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pdmtema6ejercicio2.TiendaAplicacion
import com.example.pdmtema6ejercicio2.datos.repositorios.ProductoRepositorio
import com.example.pdmtema6ejercicio2.datos.repositorios.UsuarioRepositorio
import com.example.pdmtema6ejercicio2.modelo.Producto
import com.example.pdmtema6ejercicio2.modelo.Usuario
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface TiendaUIState {
    // EXITOS
    data class ObtenerUsuarioExito(val usuario: Usuario) : TiendaUIState
    data class ObtenerProductosExito(val listaProductos: List<Producto>): TiendaUIState


    // Otros estados
    object Cargando : TiendaUIState
    object Error : TiendaUIState
}

class TiendaViewModel (
    // Añadir repositorios
    private val usuarioRepositorio: UsuarioRepositorio,
    private val productoRepositorio: ProductoRepositorio

): ViewModel() {
    var tiendaUIState: TiendaUIState by mutableStateOf(TiendaUIState.Cargando)
        private set

    var usuarioSeleccionado: Usuario by mutableStateOf(Usuario(0,"","","",listOf()))
        private set

    init {
        obtenerUsuario()
    }

    fun obtenerUsuario(){
        viewModelScope.launch {
            // Me aseguro de que esta en cargando el estado
            tiendaUIState = TiendaUIState.Cargando
            try {
                // Obtengo el usuario
                val usuario = usuarioRepositorio.obtenerUsuario()
                // Asignar usuario
                usuarioSeleccionado = usuario
                Log.d("TiendaViewModel", "Usuario recibido: $usuario")
                tiendaUIState = TiendaUIState.ObtenerUsuarioExito(usuario)
            } catch (e: Exception){
                Log.e("TiendaViewModel", "Error al obtener usuario", e)
                tiendaUIState = TiendaUIState.Error
            }
        }
    }

    fun obtenerProductos(){
        viewModelScope.launch {
            // Me aseguro de que esta en cargando el estado
            tiendaUIState = TiendaUIState.Cargando
            try {
                // Obtengo la lista de productos
                val listaProductos = productoRepositorio.obtenerProductos()
                Log.d("TiendaViewModel", "Lista de productos: $listaProductos")
                // Introduzco la lista de los productos al estado (por eso puedo utilizarlo luego)
                tiendaUIState = TiendaUIState.ObtenerProductosExito(listaProductos)
            } catch (e: Exception){
                Log.e("TiendaViewModel", "Error al obtener productos", e)
                tiendaUIState = TiendaUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this [APPLICATION_KEY] as TiendaAplicacion)
                // Repositorios
                val usuarioRepositorio = aplicacion.contenedor.usuarioRepositorio
                val productoRepositorio = aplicacion.contenedor.productoRepositorio

                TiendaViewModel(
                    usuarioRepositorio = usuarioRepositorio,
                    productoRepositorio = productoRepositorio
                )
            }
        }
    }
}