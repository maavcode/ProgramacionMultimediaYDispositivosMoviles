package com.example.pdmtema6ejercicio2.ui.pantallas


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.pdmtema6ejercicio2.modelo.Producto

@Composable
fun PantallaInsertarProducto(
    onInsertarProducto: (Producto) -> Unit
){

    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }

    Column(

    ) {
        Spacer(Modifier.height(16.dp))
        TextField(
            value = nombre,
            label = {Text(text = "Nombre del producto")},
            onValueChange = {nombre = it}
        )
        Spacer(Modifier.height(16.dp))
        TextField(
            value = precio,
            label = {Text(text = "Precio")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {precio = it}
        )

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                val precioFinal = precio.toString()
                val producto = Producto("", nombre, precioFinal)
                onInsertarProducto(producto)
            }
        ) {
            Text(text = "Guardar producto")
        }
    }

}