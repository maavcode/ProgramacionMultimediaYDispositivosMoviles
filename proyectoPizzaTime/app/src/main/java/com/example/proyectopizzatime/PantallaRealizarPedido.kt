package com.example.proyectopizzatime

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.proyectopizzatime.ui.theme.AppTheme

@Composable
fun PantallaRealizarPedido(
    modifier: Modifier = Modifier
){
    var tipoPizza by remember { mutableStateOf("") }
    var tipoBebida by remember { mutableStateOf("") }
    var tamanoPizza by remember { mutableStateOf("") }
    var cantidadPizza by remember { mutableStateOf(0) }
    var cantidadBebida by remember { mutableStateOf(0) }
    LazyColumn (
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ){
        item {
            Text(
                text = stringResource(R.string.realizar_un_pedido),
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
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = " ${stringResource(R.string.total)} ${"%.2f".format(getPrecio(cantidadBebida = cantidadBebida, tamanoPizza = tamanoPizza, tipoBebida = tipoBebida, cantidadPizza = cantidadPizza))}",
                textAlign = TextAlign.Center,
                fontSize = 24.sp
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
                        text = stringResource(R.string.pizza),
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )

                    val radioOptions = listOf(stringResource(R.string.romana),
                        stringResource(R.string.barbacoa), stringResource(R.string.margarita)
                    )
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
                                text = stringResource(R.string.opciones_de_pizza),
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
                        stringResource(R.string.romana) -> R.drawable.romana
                        stringResource(R.string.barbacoa) -> R.drawable.barbacoa
                        stringResource(R.string.margarita) -> R.drawable.margarita
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
                                text = stringResource(R.string.cantidad)
                            )
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ){
                                if (cantidadPizza!=0){
                                    Button(
                                        onClick = {cantidadPizza--},
                                    ) {
                                        Text("-")
                                    }
                                }


                                Text(
                                    text = cantidadPizza.toString()
                                )

                                Button(
                                    onClick = {cantidadPizza++},
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
        if (tipoPizza.isNotEmpty()){
            item {
                Text(
                    text = stringResource(R.string.tama_o_de_la_pizza),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                val opciones = listOf(stringResource(R.string.peque_a),
                    stringResource(R.string.mediana), stringResource(R.string.grande)
                )

                opciones.forEach { opcion ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .clickable { tamanoPizza = opcion } // también se puede tocar el texto
                    ) {
                        Checkbox(
                            checked = (tamanoPizza == opcion),
                            onCheckedChange = { tamanoPizza = opcion } // solo uno se marca
                        )
                        Text(
                            text = opcion,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }

                HorizontalDivider(
                    color = Color.Gray,
                    thickness = 1.dp
                )
            }
        }

        item {

            Text(
                text = stringResource(R.string.bebida),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Row (
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                val listaBebidas = listOf(stringResource(R.string.agua),
                    stringResource(R.string.cola), stringResource(R.string.sin_bebida)
                )

                listaBebidas.forEach { bebida ->
                    Button(
                        onClick = {tipoBebida=bebida},
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = if (tipoBebida == bebida) Color(0xFF4CAF50) else Color.Gray
                            ),
                        modifier = Modifier.padding(10.dp)
                    ){
                        Text(
                            text = bebida
                        )
                    }
                }
            }
            if (tipoBebida.isNotEmpty() && tipoBebida != stringResource(R.string.sin_bebida)) {
                Row (
                    modifier = Modifier.height(200.dp)
                ){
                    Column (
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                    ){
                        val imageOption = when(tipoBebida) {
                            stringResource(R.string.agua) -> R.drawable.agua
                            stringResource(R.string.cola) -> R.drawable.cola
                            else -> R.drawable.person
                        }
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
                            text = stringResource(R.string.cantidad)
                        )
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ){
                            if (cantidadBebida!=0){
                                Button(
                                    onClick = {cantidadBebida--},
                                ) {
                                    Text("-")
                                }
                            }


                            Text(
                                text = cantidadBebida.toString()
                            )

                            Button(
                                onClick = {cantidadBebida++},
                            ) {
                                Text("+")
                            }
                        }
                    }
                }
            }




        }

        item {
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Button(onClick = {}) {
                        Text(stringResource(R.string.cancelar))
                    }
                    Button(onClick = {}) {
                        Text(stringResource(R.string.aceptar))
                    }
                }
            }

        }
    }
}

@Composable
fun getPrecio(tamanoPizza: String, tipoBebida: String, cantidadPizza: Int, cantidadBebida: Int ): Double {
    var precioPizza: Double = 0.0
    when(tamanoPizza){
        stringResource(R.string.peque_a) -> precioPizza = 4.95
        stringResource(R.string.mediana) -> precioPizza = 6.95
        stringResource(R.string.grande) -> precioPizza = 10.95
    }
    var precioBebida: Double = 0.0
    when(tipoBebida){
        stringResource(R.string.agua) -> precioBebida = 2.0
        stringResource(R.string.cola) -> precioBebida = 2.5
        stringResource(R.string.sin_bebida) -> precioBebida = 0.0
    }


    val precioTotal: Double = (precioPizza*cantidadPizza) + (precioBebida*cantidadBebida)
    return precioTotal
}
@Composable
fun OpcionesPizza(
    modifier: Modifier = Modifier,
    tipoPizza: String
) {
    // Segun el tipo de pizza de doy unas opciones u otras
    var radioOptions: List<String> = emptyList()
    when (tipoPizza) {
        stringResource(R.string.romana) -> {
            radioOptions = listOf(stringResource(R.string.con_champi_ones),
                stringResource(R.string.sin_champi_ones)
            )
        }

        stringResource(R.string.barbacoa) -> {
            radioOptions = listOf(stringResource(R.string.carne_de_cerdo),
                stringResource(R.string.carne_de_pollo), stringResource(R.string.carne_de_ternera)
            )
        }

        stringResource(R.string.margarita) -> {
            radioOptions = listOf(stringResource(R.string.con_pi_a),
                stringResource(R.string.sin_pi_a), stringResource(R.string.vegana)
            )
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
    AppTheme {
        PantallaRealizarPedido()
    }
}