package com.example.pdmtema6ejercicio1.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdmtema6ejercicio1.conexion.Api
import com.example.pdmtema6ejercicio1.modelo.Nave
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaNave
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaPersonaje
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface StarwarsUIState {
    data object Cargando : StarwarsUIState
    data object Error : StarwarsUIState
    data class ExitoPersonajes(val data: RespuestaPersonaje) : StarwarsUIState
    data class ExitoNaves(val data: RespuestaNave) : StarwarsUIState
}

class StarwarsViewModel : ViewModel() {

    var starwarsUIState: StarwarsUIState by mutableStateOf(StarwarsUIState.Cargando)
        private set

    fun resetearEstado() {
        starwarsUIState = StarwarsUIState.Cargando
    }

    var navePulsada: Nave by mutableStateOf(Nave()) // Para guardar la nave pulsada y mostrrar sus peliculas
        private set

    fun obtenerPersonaje() {
        viewModelScope.launch {
            starwarsUIState = StarwarsUIState.Cargando
            starwarsUIState = try {
                val respuesta = Api.servicioRetrofit.obtenerPersonaje()
                StarwarsUIState.ExitoPersonajes(respuesta)
            } catch (e: IOException) {
                StarwarsUIState.Error
            } catch (e: HttpException) {
                StarwarsUIState.Error
            }
        }
    }

    fun obtenerNaves() {
        viewModelScope.launch {
            starwarsUIState = StarwarsUIState.Cargando
            starwarsUIState = try {
                val respuesta = Api.servicioRetrofit.obtenerNaves()
                StarwarsUIState.ExitoNaves(respuesta)
            } catch (e: IOException) {
                StarwarsUIState.Error
            } catch (e: HttpException) {
                StarwarsUIState.Error
            }
        }
    }
}
