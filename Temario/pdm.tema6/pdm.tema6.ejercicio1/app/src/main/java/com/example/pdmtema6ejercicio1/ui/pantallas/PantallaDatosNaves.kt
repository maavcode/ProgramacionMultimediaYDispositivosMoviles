package com.example.pdmtema6ejercicio1.ui.pantallas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pdmtema6ejercicio1.modelo.respuestas.RespuestaNave
import com.example.pdmtema6ejercicio1.ui.viewmodel.StarwarsUIState
import com.example.pdmtema6ejercicio1.ui.viewmodel.StarwarsViewModel

@Composable
fun PantallaDatosNaves(
    modifier: Modifier = Modifier,
    viewModel: StarwarsViewModel
) {
    val estado = viewModel.starwarsUIState

    if (estado is StarwarsUIState.Cargando) {
        viewModel.obtenerNaves()
    }
    when (estado) {
        is StarwarsUIState.Cargando -> PantallaCargando(modifier = modifier.fillMaxSize())
        is StarwarsUIState.ExitoNaves -> PantallaExitoNaves(
            respuestaNave = estado.data,
            modifier = modifier.fillMaxWidth()
        )
        is StarwarsUIState.Error -> PantallaError (modifier = modifier.fillMaxWidth())
        else -> PantallaError (modifier = modifier.fillMaxWidth())
    }

    
}


@Composable
fun PantallaExitoNaves(
    respuestaNave: RespuestaNave,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier) {
        items(respuestaNave.resultados) { nave ->
            Box(modifier = Modifier.padding(8.dp)) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = nave.name)
                    Text(text = nave.model)
                    HorizontalDivider()
                }
            }
        }
    }
}