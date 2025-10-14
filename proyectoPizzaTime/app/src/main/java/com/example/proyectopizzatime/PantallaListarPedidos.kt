package com.example.proyectopizzatime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopizzatime.datos.Datos
import com.example.proyectopizzatime.modelos.Pedido
import com.example.proyectopizzatime.ui.theme.ProyectoPizzaTimeTheme


@Composable
fun PantallaListarPedidos(
    modifier: Modifier = Modifier,
){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            text = "Lista de Pedidos",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        HorizontalDivider(
            color = Color.Gray,
            thickness = 1.dp
        )

        val listaPedidos = Datos().cargarPedidos();
        val pedidoPrueba: Pedido = listaPedidos[0];
        TarjetaPedido(
            pedido = pedidoPrueba,
            modifier = Modifier
        )
        TarjetaPedido(
            pedido = pedidoPrueba,
            modifier = Modifier
        )
        TarjetaPedido(
            pedido = pedidoPrueba,
            modifier = Modifier
        )
        TarjetaPedido(
            pedido = pedidoPrueba,
            modifier = Modifier
        )
    }
}

@Composable
fun TarjetaPedido (
    pedido: Pedido,
    modifier: Modifier
){
    Card (
        modifier = Modifier
            .width(350.dp)
    ){
        Column (
            modifier = Modifier
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Text(
                text = "Pedido: " + pedido.pizza + " + " + pedido.bebida
            )
            Button(
                onClick = {}
            ) {
                Text(
                    text = "Resumen del pedido"
                )
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PantallaListarPedidosPreview() {
    ProyectoPizzaTimeTheme {
        PantallaListarPedidos()
    }
}