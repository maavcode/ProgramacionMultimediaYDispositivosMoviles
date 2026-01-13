package com.example.pdmtema6ejercicio2.ui.pantallas

import androidx.compose.runtime.Composable
import com.example.pdmtema6ejercicio2.modelo.Producto
import com.example.pdmtema6ejercicio2.modelo.Usuario
import com.example.pdmtema6ejercicio2.ui.viewmodel.TiendaUIState

@Composable
fun PantallaInicio(
    estado: TiendaUIState,
    onUsuarioPulsado: (usuario: Usuario) -> Unit,
    onAnyadirProducto: () -> Unit
) {
    when (estado) {
        is TiendaUIState.Cargando -> PantallaCargando()
        is TiendaUIState.Error -> PantallaError()
        is TiendaUIState.ObtenerUsuariosExito ->
            PantallaUsuarios(
                listaUsuarios = estado.listaUsuarios,
                onUsuarioPulsado = onUsuarioPulsado
            )
        is TiendaUIState.ObtenerProductosExito ->
            PantallaAnyadirProductos(
                listaProductos = estado.listaProductos,
                onAnyadirProducto = onAnyadirProducto
            )
    }
}