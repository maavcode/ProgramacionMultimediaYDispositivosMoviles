package com.example.proyectopizzatime

import android.R.attr.text
import androidx.annotation.ColorInt
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopizzatime.ui.theme.ProyectoPizzaTimeTheme
import java.nio.file.WatchEvent

@Composable
fun PantallaRealizarPedido(
    modifier: Modifier = Modifier
){
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ){
        item {
            Text(
                text = "Realizar un pedido",
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

        item {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                var tipoPizza by remember { mutableStateOf("") }

                // Columna Izquierda
                Column(Modifier
                    .selectableGroup()
                    .weight(1f)
                ) {
                    Text(
                        text = "Pizza",
                        fontSize = 20.sp
                    )
                    val radioOptions = listOf("Romana", "Barbacoa", "Margarita")


                    radioOptions.forEach { radioOption ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 4.dp)
                        ) {
                            RadioButton(
                                selected = (radioOption == tipoPizza),
                                onClick = { tipoPizza = radioOption }
                            )
                            Text(
                                text = radioOption,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                        }
                    }
                }

                // Columna Derecha
                Column (
                    modifier = Modifier.weight(1f)
                ){
                    if (tipoPizza.isNotEmpty()){
                        Text(
                            text = "Opciones de pizza",
                            fontSize = 20.sp
                        )
                        OpcionesPizza(
                            tipoPizza = tipoPizza
                        )
                    }
                }
            }



            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp
            )
        }

    }
}

@Composable
fun OpcionesPizza(
    modifier: Modifier = Modifier,
    tipoPizza: String
) {
    // Segun el tipo de pizza de doy unas opciones u otras
    var radioOptions: List<String> = when (tipoPizza) {
        "Romana" -> {
            listOf("Con champiñones", "Sin champiñones")
        }

        "Barbacoa" -> {
           listOf("Carne de cerdo", "Carne de pollo", "Carne de ternera")
        }

        "Margarita" -> {
           listOf("Con piña", "Sin piña", "vegana")
        }

        else -> emptyList()
    }
    // Hago que la opcion que se vaya a elejir sea mutable
    var opcionPizza by remember { mutableStateOf("") }
    Column {
        radioOptions.forEach { radioOption ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = (radioOption == opcionPizza),
                    onClick = { opcionPizza = radioOption }
                )
                Text(
                    text = radioOption,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaRealizarPedidoPreview() {
    ProyectoPizzaTimeTheme {
        PantallaRealizarPedido()
    }
}