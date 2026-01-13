package com.example.pdmtema6ejercicio2.ui.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.pdmtema6ejercicio2.modelo.Usuario

@Composable
fun PantallaUsuarios(
    listaUsuarios: List<Usuario>,
    onUsuarioPulsado: (usuario: Usuario) -> Unit
){
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(listaUsuarios){ usuario ->
            Button(
                onClick = {onUsuarioPulsado(usuario)}
            ) {
                Text(
                    text = usuario.nombre
                )
            }
        }
    }
}
