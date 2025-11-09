package com.example.proyectopizzatimepart2.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopizzatimepart2.R
import com.example.proyectopizzatimepart2.modelo.Pedido
import com.example.proyectopizzatimepart2.modelo.TamanoPizza
import com.example.proyectopizzatimepart2.modelo.TipoBebida
import com.example.proyectopizzatimepart2.modelo.TipoPizza
import com.example.proyectopizzatimepart2.ui.viewmodel.RealizarPedidoViewModel

@Composable
fun PantallaResumenPago(
    viewModel: RealizarPedidoViewModel,
    onEnviarPulsado: () -> Unit,
    onAceptarPulsado: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

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
            text = stringResource(R.string.pedido) + ": " + uiState.pizza.tipoPizza + " + " + uiState.bebida,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )


        Text(
            text = stringResource(R.string.pizza) + ": " + getPrecio(cantidad = uiState.cantidadPizza, tamanoPizzaTipoBebida = uiState.pizza.tamanoPizza.toString()),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp),
            ) {
                val imageOption = when (uiState.pizza.tipoPizza) {
                    TipoPizza.romana -> R.drawable.romana
                    TipoPizza.barbacoa -> R.drawable.barbacoa
                    TipoPizza.margarita -> R.drawable.margarita
                    else -> R.drawable.person
                }
                Image(
                    painter = painterResource(imageOption),
                    contentDescription = transformarEnum(uiState.pizza.tipoPizza),
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
                    text = stringResource(R.string.cantidad) + ": " + uiState.cantidadPizza
                )
                Text(
                    text = stringResource(R.string.tama_o) + ": " + uiState.pizza.tamanoPizza
                )
            }
        }

        if (uiState.bebida != TipoBebida.sin_bebida) {
            Text(
                text = stringResource(R.string.bebida) + ": " + getPrecio(
                    uiState.cantidadBebida,
                    uiState.bebida.toString()
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
                    val imageOption = when (uiState.bebida) {
                        TipoBebida.agua -> R.drawable.agua
                        TipoBebida.cola -> R.drawable.cola
                        else -> R.drawable.person
                    }
                    Image(
                        painter = painterResource(imageOption),
                        contentDescription = uiState.bebida.toString(),
                        modifier = Modifier
                            .padding(20.dp)
                            .size(200.dp)

                    )


                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(200.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.cantidad) + ": " + uiState.cantidadBebida
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
                text = stringResource(R.string.metodo_de_pago) + ": " + uiState.pago.opcionPago,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.importe_total) + ": " + uiState.precioTotal + "€",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                16.dp,
                Alignment.CenterHorizontally
            ),

            ) {
            Button(
                onClick = {
                    viewModel.agregarPedido(pedido = Pedido(
                        idPedido = viewModel.listaPedidos.size + 1,
                        pizza = uiState.pizza,
                        cantidadPizza = uiState.cantidadPizza,
                        bebida = uiState.bebida,
                        cantidadBebida = uiState.cantidadBebida,
                        precioTotal = uiState.precioTotal,
                        pago = uiState.pago
                    ))
                    onEnviarPulsado()
                    viewModel.reiniciarPedido()
                }

            ) {
                Text(
                    text = stringResource(R.string.enviar)
                )
            }
            Button(
                onClick = {
                    viewModel.agregarPedido(pedido = Pedido(
                        idPedido = viewModel.listaPedidos.size + 1,
                        pizza = uiState.pizza,
                        cantidadPizza = uiState.cantidadPizza,
                        bebida = uiState.bebida,
                        cantidadBebida = uiState.cantidadBebida,
                        precioTotal = uiState.precioTotal,
                        pago = uiState.pago
                    ))
                    onAceptarPulsado()
                    viewModel.reiniciarPedido()
                }
            ) {
                Text(
                    text = stringResource(R.string.aceptar)
                )
            }
        }


    }
}
@Composable
fun getPrecio(cantidad: Int, tamanoPizzaTipoBebida: String): Double{
    var precioPizzaBebida: Double = 0.0
    when(tamanoPizzaTipoBebida){
        "pequena" -> precioPizzaBebida = 4.95
        "mediana" -> precioPizzaBebida = 6.95
        "grande" -> precioPizzaBebida = 10.95
        "agua" -> precioPizzaBebida = 2.0
        "cola" -> precioPizzaBebida = 2.5
        "sin_bebida" -> precioPizzaBebida = 0.0
    }


    val precioTotal: Double = (precioPizzaBebida*cantidad)
    return precioTotal
}