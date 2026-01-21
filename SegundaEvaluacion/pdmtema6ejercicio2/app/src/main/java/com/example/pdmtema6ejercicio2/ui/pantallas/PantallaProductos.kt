package com.example.pdmtema6ejercicio2.ui.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.pdmtema6ejercicio2.modelo.Producto
import com.example.pdmtema6ejercicio2.ui.viewmodel.ProductosUIState

@Composable
fun PantallaProductos(
    estado: ProductosUIState,
    onInsertarProducto: () -> Unit,
    onModificarProducto: (Producto) -> Unit,
    onObtenerProductos: () -> Unit
){
    when (estado){
        is ProductosUIState.Cargando -> PantallaCargando()
        is ProductosUIState.Error -> PantallaError()
        is ProductosUIState.ObtenerExito -> {
            LazyColumn {
                item {
                    Button(
                        onClick = { onInsertarProducto() }
                    ) {
                        Text(
                            text = "Añadir Producto"
                        )
                    }
                }

                items(estado.listaProductos){ producto ->
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Column {
                            Text(
                                text = "Producto: ${producto.nombre}"
                            )
                            Text(
                                text = "Precio: ${producto.precio}"
                            )
                        }
                        Button(
                            onClick = { onModificarProducto(producto) }
                        ) {
                            Text(
                                text = "Modificar"
                            )
                        }
                    }
                }
            }
        }
        is ProductosUIState.InsertarExito -> onObtenerProductos()
        is ProductosUIState.ActualizarExito -> onObtenerProductos()
    }

}