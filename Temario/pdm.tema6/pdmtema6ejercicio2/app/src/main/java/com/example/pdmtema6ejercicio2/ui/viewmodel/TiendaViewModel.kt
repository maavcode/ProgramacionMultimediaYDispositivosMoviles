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
import com.example.pdmtema6ejercicio2.datos.repositorios.UsuarioRepositorio
import com.example.pdmtema6ejercicio2.modelo.Usuario
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface TiendaUIState {
    // EXITOS
    data class ObtenerUsuariosExito(val usuarios: List<Usuario>): TiendaUIState
    data class ObtenerUsuarioExito(val usuario: Usuario) : TiendaUIState


    // Otros
    object Cargando : TiendaUIState
    object Error : TiendaUIState
}

class TiendaViewModel (
    // Añadir repositorios
    private val usuarioRepositorio: UsuarioRepositorio

): ViewModel() {

    fun resetearEstado() {
        tiendaUIState = TiendaUIState.Cargando
    }

    var tiendaUIState: TiendaUIState by mutableStateOf(TiendaUIState.Cargando)
        private set

    /*
    var usuarioPulsado: Usuario by mutableStateOf("")
        private set
    */

    init {
        obtenerUsuarios()
    }

    fun obtenerUsuarios() {
        viewModelScope.launch {
            tiendaUIState = TiendaUIState.Cargando
            try {
                val listaUsuarios = usuarioRepositorio.obtenerUsuarios()
                Log.d("TiendaViewModel", "Usuarios recibidos: $listaUsuarios")
                tiendaUIState = TiendaUIState.ObtenerUsuariosExito(listaUsuarios)
            } catch (e: Exception) {
                Log.e("TiendaViewModel", "Error al obtener usuarios", e)
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

                TiendaViewModel(
                    usuarioRepositorio = usuarioRepositorio,
                )
            }
        }
    }
}