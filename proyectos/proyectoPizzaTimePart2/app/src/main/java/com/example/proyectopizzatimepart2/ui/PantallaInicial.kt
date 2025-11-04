package com.example.proyectopizzatimepart2.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.proyectopizzatimepart2.R

@Composable
fun PantallaInicial(
    onBotonSiguientePulsado: () -> Unit,
    modifier: Modifier = Modifier
){
    Column {
        Text(
            text = "Inicio"
        )
        BotonSiguiente(onClick = {onBotonSiguientePulsado()})
    }

}

@Composable
fun BotonSiguiente(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(onClick = onClick) {
        Text(
            text = stringResource(R.string.siguiente)
        )
    }
}