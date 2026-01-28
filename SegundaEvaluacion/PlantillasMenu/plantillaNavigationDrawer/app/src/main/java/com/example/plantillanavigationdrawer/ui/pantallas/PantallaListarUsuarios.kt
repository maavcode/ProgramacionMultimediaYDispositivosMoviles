package com.example.plantillanavigationdrawer.ui.pantallas

import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantillanavigationdrawer.modelo.Usuario

@Composable
fun PantallaListarUsuarios(
    listaUsuarios: List<Usuario>,
    onListarReservas: (Usuario) -> Unit,
    onEliminarUsuario: (Usuario) -> Unit
){
    var showAlert by remember { mutableStateOf(false) }
    var usuarioSeleccionado: Usuario by remember { mutableStateOf(Usuario("","","","",listOf())) }

    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        items(listaUsuarios){ usuario ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                    .width(300.dp)
                    .height(100.dp)
                    .combinedClickable(
                        onClick = {onListarReservas(usuario)},
                        onLongClick = {
                            usuarioSeleccionado = usuario
                            showAlert = true
                        }
                    )
                    .border( width = 3.dp,
                        color = Color(0xFF2575FC),
                        shape = RectangleShape
                    )
                )
                { Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Usuario: ${usuario}",
                        tint = Color(0xFF2575FC),
                        modifier = Modifier.size(40.dp) )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = usuario.nombre,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray )
                }
            }
            }
        }
    }

    if (showAlert) {
        AlertDialog(
            onDismissRequest = { showAlert = false },
            title = { Text("Eliminar Usuario") },
            text = {
                Text(
                    "Eliminar?"
                )
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showAlert = false
                    }
                ) {
                    Text("Cerrar")
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onEliminarUsuario(usuarioSeleccionado)
                        showAlert = false
                    }
                ) {
                    Text("Eliminar")
                }
            }
        )
    }
}