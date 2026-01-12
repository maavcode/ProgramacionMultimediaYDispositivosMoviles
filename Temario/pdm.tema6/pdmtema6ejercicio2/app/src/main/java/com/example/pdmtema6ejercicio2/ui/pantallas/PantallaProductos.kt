package com.example.pdmtema6ejercicio2.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.pdmtema6ejercicio2.modelo.Producto

@Composable
fun PantallaProductos (
    listaProductos: List<Producto>
){
    LazyColumn {
        items(listaProductos){ producto ->
            Row {
                Column {
                    Text(
                        text = "Producto: ${producto.nombre}"
                    )
                    Text(
                        text = "Precio: ${producto.precio}"
                    )
                }
            }
        }
    }
}