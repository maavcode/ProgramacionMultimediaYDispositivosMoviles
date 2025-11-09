package com.example.proyectopizzatimepart2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
fun PantallaResumenPedido(
    viewModel: RealizarPedidoViewModel,
    onCancelarPulsado: () -> Unit,
    onPagarPulsado: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp), modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.resumen_del_pedido),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )

        HorizontalDivider(color = Color.Gray, thickness = 1.dp)

        // --- Pizza ---
        Text(
            text = stringResource(R.string.pedido) + ": " + uiState.pizza.tipoPizza + " + " + uiState.bebida,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Text(
            text = "${stringResource(R.string.pizza)}: ${"%.2f".format(uiState.precioTotal)}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Row {
            // Imagen pizza
            val imagePizza = when (uiState.pizza.tipoPizza) {
                TipoPizza.romana -> R.drawable.romana
                TipoPizza.barbacoa -> R.drawable.barbacoa
                TipoPizza.margarita -> R.drawable.margarita
                else -> R.drawable.person
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(imagePizza),
                    contentDescription = transformarEnum(uiState.pizza.tipoPizza),
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
                Text(stringResource(R.string.cantidad) + ": " + uiState.cantidadPizza)
                Text(stringResource(R.string.tama_o) + ": " + transformarEnum(uiState.pizza.tamanoPizza))
            }
        }

        // --- Bebida ---
        if (uiState.bebida != TipoBebida.sin_bebida) {
            Text(
                text = stringResource(R.string.bebida),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            val imageBebida = when (uiState.bebida) {
                TipoBebida.agua -> R.drawable.agua
                TipoBebida.cola -> R.drawable.cola
                else -> R.drawable.person
            }

            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .height(200.dp)
                ) {
                    Image(
                        painter = painterResource(imageBebida),
                        contentDescription = transformarEnum(uiState.bebida),
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
                    Text(stringResource(R.string.cantidad) + ": " + uiState.cantidadBebida)
                }
            }
        }

        Text(
            text = "${stringResource(R.string.precio_total)}: ${"%.2f".format(uiState.precioTotal)}",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
        ) {
            Button(onClick = onCancelarPulsado) {
                Text(stringResource(R.string.cancelar))
            }
            Button(onClick = onPagarPulsado) {
                Text(stringResource(R.string.pagar))
            }
        }
    }
}
