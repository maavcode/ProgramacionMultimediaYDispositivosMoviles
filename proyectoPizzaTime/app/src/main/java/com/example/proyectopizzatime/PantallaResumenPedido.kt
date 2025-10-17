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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.proyectopizzatime.datos.Datos

@Composable
fun PantallaResumenPepido(
    modifier: Modifier = Modifier
){
    val pedidoPrueba = Datos().cargarPedidos().get(0)
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ){
        Text(
            text = "Resumen del pedido",
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
            text = "Pedido: " + pedidoPrueba.tipoPizza + " + " + pedidoPrueba.tipoBebida,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )


        Text(
            text = "Pizza: " + getPrecio(pedidoPrueba.cantidadPizza, pedidoPrueba.tamanoPizza),
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
                    "Romana" -> R.drawable.romana
                    "Barbacoa" -> R.drawable.barbacoa
                    "Margarita" -> R.drawable.margarita
                    "Agua" -> R.drawable.person
                    "Refresco" -> R.drawable.person
                    "Sin bebida" -> R.drawable.person
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
                    text = "Cantidad: " + pedidoPrueba.cantidadPizza
                )
                Text(
                    text = "Tamaño: " + pedidoPrueba.tamanoPizza
                )
            }
        }

        if (pedidoPrueba.tipoBebida != "Sin bebida"){
            Text(
                text = "Bebida: " + getPrecio(pedidoPrueba.cantidadBebida, pedidoPrueba.tipoBebida),
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
                        "Agua" -> R.drawable.agua
                        "Cola" -> R.drawable.cola
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
                        text = "Cantidad: " + pedidoPrueba.cantidadBebida
                    )
                }
            }

        }



        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Precio Total: " + pedidoPrueba.precioTotal,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )




    }
}

fun getPrecio(cantidad: Int, tamanoPizzaTipoBebida: String): Double{
    var precioPizzaBebida: Double = 0.0
    when(tamanoPizzaTipoBebida){
        "Pequeña" -> precioPizzaBebida = 4.95
        "Mediana" -> precioPizzaBebida = 6.95
        "Grande" -> precioPizzaBebida = 10.95
        "Agua" -> precioPizzaBebida = 2.0
        "Cola" -> precioPizzaBebida = 2.5
        "Sin bebida" -> precioPizzaBebida = 0.0
    }


    val precioTotal: Double = (precioPizzaBebida*cantidad)
    return precioTotal
}

@Preview(showBackground = true)
@Composable
fun PantallaResumenPedidoPreview() {
    AppTheme {
        PantallaResumenPepido()
    }
}
