package com.example.pdmtema6ejercicio2.ui.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pdmtema6ejercicio2.modelo.Usuario
import com.example.pdmtema6ejercicio2.ui.viewmodel.TiendaUIState

@Composable
fun PantallaInicio(
    estado: TiendaUIState,
    cargarUsuarios: () -> Unit,
    onUsuarioPulsado: () -> Unit,
    actualizarUsuarioSeleccionado: (Int) -> Unit
) {
    // Cargar usuarios solo una vez
    LaunchedEffect(Unit) {
        cargarUsuarios()
    }

    when (estado) {

        is TiendaUIState.Cargando ->
            PantallaCargando(modifier = Modifier.fillMaxSize())

        is TiendaUIState.ObtenerUsuariosExito ->
            PantallaExitoUsuarios(
                usuarios = estado.usuarios,
                onUsuarioPulsado = onUsuarioPulsado,
                actualizarUsuarioSeleccionado = actualizarUsuarioSeleccionado
            )

        else -> PantallaError(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun PantallaExitoUsuarios(
    usuarios: List<Usuario>,
    onUsuarioPulsado: () -> Unit,
    actualizarUsuarioSeleccionado: (Int) -> Unit
){
    LazyColumn {
        items(usuarios) { usuario ->
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Usuario: ${usuario.nombre}")

                Button(
                    onClick = {
                        actualizarUsuarioSeleccionado(usuario.id)
                        onUsuarioPulsado()
                    }
                ) {
                    Text(text = "Entrar")
                }
            }
        }
    }
}
