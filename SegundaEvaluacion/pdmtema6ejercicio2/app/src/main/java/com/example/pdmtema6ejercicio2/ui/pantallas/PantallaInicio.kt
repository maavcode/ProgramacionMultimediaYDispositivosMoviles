package com.example.pdmtema6ejercicio2.ui.pantallas

import androidx.compose.runtime.Composable
import com.example.pdmtema6ejercicio2.modelo.Producto
import com.example.pdmtema6ejercicio2.modelo.Usuario
import com.example.pdmtema6ejercicio2.ui.viewmodel.TiendaUIState

@Composable
fun PantallaInicio(
    estado: TiendaUIState,
    onUsuarioPulsado: (usuario: Usuario) -> Unit,
    onModificarProductos: () -> Unit,
    onObtenerUsuarios: () -> Unit
) {
    when (estado) {
        is TiendaUIState.Cargando -> PantallaCargando()
        is TiendaUIState.Error -> PantallaError()
        is TiendaUIState.ObtenerExito ->
            PantallaUsuarios(
                listaUsuarios = estado.listaUsuarios,
                onUsuarioPulsado = onUsuarioPulsado,
                onModificarProductos = onModificarProductos
            )
        is TiendaUIState.ActualizarExito -> onObtenerUsuarios()
    }
}