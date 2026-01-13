package com.example.pdmtema6ejercicio2.ui.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.pdmtema6ejercicio2.modelo.Usuario
import com.example.pdmtema6ejercicio2.ui.viewmodel.TiendaUIState

@Composable
fun PantallaUsuario(
    usuario: Usuario,
    onListarPulsado: () -> Unit,
    onAnyadirProductos: () -> Unit
){
    Column (
        modifier = Modifier.fillMaxWidth(),
    ){
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Bienvenido ${usuario.nombre}",
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                onClick = {onAnyadirProductos()}
            ) {
                Text(
                    text = "Añadir productos"
                )
            }
            Button(
                onClick = {onListarPulsado()}
            ) {
                Text(
                    text = "Listar productos en propiedad"
                )
            }
        }

    }

}
