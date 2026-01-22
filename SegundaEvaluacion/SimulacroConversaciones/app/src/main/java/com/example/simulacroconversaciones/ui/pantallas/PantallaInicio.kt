package com.example.simulacroconversaciones.ui.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simulacroconversaciones.modelo.Usuario
import com.example.simulacroconversaciones.ui.viewmodel.SimulacroUIState

@Composable
fun PantallaInicio(
    estado: SimulacroUIState,
    cargarUsuarios: () -> Unit,
    onPantallaConversacion: (Usuario) -> Unit
) {
        when(estado){
            is SimulacroUIState.Error -> PantallaError()
            is SimulacroUIState.Cargando -> PantallaCargando()

            is SimulacroUIState.ObtenerUsuariosExito ->
                PantallaUsuarios(
                    listaUsuarios = estado.listaUsuarios,
                    onPantallaConversacion =  onPantallaConversacion
                )
            is SimulacroUIState.ActualizarUsuarioExito -> cargarUsuarios()

        }
}

@Composable
fun PantallaUsuarios(
    listaUsuarios: List<Usuario>,
    onPantallaConversacion: (Usuario) -> Unit
){
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(listaUsuarios) { usuario ->
            Column(

            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .combinedClickable(
                            onClick = { onPantallaConversacion(usuario) }
                        )
                        .fillMaxWidth()
                        .height(30.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            text = usuario.nombre,
                            fontSize = 20.sp
                        )
                        Text(
                            text = usuario.telefono,
                            fontSize = 20.sp
                        )
                    }
                }
            }
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp
            )
        }
    }
}