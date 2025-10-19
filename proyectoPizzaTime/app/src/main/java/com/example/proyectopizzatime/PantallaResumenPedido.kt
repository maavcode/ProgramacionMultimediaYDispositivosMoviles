package com.example.proyectopizzatime

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.proyectopizzatime.datos.Datos

@Composable
fun PantallaResumenPedido(
    modifier: Modifier = Modifier
){
    val pedidoPrueba = Datos().cargarPersonas().get(0).listaPedidos.get(0)
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ){
        Text(
            text = stringResource(R.string.resumen_del_pedido),
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

        Text(
            text = stringResource(R.string.pedido) + ": " + pedidoPrueba.tipoPizza + " + " + pedidoPrueba.tipoBebida,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )


        Text(
            text = stringResource(R.string.pizza) + ": " + getPrecio(pedidoPrueba.cantidadPizza, pedidoPrueba.tamanoPizza),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Row {
            Column (
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp),
            ){
                val imageOption = when(pedidoPrueba.tipoPizza) {
                    stringResource(R.string.romana) -> R.drawable.romana
                    stringResource(R.string.barbacoa) -> R.drawable.barbacoa
                    stringResource(R.string.margarita) -> R.drawable.margarita
                    stringResource(R.string.agua) -> R.drawable.agua
                    stringResource(R.string.cola) -> R.drawable.cola
                    else -> R.drawable.person
                }
                Image(
                    painter = painterResource(imageOption),
                    contentDescription = pedidoPrueba.tipoPizza,
                    modifier = Modifier
                        .padding(20.dp)
                        .size(200.dp)
                )


            }

            Column (
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = stringResource(R.string.cantidad) + ": " + pedidoPrueba.cantidadPizza
                )
                Text(
                    text = stringResource(R.string.tama_o) + ": " + pedidoPrueba.tamanoPizza
                )
            }
        }

        if (pedidoPrueba.tipoBebida != stringResource(R.string.sin_bebida)){
            Text(
                text = stringResource(R.string.bebida) + ": " + getPrecio(pedidoPrueba.cantidadBebida, pedidoPrueba.tipoBebida),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp

            )
            Row {
                Column (
                    modifier = Modifier
                        .weight(1f)
                        .height(200.dp),
                ){
                    val imageOption = when(pedidoPrueba.tipoBebida) {
                        stringResource(R.string.agua) -> R.drawable.agua
                        stringResource(R.string.cola) -> R.drawable.cola
                        else -> R.drawable.person
                    }
                    Image(
                        painter = painterResource(imageOption),
                        contentDescription = pedidoPrueba.tipoBebida,
                        modifier = Modifier
                            .padding(20.dp)
                            .size(200.dp)

                    )


                }

                Column (
                    modifier = Modifier
                        .weight(1f)
                        .height(200.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = stringResource(R.string.cantidad) + ": " + pedidoPrueba.cantidadBebida
                    )
                }
            }

        }



        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.precio_total) + ": " + pedidoPrueba.precioTotal,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                16.dp,
                Alignment.CenterHorizontally
            ),

            ){
            Button(
                onClick = {}
            ) {
                Text(
                    text = stringResource(R.string.cancelar)
                )
            }
            Button(
                onClick = {}
            ) {
                Text(
                    text = stringResource(R.string.pagar)
                )
            }
        }


    }
}

@Composable
fun getPrecio(cantidad: Int, tamanoPizzaTipoBebida: String): Double{
    var precioPizzaBebida: Double = 0.0
    when(tamanoPizzaTipoBebida){
        stringResource(R.string.peque_a) -> precioPizzaBebida = 4.95
        stringResource(R.string.mediana) -> precioPizzaBebida = 6.95
        stringResource(R.string.grande) -> precioPizzaBebida = 10.95
        stringResource(R.string.agua) -> precioPizzaBebida = 2.0
        stringResource(R.string.cola) -> precioPizzaBebida = 2.5
        stringResource(R.string.sin_bebida) -> precioPizzaBebida = 0.0
    }


    val precioTotal: Double = (precioPizzaBebida*cantidad)
    return precioTotal
}

@Preview(showBackground = true)
@Composable
fun PantallaResumenPedidoPreview() {
    AppTheme {
        PantallaResumenPedido()
    }
}
