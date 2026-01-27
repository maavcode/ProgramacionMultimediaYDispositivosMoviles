package com.example.simulacroconversaciones.ui.pantallas

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.simulacroconversaciones.modelo.Mensaje
import com.example.simulacroconversaciones.modelo.Usuario

@Composable
fun PantallaConversacion(
    usuario: Usuario,
    onEscribirMensaje: (Mensaje) -> Unit
){
    var mensajeEscrito by remember { mutableStateOf("") }

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(usuario.mensajes){ mensaje ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(30.dp)
            ){
                if (!mensaje.enviado){
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = mensaje.mensaje,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Right,
                    )
                } else {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = mensaje.mensaje,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Left
                    )
                }
            }

            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp
            )
        }
        item{
            Row(

            ) {
                OutlinedTextField(
                    value = mensajeEscrito,
                    onValueChange = {
                        mensajeEscrito = it
                    },
                    label = {
                        Text(
                            text = "Escribe un mensaje"
                        )
                    }
                )

                Button(
                    onClick = {
                        onEscribirMensaje(Mensaje(mensaje=mensajeEscrito, enviado = true))
                        mensajeEscrito = ""
                    }
                ) {
                    Text(
                        text = "Enviar"
                    )
                }
            }

        }
    }

}