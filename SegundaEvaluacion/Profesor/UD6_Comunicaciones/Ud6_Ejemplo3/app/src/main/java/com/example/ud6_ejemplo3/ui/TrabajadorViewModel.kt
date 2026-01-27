package com.example.ud6_ejemplo3.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ud6_ejemplo3.TrabajadorAplicacion
import com.example.ud6_ejemplo3.datos.TrabajadorRepositorio
import com.example.ud6_ejemplo3.modelo.Trabajador
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface TrabajadorUIState {
    data class ObtenerExito(val trabajadores: List<Trabajador>) : TrabajadorUIState
    data class CrearExito(val trabajador: Trabajador) : TrabajadorUIState
    data class ActualizarExito(val trabajador: Trabajador) : TrabajadorUIState
    data class EliminarExito(val id: String) : TrabajadorUIState

    object Error : TrabajadorUIState
    object Cargando : TrabajadorUIState
}

class TrabajadorViewModel(private val trabajadorRepositorio: TrabajadorRepositorio) : ViewModel() {
    var trabajadorUIState: TrabajadorUIState by mutableStateOf(TrabajadorUIState.Cargando)
        private set

    var trabajadorPulsado: Trabajador by mutableStateOf(Trabajador("", "", "", ""))
        private set

    fun actualizarTrabajadorPulsado(trabajador: Trabajador){
        trabajadorPulsado = trabajador
    }

    init{
        obtenerTrabajadores()
    }

    fun obtenerTrabajadores() {
        viewModelScope.launch {
            trabajadorUIState = TrabajadorUIState.Cargando
            trabajadorUIState = try {
                val listaTrabajadores = trabajadorRepositorio.obtenerTrabajadores()
                TrabajadorUIState.ObtenerExito(listaTrabajadores)
            } catch (e: IOException){
                TrabajadorUIState.Error
            } catch (e: HttpException){
                TrabajadorUIState.Error
            }
        }
    }

    fun insertarTrabajador(trabajador: Trabajador) {
        viewModelScope.launch {
            trabajadorUIState = TrabajadorUIState.Cargando
            trabajadorUIState = try {
                val trabajadorInsertado = trabajadorRepositorio.insertarTrabajador(trabajador)
                TrabajadorUIState.CrearExito(trabajadorInsertado)
            } catch (e: IOException){
                TrabajadorUIState.Error
            } catch (e: HttpException){
                TrabajadorUIState.Error
            }
        }
    }

    fun actualizarTrabajador(id: String, trabajador: Trabajador) {
        viewModelScope.launch {
            trabajadorUIState = TrabajadorUIState.Cargando
            trabajadorUIState = try {
                val trabajadorActualizado = trabajadorRepositorio.actualizarTrabajador(
                    id = id,
                    trabajador = trabajador
                )
                TrabajadorUIState.ActualizarExito(trabajadorActualizado)
            } catch (e: IOException){
                TrabajadorUIState.Error
            } catch (e: HttpException){
                TrabajadorUIState.Error
            }
        }
    }

    fun eliminarTrabajador(id: String) {
        viewModelScope.launch {
            trabajadorUIState = TrabajadorUIState.Cargando
            trabajadorUIState = try {
                trabajadorRepositorio.eliminarTrabajador(id)
                TrabajadorUIState.EliminarExito(id)
            } catch (e: IOException){
                TrabajadorUIState.Error
            } catch (e: HttpException){
                TrabajadorUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this[APPLICATION_KEY] as TrabajadorAplicacion)
                val trabajadorRepositorio = aplicacion.contenedor.trabajadorRepositorio
                TrabajadorViewModel(trabajadorRepositorio = trabajadorRepositorio)
            }
        }
    }
}

