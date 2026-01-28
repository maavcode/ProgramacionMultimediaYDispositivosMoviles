package com.example.plantillanavigationdrawer.ui.pantallas


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantillanavigationdrawer.modelo.Reserva
import com.example.plantillanavigationdrawer.modelo.Usuario

@Composable
fun PantallaListarReservas(
    usuario: Usuario,
    onEliminarReserva: (Usuario) -> Unit
){
    LazyColumn(

    ) {
        item {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Reservas de ${usuario.nombre} ${usuario.apellido1} ${usuario.apellido2}",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        items(usuario.reservas){ reserva ->
            ReservaCard(
                reserva = reserva,
                onEliminarReserva = onEliminarReserva,
                usuarioSeleccionado = usuario
            )
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ReservaCard(
    reserva: Reserva,
    onEliminarReserva: (Usuario) -> Unit,
    usuarioSeleccionado: Usuario
) {

    var expanded by remember { mutableStateOf(false) }
    var showAlert by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .border(
                width = 2.dp,
                color = Color(0xFF2575FC),
                shape = RoundedCornerShape(16.dp)
            )
            .background(Color.White, RoundedCornerShape(16.dp))
            .combinedClickable(
                onClick = { expanded = !expanded },
                onLongClick = { showAlert = true }
            )
            .padding(16.dp)
    ) {

        Column (

        ){

            Text(
                text = "📅 ${reserva.fechaReserva}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2575FC)
            )



            if (expanded) {
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "⏰ Hora: ${reserva.horaReserva}",
                        fontSize = 16.sp,
                        color = Color.DarkGray
                    )

                    Text(
                        text = "👥 Personas: ${reserva.numPersonas}",
                        fontSize = 16.sp,
                        color = Color.DarkGray
                    )
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
                        val usuarioActualizado =
                            usuarioSeleccionado.copy(
                                reservas = usuarioSeleccionado.reservas.filter { it != reserva } )
                        onEliminarReserva(usuarioActualizado)
                        showAlert = false
                    }
                ) {
                    Text("Eliminar")
                }
            }
        )
    }
}
