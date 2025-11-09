package com.example.proyectopizzatimepart2.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.proyectopizzatimepart2.R
import com.example.proyectopizzatimepart2.modelo.Pizza
import com.example.proyectopizzatimepart2.modelo.RealizarPedidoUIState
import com.example.proyectopizzatimepart2.modelo.SubTipoPizza
import com.example.proyectopizzatimepart2.modelo.TamanoPizza
import com.example.proyectopizzatimepart2.modelo.TipoBebida
import com.example.proyectopizzatimepart2.modelo.TipoPizza
import com.example.proyectopizzatimepart2.ui.viewmodel.RealizarPedidoViewModel

@Composable
fun PantallaRealizarPedido(
    viewModel: RealizarPedidoViewModel,
    onCancelarPulsado: () -> Unit,
    onAceptarPulsado: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp), modifier = modifier
    ) {

        Text(
            text = stringResource(R.string.realizar_un_pedido),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        HorizontalDivider(
            color = Color.Gray, thickness = 1.dp
        )



        Text(
            modifier = Modifier.fillMaxWidth(),
            text = " ${stringResource(R.string.total)} ${"%.2f".format(uiState.precioTotal)}",
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min) // para que la altura se ajuste al contenido
        ) {


            // Columna Izquierda
            Column(
                modifier = Modifier
                    .weight(1f)
                    .selectableGroup()
            ) {
                Text(
                    text = stringResource(R.string.pizza),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                val radioOptions = listOf(
                    stringResource(R.string.romana),
                    stringResource(R.string.barbacoa),
                    stringResource(R.string.margarita)
                )
                radioOptions.forEach { radioOption ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    ) {
                        val enumSeleccionado = transformarstringAEnumTipoPizza(radioOption)
                        RadioButton(
                            selected = (radioOption == transformarEnum(uiState.pizza.tipoPizza)),
                            onClick = {
                                viewModel.actualizarPizza(
                                    uiState.pizza.copy(tipoPizza = enumSeleccionado)
                                )
                            })

                        Text(
                            text = radioOption, modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }


            }

            // Columna Derecha
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),

                ) {
                if (uiState.pizza.tipoPizza != TipoPizza.ninguno) {
                    Column(

                    ) {
                        Text(
                            text = stringResource(R.string.opciones_de_pizza), fontSize = 20.sp
                        )
                        OpcionesPizza(
                            tipoPizza = transformarEnum(uiState.pizza.tipoPizza),
                            uiState = uiState,
                            viewModel = viewModel
                        )
                    }


                }
            }
        }
        if (uiState.pizza.tipoPizza != TipoPizza.ninguno) {
            Row(
                modifier = Modifier
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        text = stringResource(R.string.cantidad)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        if (uiState.cantidadPizza > 0) {
                            Button(
                                onClick = {
                                    viewModel.actualizarCantidadPizza(uiState.cantidadPizza - 1)
                                }) {
                                Text("-")
                            }
                        }

                        Text(
                            text = uiState.cantidadPizza.toString()
                        )

                        Button(
                            onClick = { viewModel.actualizarCantidadPizza(uiState.cantidadPizza + 1) },
                        ) {
                            Text("+")
                        }
                    }


                }
            }
            HorizontalDivider(
                color = Color.Gray, thickness = 1.dp
            )



            if (uiState.pizza.tipoPizza != TipoPizza.ninguno) {

                Text(
                    text = stringResource(R.string.tama_o_de_la_pizza),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                val opciones = listOf(
                    stringResource(R.string.peque_a),
                    stringResource(R.string.mediana),
                    stringResource(R.string.grande)
                )

                opciones.forEach { opcion ->

                    // Convertimos directamente a enum usando when
                    val tamanoEnum = when (opcion) {
                        stringResource(R.string.peque_a) -> TamanoPizza.pequena
                        stringResource(R.string.mediana) -> TamanoPizza.mediana
                        stringResource(R.string.grande) -> TamanoPizza.grande
                        else -> TamanoPizza.mediana
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .clickable {
                                viewModel.actualizarPizza(uiState.pizza.copy(tamanoPizza = tamanoEnum))
                            }) {
                        Checkbox(
                            checked = (uiState.pizza.tamanoPizza == tamanoEnum), onCheckedChange = {
                                viewModel.actualizarPizza(uiState.pizza.copy(tamanoPizza = tamanoEnum))
                            })
                        Text(
                            text = opcion, modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }



                HorizontalDivider(
                    color = Color.Gray, thickness = 1.dp
                )

            }



            Text(
                text = stringResource(R.string.bebida),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val listaBebidas = listOf(
                    stringResource(R.string.agua),
                    stringResource(R.string.cola),
                    stringResource(R.string.sin_bebida)
                )

                listaBebidas.forEach { bebida ->
                    // Convertimos el string a enum
                    val bebidaEnum = when (bebida) {
                        stringResource(R.string.agua) -> TipoBebida.agua
                        stringResource(R.string.cola) -> TipoBebida.cola
                        stringResource(R.string.sin_bebida) -> TipoBebida.sin_bebida
                        else -> TipoBebida.sin_bebida
                    }

                    Button(
                        onClick = { viewModel.actualizarBebida(bebidaEnum) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (uiState.bebida == bebidaEnum) Color(0xFF4CAF50) else Color.Gray
                        ),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(text = bebida)
                    }
                }

            }
            if (uiState.bebida != TipoBebida.sin_bebida) {
                Row(
                    modifier = Modifier
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Text(
                            text = stringResource(R.string.cantidad)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            if (uiState.cantidadBebida > 0) {
                                Button(
                                    onClick = {
                                        viewModel.actualizarCantidadBebida(
                                            uiState.cantidadBebida - 1
                                        )
                                    },
                                ) {
                                    Text("-")
                                }
                            }

                            Text(
                                text = uiState.cantidadBebida.toString()
                            )

                            Button(
                                onClick = { viewModel.actualizarCantidadBebida(uiState.cantidadBebida + 1) },
                            ) {
                                Text("+")
                            }
                        }
                    }
                }
            }







            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Button(onClick = onCancelarPulsado) {
                        Text(stringResource(R.string.cancelar))
                    }
                    Button(onClick = onAceptarPulsado) {
                        Text(stringResource(R.string.aceptar))
                    }
                }
            }


        }
    }

}

@Composable
fun OpcionesPizza(
    modifier: Modifier = Modifier,
    tipoPizza: String,
    uiState: RealizarPedidoUIState,
    viewModel: RealizarPedidoViewModel
) {
    // Segun el tipo de pizza de doy unas opciones u otras
    val radioOptions: List<String> = when (tipoPizza) {
        stringResource(R.string.romana) -> listOf(
            stringResource(R.string.con_champi_ones),
            stringResource(R.string.sin_champi_ones)
        )

        stringResource(R.string.barbacoa) -> listOf(
            stringResource(R.string.carne_de_cerdo),
            stringResource(R.string.carne_de_pollo),
            stringResource(R.string.carne_de_ternera)
        )

        stringResource(R.string.margarita) -> listOf(
            stringResource(R.string.con_pi_a),
            stringResource(R.string.sin_pi_a),
            stringResource(R.string.vegana)
        )

        else -> emptyList()
    }

    radioOptions.forEach { radioOption ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val enumSeleccionado = transformarStringAEnumSubTipoPizza(radioOption)
            RadioButton(
                onClick = {
                    viewModel.actualizarPizza(uiState.pizza.copy(subTipoPizza = enumSeleccionado))
                },
                selected = (radioOption == transformarEnum(uiState.pizza.subTipoPizza)),
            )
            Text(
                text = radioOption, modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}
