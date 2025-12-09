package com.example.pdmtema6ejercicio1.ui.viewmodel

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
import com.example.pdmtema6ejercicio1.StarWarsAplicacion
import com.example.pdmtema6ejercicio1.datos.repositorios.NavesRepositorio
import com.example.pdmtema6ejercicio1.datos.repositorios.PersonajesRepositorio
import com.example.pdmtema6ejercicio1.datos.repositorios.PlanetasRepositorio
import com.example.pdmtema6ejercicio1.modelo.Nave
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaNave
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaPersonaje
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaPlaneta
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface StarwarsUIState {
    data object Cargando : StarwarsUIState
    data object Error : StarwarsUIState
    data class ExitoPersonajes(val data: RespuestaPersonaje) : StarwarsUIState
    data class ExitoNaves(val data: RespuestaNave) : StarwarsUIState
    data class ExitoPlanetas(val data: RespuestaPlaneta) : StarwarsUIState
}

class StarwarsViewModel (
    private val personajesRepositorio: PersonajesRepositorio,
    private val navesRepositorio: NavesRepositorio,
    private val planetasRepositorio: PlanetasRepositorio
): ViewModel() {

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
                val respuesta = personajesRepositorio.obtenerPersonajes()
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
                val respuesta = navesRepositorio.obtenerNaves()
                StarwarsUIState.ExitoNaves(respuesta)
            } catch (e: IOException) {
                StarwarsUIState.Error
            } catch (e: HttpException) {
                StarwarsUIState.Error
            }
        }
    }

    fun obtenerPlanetas() {
        viewModelScope.launch {
            starwarsUIState = StarwarsUIState.Cargando
            starwarsUIState = try {
                val respuesta = planetasRepositorio.obtenerPlanetas()
                StarwarsUIState.ExitoPlanetas(respuesta)
            } catch (e: IOException) {
                Log.v("Planeta", e.toString())
                StarwarsUIState.Error
            } catch (e: HttpException) {
                Log.v("Planeta", e.toString())
                StarwarsUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this [APPLICATION_KEY] as StarWarsAplicacion)
                val personajesRepositorio = aplicacion.contenedor.personajesRepositorio
                val navesRepositorio = aplicacion.contenedor.navesRepositorio
                val planetasRepositorio = aplicacion.contenedor.planetasRepositorio

                StarwarsViewModel(
                    personajesRepositorio = personajesRepositorio,
                    navesRepositorio = navesRepositorio,
                    planetasRepositorio = planetasRepositorio
                )
            }
        }
    }
}
