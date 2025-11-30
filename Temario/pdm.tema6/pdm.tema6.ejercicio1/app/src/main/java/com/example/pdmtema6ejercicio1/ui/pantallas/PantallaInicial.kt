package com.example.pdmtema6ejercicio1.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaInicio(
    onNavesPulsado: () -> Unit,
    onPersonajesPulsado: () -> Unit) {
        var opcionSeleccionada by remember { mutableStateOf("") }
        Column (modifier= Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text (
                text="STAR WARS"

            )
            HorizontalDivider(
                Modifier.height(4.dp)
            )

            Text (
                text= "¿Qué quieres listar?"
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf("Personajes", "Naves").forEach { opcion ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = (opcion == opcionSeleccionada ),
                            onClick = { opcionSeleccionada  = opcion }
                        )
                        Text(text = opcion)
                    }
                }
            }
            Button(
                onClick = {
                    when (opcionSeleccionada) {
                        "Personajes" -> onPersonajesPulsado()
                        "Naves" -> onNavesPulsado()
                    }
                },
            )
            {
                Text ("ACEPTAR")
            }

        }

    }

