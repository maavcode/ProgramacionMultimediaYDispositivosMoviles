package com.example.proyectopizzatime

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectopizzatime.ui.theme.AppTheme
import com.example.proyectopizzatime.datos.Datos

@Composable
fun PantallaResumenPago(
    modifier: Modifier = Modifier,
) {
    // Pago tramitado
    val pedidoPrueba = Datos().cargarPersonas().get(0).listaPedidos.get(0)
    val pago = pedidoPrueba.pago

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),

    ) {

        Text(
            text = stringResource(R.string.resumen_del_pago),
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
            text = stringResource(R.string.pedido)+ ": " + pedidoPrueba.tipoPizza + " + " + pedidoPrueba.tipoBebida,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )


        Text(
            text = stringResource(R.string.pizza) + ": " + getPrecio(pedidoPrueba.cantidadPizza, pedidoPrueba.tamanoPizza),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp),
            ) {
                val imageOption = when (pedidoPrueba.tipoPizza) {
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

            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.cantidad) + ": " + pedidoPrueba.cantidadPizza
                )
                Text(
                    text = stringResource(R.string.tama_o) + ": " + pedidoPrueba.tamanoPizza
                )
            }
        }

        if (pedidoPrueba.tipoBebida != stringResource(R.string.sin_bebida)) {
            Text(
                text = stringResource(R.string.bebida) + ": " + getPrecio(
                    pedidoPrueba.cantidadBebida,
                    pedidoPrueba.tipoBebida
                ),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp

            )
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(200.dp),
                ) {
                    val imageOption = when (pedidoPrueba.tipoBebida) {
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


            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.metodo_de_pago) + ": " + pago.opcionPago,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.importe_total) + ": " + pago.importe + "€",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

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
                    text = stringResource(R.string.enviar)
                )
            }
            Button(
                onClick = {}
            ) {
                Text(
                    text = stringResource(R.string.aceptar)
                )
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun PantallaResumenPagoPreview() {
    AppTheme {
        PantallaResumenPago()
    }
}