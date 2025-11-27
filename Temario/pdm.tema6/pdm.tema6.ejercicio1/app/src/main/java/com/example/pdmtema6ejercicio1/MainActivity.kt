package com.example.pdmtema6ejercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pdmtema6ejercicio1.modelo.Respuesta
import com.example.pdmtema6ejercicio1.ui.StarwarsUIState
import com.example.pdmtema6ejercicio1.ui.StarwarsViewModel
import com.example.pdmtema6ejercicio1.ui.theme.Pdmtema6ejercicio1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pdmtema6ejercicio1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaDatos(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaDatos(
    modifier: Modifier = Modifier,
    viewModel: StarwarsViewModel = viewModel()
) {
    val starwarsUIState = viewModel.starwarsUIState

    when (starwarsUIState) {
        is StarwarsUIState.Cargando -> PantallaCargando(modifier = modifier.fillMaxSize())
        is StarwarsUIState.Exito -> PantallaExito(
            respuesta = starwarsUIState.respuesta,
            modifier = modifier.fillMaxWidth()
        )
        is StarwarsUIState.Error -> PantallaError (modifier = modifier.fillMaxWidth())
    }
}

@Composable
fun PantallaCargando(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.cargando),
        contentDescription = stringResource(R.string.cargando)
    )
}

@Composable
fun PantallaError(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.error),
        contentDescription = stringResource(R.string.error_de_conexion)
    )
}

@Composable
fun PantallaExito(
    respuesta: Respuesta,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier) {
        items(respuesta.resultados) { personaje ->
            Box(
                modifier = Modifier.padding(8.dp)
            ){
                Column(
                    modifier= Modifier.fillMaxWidth()
                ){
                    Text(
                        text = personaje.nombre
                    )
                    Text(
                        text = personaje.genero
                    )
                    HorizontalDivider()
                }

            }
        }
    }
}