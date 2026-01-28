package com.example.plantillanavigationdrawer.ui.pantallas

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantillanavigationdrawer.R
import com.example.plantillanavigationdrawer.modelo.Reserva
import com.example.plantillanavigationdrawer.modelo.Usuario
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaInsertarReserva(
    usuarioSeleccionado: Usuario,
    onAceptar: (Usuario) -> Unit
){
    var numPersonas: String by remember { mutableStateOf("") }
    var fechaElegida: Long? by remember { mutableStateOf(null) }
    var horaElegida: TimePickerState? by remember { mutableStateOf(null) }

    var fechaPulsado by remember { mutableStateOf(false) }
    var horaPulsado by remember { mutableStateOf(false) }

    var fecha by remember {mutableStateOf("")}
    var hora by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Añadir Reserva",
            modifier = Modifier
                .padding(bottom = 24.dp),
            fontSize = 24.sp
        )
        OutlinedTextField(
            value = numPersonas,
            onValueChange = { numPersonas = it },
            label = { Text("Numero de personas") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))
        // Seleccion de fecha
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { fechaPulsado = true },
            shape = RoundedCornerShape(12.dp),
        ) {
            Column(

            ) {
                Text(
                    text = "Fecha",
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(6.dp))
                if (fechaElegida != null) {
                    val date = Date(fechaElegida!!)
                    val formattedDate = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(date)
                    fecha = formattedDate
                    Text(
                        text = stringResource(R.string.fecha_seleccionada) + ": $fecha")
                }
                else {
                    Text(text = stringResource(R.string.ninguna_fecha_seleccinada))
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { horaPulsado = true },
            shape = RoundedCornerShape(12.dp),
        ) {
            Column(

            ) {
                Text(
                    text = "Hora",
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(6.dp))
                if (horaElegida != null) {
                    val cal = Calendar.getInstance()
                    cal.set(Calendar.HOUR_OF_DAY, horaElegida!!.hour)
                    cal.set(Calendar.MINUTE, horaElegida!!.minute)
                    hora = String.format("%02d:%02d",
                        cal.get(Calendar.HOUR_OF_DAY),
                        cal.get(Calendar.MINUTE)
                    )
                    Text(
                        text = stringResource(R.string.hora_seleccionada) + ": ${hora}"
                    )
                }
                else {
                    Text(text = stringResource(R.string.ninguna_hora_seleccionada))
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = {},
                modifier = Modifier.weight(1f)
            ) {
                Text("Cancelar")
            }
            OutlinedButton(
                onClick = {
                    val nuevaReserva =
                        Reserva(
                            numPersonas = numPersonas,
                            fechaReserva = fecha,
                            horaReserva = hora
                        )
                    val nuevoUsuario = usuarioSeleccionado.copy(
                        reservas = usuarioSeleccionado.reservas + nuevaReserva
                    )
                    onAceptar(
                        nuevoUsuario
                    )
                },
                modifier = Modifier.weight(1f),
                enabled = hora.isNotBlank() && fecha.isNotBlank() && numPersonas.isNotBlank()
            ) {
                Text("Aceptar")
            }
        }
    }
    if(fechaPulsado){
        DatePickerMostrado(
            onConfirm = { fecha ->
                fechaElegida = fecha
                fechaPulsado = false
            },
            onDismiss = { fechaPulsado = false })
    }

    if(horaPulsado){
        TimePickerMostrado(
            onConfirm = { hora ->
                horaElegida = hora
                horaPulsado = false
            },
            onDismiss = { horaPulsado = false }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerMostrado(
    onConfirm: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onConfirm(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text(stringResource(R.string.aceptar))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.cancelar))
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerMostrado(
    onConfirm: (TimePickerState) -> Unit,
    onDismiss: () -> Unit
) {
    val horaActual = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = horaActual.get(Calendar.HOUR_OF_DAY),
        initialMinute = horaActual.get(Calendar.MINUTE),
        is24Hour = true
    )
    var mostrarDialogo by remember { mutableStateOf(true) }

    if (mostrarDialogo) {
        AlertDialog(
            text = {
                Column {
                    TimeInput(state = timePickerState)
                    //TimePicker(state = timePickerState)
                }
            },
            onDismissRequest = {
                onDismiss()
                mostrarDialogo = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirm(timePickerState)
                        mostrarDialogo = false
                    }
                ) {
                    Text(text = stringResource(R.string.aceptar))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        onDismiss()
                        mostrarDialogo = false
                    }
                ) {
                    Text(text = stringResource(R.string.cancelar))
                }
            }
        )
    }
}