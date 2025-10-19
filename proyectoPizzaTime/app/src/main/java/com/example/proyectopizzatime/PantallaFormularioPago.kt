package com.example.proyectopizzatime

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectopizzatime.ui.theme.AppTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopizzatime.datos.Datos


@Composable
fun PantallaFormularioPago(
    modifier: Modifier = Modifier,
) {
    // Obtengo el pedido y saco las variables que me interesan
    val pedidoTramitando = Datos().cargarPersonas().get(0).listaPedidos.get(0)
    val importeTotal = pedidoTramitando.precioTotal


    var metodoPago by remember { mutableStateOf("") }
    var numeroTarjeta by remember { mutableStateOf("") }
    var fechaCaducidad by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }


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
            text = stringResource(R.string.formulario_de_pago),
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
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (metodoPago == opcion),
                        onClick = { metodoPago = opcion }
                    )
                    .padding(top = 4.dp)
            ) {
                RadioButton(
                    selected = (metodoPago == opcion),
                    onClick = { metodoPago = opcion }
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
                value = numeroTarjeta,
                onValueChange = { numeroTarjeta = it },
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
                value = fechaCaducidad,
                onValueChange = { fechaCaducidad = it },
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
                value = cvv,
                onValueChange = {
                    if (it.length <= 3) {
                        cvv = it
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
                text = stringResource(R.string.importe_total) + ": " + importeTotal,
                fontSize = 20.sp
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(onClick = {}) {
                    Text(
                        stringResource(R.string.cancelar)
                    )
                }
                Button(onClick = {}) {
                    Text(
                        stringResource(R.string.aceptar)
                    )
                }
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun PantallaRealizarPagoPreview() {
    AppTheme {
        PantallaFormularioPago(

        )
    }
}