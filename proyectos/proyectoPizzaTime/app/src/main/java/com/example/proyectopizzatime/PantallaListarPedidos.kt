package com.example.proyectopizzatime

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopizzatime.ui.theme.AppTheme
import com.example.proyectopizzatime.datos.Datos
import com.example.proyectopizzatime.modelos.Pedido


@Composable
/*fun PantallaListarPedidos(
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

        listaPedidos.forEach { pedidoActual ->
            TarjetaPedido(
                pedido = pedidoActual,
                modifier = Modifier
            )
        }
    }
}*/ // No me dejaba scrollear
fun PantallaListarPedidos(
    modifier: Modifier = Modifier,
) {
    val listaPedidos = Datos().cargarPersonas().get(0).listaPedidos

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.lista_de_pedidos),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
            )

            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp
            )
        }

        items(listaPedidos) { pedidoActual ->
            TarjetaPedido(
                pedido = pedidoActual,
                modifier = Modifier
            )
        }
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
                text = stringResource(R.string.pedido) + ": " + pedido.tipoPizza + " + " + pedido.tipoBebida
            )
            Button(
                onClick = {}
            ) {
                Text(
                    text = stringResource(R.string.resumen_del_pedido)
                )
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PantallaListarPedidosPreview() {
    AppTheme {
        PantallaListarPedidos()
    }
}