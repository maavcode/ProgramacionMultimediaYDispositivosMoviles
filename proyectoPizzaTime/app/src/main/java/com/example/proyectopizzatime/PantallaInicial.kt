package com.example.proyectopizzatime

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.AppTheme
import com.example.proyectopizzatime.datos.Datos
import com.example.proyectopizzatime.ui.theme.Persona



@Composable
fun PantallaInicial (
    modifier: Modifier = Modifier
){
    val listaPersonas = Datos().cargarPersonas();
    val persona1 = listaPersonas[0]
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Bienvenido a PizzaTime",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )

        InformacionPersonal(
            modifier = Modifier.padding(top = 30.dp, bottom = 30.dp),
            persona = persona1 // Paso la persona como parametro
        )

        HorizontalDivider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(20.dp)
        )

        OpcionesUsuario(
            modifier = Modifier.padding(top = 30.dp, bottom = 30.dp)
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
            contentDescription = "person",
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
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "¿Que vas a hacer?",
            fontSize = 24.sp
        )
        Row (
            modifier = Modifier.padding(top = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        ){
            Button(
                onClick = {},
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Realizar pedido"
                )
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .width(150.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Listar pedidos"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicialPreview() {
    AppTheme {
        PantallaInicial()
    }
}