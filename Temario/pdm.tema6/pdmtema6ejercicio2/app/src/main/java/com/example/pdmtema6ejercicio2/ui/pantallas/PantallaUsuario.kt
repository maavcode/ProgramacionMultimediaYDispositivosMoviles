package com.example.pdmtema6ejercicio2.ui.pantallas

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.pdmtema6ejercicio2.modelo.Usuario
import com.example.pdmtema6ejercicio2.ui.viewmodel.TiendaUIState

@Composable
fun PantallaUsuario(
    estado: TiendaUIState
) {
    when (estado) {

        is TiendaUIState.Cargando ->
            PantallaCargando(modifier = Modifier.fillMaxSize())

        is TiendaUIState.ObtenerUsuarioExito ->
            PantallaExitoUsuario(usuario = estado.usuario)

        else ->
            PantallaError(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun PantallaExitoUsuario(
    usuario: Usuario
){
    Text(
        text = "Bienvenido ${usuario.nombre}"
    )
}
