package com.example.examen2marioaguilar.ui.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examen2marioaguilar.R

@Composable
fun PantallaPrincipal(
    modifier: Modifier = Modifier,
    onBotonSorteosJugadosPulsado: () -> Unit,
    onBotonEstadisticasPulsado: () -> Unit,
    onBotonDecimoPulsado: () -> Unit,
    onBotonTuDiaPulsado: () -> Unit,
){
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ){
        Text(
            text = stringResource(R.string.bienvenido_a_tus_juegos_favoritos),
            textAlign = TextAlign.Start,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        HorizontalDivider(
            color = Color.Gray,
            thickness = 1.dp
        )

        Text(
            text = stringResource(R.string.juega_aqui),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Row (
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Button(
                onClick = onBotonDecimoPulsado
            ) {
                Text(
                    text = stringResource(R.string.decimo_de_navidad),
                )
            }

            Button(
                onClick = onBotonTuDiaPulsado
            ) {
                Text(
                    text = stringResource(R.string.tu_dia),
                )
            }


        }

        Text(
            text = stringResource(R.string.otras_opciones),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Row (
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ){

            Button(
                onClick = onBotonSorteosJugadosPulsado
            ) {
                Text(
                    text = stringResource(R.string.sorteos_jugados),
                )
            }

            Button(
                onClick = onBotonEstadisticasPulsado
            ) {
                Text(
                    text = stringResource(R.string.estadisticas),
                )
            }
        }
    }
}