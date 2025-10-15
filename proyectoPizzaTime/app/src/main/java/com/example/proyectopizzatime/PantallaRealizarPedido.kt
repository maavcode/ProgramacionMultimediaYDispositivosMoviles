package com.example.proyectopizzatime

import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun PantallaRealizarPedido(
    modifier: Modifier = Modifier
){
    var tipoPizza by remember { mutableStateOf("") }
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    //.height(IntrinsicSize.Min) // para que la altura se ajuste al contenido
            ) {


                // Columna Izquierda
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .selectableGroup()
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

                    // Imagen según tipoPizza



                }

                // Columna Derecha
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),

                ) {
                    if (tipoPizza.isNotEmpty()){
                        Column (

                        ){
                            Text(
                                text = "Opciones de pizza",
                                fontSize = 20.sp
                            )
                            OpcionesPizza(tipoPizza = tipoPizza)
                        }


                    }
                }
            }
            if (tipoPizza.isNotEmpty()){
                Row (
                    modifier = Modifier.height(200.dp)
                ){
                    val imageOption = when(tipoPizza) {
                        "Romana" -> R.drawable.person
                        "Barbacoa" -> R.drawable.person
                        "Margarita" -> R.drawable.person
                        else -> R.drawable.person
                    }

                        Column (
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                        ){
                            Image(
                                painter = painterResource(imageOption),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Column (
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally

                        ){
                            Text(
                                text = "Cantidad"
                            )
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ){
                                var cantidad by remember { mutableStateOf(0) }
                                if (cantidad!=0){
                                    Button(
                                        onClick = {cantidad--},
                                    ) {
                                        Text("-")
                                    }
                                }


                                Text(
                                    text = cantidad.toString()
                                )

                                Button(
                                    onClick = {cantidad++},
                                ) {
                                    Text("+")
                                }
                            }
                        }




                }
            }
            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp
            )


        }

        item {
            var bebidaSeleccionada by remember { mutableStateOf("") }
            
            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                val listaBebidas = listOf("Agua", "Refresco", "Fanta")

                listaBebidas.forEach { bebida ->
                    Button(
                        onClick = {bebidaSeleccionada=bebida},
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = if (bebidaSeleccionada == bebida) Color(0xFF4CAF50) else Color.Gray
                            )
                    ){
                        Text(
                            text = bebida
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
    var radioOptions: List<String> = emptyList()
    when (tipoPizza) {
        "Romana" -> {
            radioOptions = listOf("Con champiñones", "Sin champiñones")
        }

        "Barbacoa" -> {
            radioOptions = listOf("Carne de cerdo", "Carne de pollo", "Carne de ternera")
        }

        "Margarita" -> {
            radioOptions = listOf("Con piña", "Sin piña", "vegana")
        }
    }
    // Hago que la opcion que se vaya a elejir sea mutable
    var opcionPizza by remember { mutableStateOf("") }

        Column (

        ){


                radioOptions.forEach { radioOption ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp),
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