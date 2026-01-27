package com.example.simulacroconversaciones.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simulacroconversaciones.modelo.Mensaje
import com.example.simulacroconversaciones.modelo.Usuario

@Composable
fun PantallaInsertarUsuario(
    onInsertarUsuario: (Usuario) -> Unit
){
    var nombre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(

    ) {
        Spacer(Modifier.height(16.dp))
        TextField(
            value = nombre,
            label = {Text(text = "Nombre del usuario")},
            onValueChange = {
                nombre = it
            }
        )
        Spacer(Modifier.height(16.dp))
        TextField(
            value = telefono,
            label = {Text(text = "Movil del usuario")},
            onValueChange = {
                telefono = it
            }
        )

        Row {
            TextField(
                value = mensaje,
                label = {Text(text = "Escribe un mensaje")},
                onValueChange = {
                    mensaje = it
                }
            )
            Button(
                onClick = {
                    onInsertarUsuario(
                        Usuario(
                            nombre = nombre,
                            telefono = telefono,
                            mensajes = listOf(
                                Mensaje(
                                    mensaje = mensaje,
                                    enviado = true)
                            )
                        )
                    )
                }
            ) {
                Text(
                    text = "Enviado"
                )
            }
        }

    }
}