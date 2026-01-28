package com.example.plantillanavigationdrawer.ui.pantallas

import androidx.compose.runtime.Composable
import com.example.plantillanavigationdrawer.ui.viewmodel.PlantillaUIState

@Composable
fun PantallaInicio(
    estado: PlantillaUIState,
    obtenerUsuarios: () -> Unit
){
    when(estado){
        is PlantillaUIState.Cargando -> PantallaCargando()
        is PlantillaUIState.Error -> PantallaError()
        is PlantillaUIState.obtenerExito ->
            PantallaListar(
                listaUsuarios = estado.listaUsuarios
            )
        is PlantillaUIState.actualizarExito -> obtenerUsuarios()
        is PlantillaUIState.eliminarExito -> obtenerUsuarios()
        is PlantillaUIState.insertarExito -> obtenerUsuarios()
    }
}