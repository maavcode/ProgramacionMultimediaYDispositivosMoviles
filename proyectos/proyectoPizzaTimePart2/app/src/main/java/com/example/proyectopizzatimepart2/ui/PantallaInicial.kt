package com.example.proyectopizzatimepart2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopizzatimepart2.R
import com.example.proyectopizzatimepart2.datos.Datos
import com.example.proyectopizzatimepart2.modelo.Persona

@Composable
fun PantallaInicial(
    onListarPedidoPulsado: () -> Unit,
    onRealizarPedidoPulsado: () -> Unit,
    modifier: Modifier = Modifier,

){
    val listaPersonas = Datos().cargarPersonas();
    val personaPrueba = listaPersonas[0]
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.bienvenido_a_pizzatime),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        InformacionPersonal(
            modifier = Modifier.padding(top = 30.dp, bottom = 30.dp),
            persona = personaPrueba // Paso la persona como parametro
        )

        HorizontalDivider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(20.dp)
        )

        OpcionesUsuario(
            modifier = Modifier.padding(top = 30.dp, bottom = 30.dp),
            onListarPedidoPulsado,
            onRealizarPedidoPulsado
        )
        Image(
            painter = painterResource(R.drawable.pizzatimelogo),
            contentDescription = "PizzaTimeLogo",
            modifier = Modifier.fillMaxWidth()
        )

    }

}

@Composable
fun InformacionPersonal(
    modifier: Modifier = Modifier,
    persona : Persona
){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ){
        Image(
            painter = painterResource(R.drawable.person),
            contentDescription = stringResource(R.string.persona),
            Modifier
                .border(
                    width = 5.dp,
                    brush = SolidColor(Color.LightGray),
                    shape = CircleShape
                )
                .clip(CircleShape)


        )
        Text(
            text = persona.nombre,
            fontSize = 20.sp
        )
        Text(
            text = persona.correo
        )
        Text(
            text = persona.telefono
        )
    }

}

@Composable
fun OpcionesUsuario (
    modifier: Modifier = Modifier,
    onListarPedidoPulsado: () -> Unit,
    onRealizarPedidoPulsado: () -> Unit,
){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = stringResource(R.string.que_vas_a_hacer),
            fontSize = 24.sp
        )
        Row (
            modifier = Modifier.padding(top = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        ){
            Button(
                onClick = onRealizarPedidoPulsado,
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(R.string.realizar_pedido)
                )
            }

            Button(
                onClick = onListarPedidoPulsado,
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(R.string.listar_pedidos)
                )
            }
        }
    }
}