package com.example.pdmtema2ejercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pdmtema2ejercicio1.ui.theme.Pdmtema2ejercicio1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pdmtema2ejercicio1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding)
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    ImagenRandomBoton(modifier = modifier)
}

@Composable
fun ImagenRandomBoton(modifier: Modifier = Modifier){
    // Para poder cambiar el valor de la variable aleatoria debemos guardar su estado.
    var result by remember { mutableStateOf(1) }

    // Dependiendo del valor de la variable aleatoria cargaremos una imagen u otra.
    val imagen = when(result) {
        1 -> R.drawable.memenuget
        2 -> R.drawable.memedam
        3 -> R.drawable.mememarios
        4 -> R.drawable.memechivito
        else -> R.drawable.mememarioherrero
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imagen),
            contentDescription = stringResource(R.string.meme, result)
        )
        Button(
            onClick = {result = (1..5).random() }
        ) {
            Text(text = stringResource(R.string.tira))
        }
    }
}


