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
    data class ObtenerUsuariosExito(val listaUsuarios: List<Usuario>) : TiendaUIState

    // Otros estados
    object Cargando : TiendaUIState
    object Error : TiendaUIState
}

class TiendaViewModel (
    // Añadir repositorios
    private val usuarioRepositorio: UsuarioRepositorio,
): ViewModel() {
    var tiendaUIState: TiendaUIState by mutableStateOf(TiendaUIState.Cargando)
        private set

    var usuarioSeleccionado: Usuario by mutableStateOf(Usuario("","","","",listOf()))
        private set

    // IMPORTANTE TRABAJAR CON MODELOS
    fun actualizarUsuarioSeleccionado(usuario: Usuario){
        usuarioSeleccionado = usuario
    }

    init {
        obtenerUsuarios()
    }

    fun obtenerUsuarios(){
        viewModelScope.launch {
            // Me aseguro de que esta en cargando el estado
            tiendaUIState = TiendaUIState.Cargando

            tiendaUIState = try {
                // Obtengo el usuario
                val listaUsuarios = usuarioRepositorio.obtenerUsuarios()
                Log.d("TiendaViewModel", "Usuarios recibidos: $listaUsuarios")
                TiendaUIState.ObtenerUsuariosExito(listaUsuarios)
            } catch (e: Exception){
                Log.e("TiendaViewModel", "Error al obtener los usuarios", e)
                TiendaUIState.Error
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
                )
            }
        }
    }
}