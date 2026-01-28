package com.example.plantillanavigationdrawer.ui.pantallas

import androidx.compose.runtime.Composable
import com.example.plantillanavigationdrawer.modelo.Usuario
import com.example.plantillanavigationdrawer.ui.viewmodel.PlantillaUIState

@Composable
fun PantallaInicio(
    estado: PlantillaUIState,
    obtenerUsuarios: () -> Unit,
    onListarReservas: (Usuario) -> Unit,
    onEliminarUsuario: (Usuario) -> Unit
){
    when(estado){
        is PlantillaUIState.Cargando -> PantallaCargando()
        is PlantillaUIState.Error -> PantallaError()
        is PlantillaUIState.ObtenerExito ->
            PantallaListarUsuarios(
                listaUsuarios = estado.listaUsuarios,
                onListarReservas = onListarReservas,
                onEliminarUsuario = onEliminarUsuario
            )
        is PlantillaUIState.ActualizarExito -> obtenerUsuarios()
        is PlantillaUIState.EliminarExito -> obtenerUsuarios()
        is PlantillaUIState.InsertarExito -> obtenerUsuarios()
    }
}