package com.example.pdmtema6ejercicio2.ui.pantallas

import androidx.compose.runtime.Composable
import com.example.pdmtema6ejercicio2.modelo.Usuario
import com.example.pdmtema6ejercicio2.ui.viewmodel.TiendaUIState

@Composable
fun PantallaInicio(
    estado: TiendaUIState,
    usuario: Usuario,
    onAnyadirPulsado: () -> Unit,
    onListarPulsado: () -> Unit
) {
    when (estado) {
        is TiendaUIState.Cargando -> PantallaCargando()
        is TiendaUIState.Error -> PantallaError()
        is TiendaUIState.ObtenerUsuarioExito ->
            PantallaUsuario(
                usuario = usuario,
                onAnyadirPulsado = onAnyadirPulsado,
                onListarPulsado = onListarPulsado
            )
        is TiendaUIState.ObtenerProductosExito -> onAnyadirPulsado()
    }
}