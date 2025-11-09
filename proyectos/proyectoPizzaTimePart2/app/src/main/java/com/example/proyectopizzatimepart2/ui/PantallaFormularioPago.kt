package com.example.proyectopizzatimepart2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.proyectopizzatimepart2.R
import com.example.proyectopizzatimepart2.datos.Datos
import com.example.proyectopizzatimepart2.ui.viewmodel.RealizarPedidoViewModel

@Composable
fun PantallaFormularioPago(
    viewModel: RealizarPedidoViewModel,
    onCancelarPulsado: () -> Unit,
    onAceptarPulsado: () -> Unit,
    modifier: Modifier = Modifier
){

    val uiState by viewModel.uiState.collectAsState()

    val opcionesPago = listOf(stringResource(R.string.visa),
        stringResource(R.string.mastercard), stringResource(R.string.euro_6000)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = stringResource(R.string.formulario_del_pago),
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

        // Selección de método de pago
        Text(
            text = stringResource(R.string.metodo_de_pago),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        opcionesPago.forEach { opcion ->
            val enumSeleccionado = transformarStringAEnumOpcionesPago(opcion)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (transformarEnum(uiState.pago.opcionPago) == opcion),
                        onClick = { viewModel.actualizarPago(uiState.pago.copy(opcionPago = enumSeleccionado))}
                    )
                    .padding(top = 4.dp)
            ) {
                RadioButton(
                    selected = (transformarEnum(uiState.pago.opcionPago) == opcion),
                    onClick = { viewModel.actualizarPago(uiState.pago.copy(opcionPago = enumSeleccionado))}
                )
                Text(
                    text = opcion,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }

        // Numero de tarjeta
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = uiState.pago.numeroTarjeta,
                onValueChange = {
                    if (it.isDigitsOnly() && it.length <= 16) {
                        viewModel.actualizarPago(uiState.pago.copy(numeroTarjeta = it))
                    }
                },
                label = {
                    Text(
                        text = stringResource(R.string.numero_de_tarjera)
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        // Fecha y CVV
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = uiState.pago.fechaCaducidad,
                onValueChange = {
                    if ((it.isDigitsOnly() || it.contains("/")) && it.length<=5) {
                        viewModel.actualizarPago(uiState.pago.copy(fechaCaducidad = it))
                    }
                },
                label = {
                    Text(
                        text = stringResource(R.string.fecha_caducidad_mm_aa)
                    )
                },
                modifier = Modifier
                    .weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            OutlinedTextField(
                value = uiState.pago.cvv,
                onValueChange = {
                    if (it.isDigitsOnly() && it.length <= 3) {
                       viewModel.actualizarPago(uiState.pago.copy(cvv = it))
                    }
                },
                label = { Text(stringResource(R.string.cvv)) },
                modifier = Modifier.weight(1f),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(R.string.importe_total) + ": " + uiState.precioTotal,
                fontSize = 20.sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(onClick = onCancelarPulsado) {
                    Text(
                        stringResource(R.string.cancelar)
                    )
                }
                Button(onClick = onAceptarPulsado) {
                    Text(
                        stringResource(R.string.aceptar)
                    )
                }
            }
        }

    }
}