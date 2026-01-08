package com.example.pdmtema6ejercicio2.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pdmtema6ejercicio2.modelo.Producto
import com.example.pdmtema6ejercicio2.ui.viewmodel.TiendaUIState

@Composable
fun PantallaAnyadirProductos(
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