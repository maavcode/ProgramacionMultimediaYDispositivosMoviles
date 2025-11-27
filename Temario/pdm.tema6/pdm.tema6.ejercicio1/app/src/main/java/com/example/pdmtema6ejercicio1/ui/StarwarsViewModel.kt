package com.example.pdmtema6ejercicio1.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdmtema6ejercicio1.conexion.Api
import com.example.pdmtema6ejercicio1.modelo.Respuesta
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface StarwarsUIState { // Que es sealed?
    data class Exito(val respuesta: Respuesta) : StarwarsUIState
    object Error : StarwarsUIState
    object Cargando : StarwarsUIState
}

class StarwarsViewModel : ViewModel() {

    var starwarsUIState: StarwarsUIState by mutableStateOf(StarwarsUIState.Cargando)
        private set

    init {
        obtenerPersonaje()
    }

    fun obtenerPersonaje() {
        viewModelScope.launch {
            starwarsUIState = StarwarsUIState.Cargando
            starwarsUIState = try {
                val listaPersonajes = Api.servicioRetrofit.obtenerPersonaje()
                StarwarsUIState.Exito(listaPersonajes)
            } catch (e: IOException){
                StarwarsUIState.Error
            } catch (e: HttpException){
                StarwarsUIState.Error
            }
        }
    }
}