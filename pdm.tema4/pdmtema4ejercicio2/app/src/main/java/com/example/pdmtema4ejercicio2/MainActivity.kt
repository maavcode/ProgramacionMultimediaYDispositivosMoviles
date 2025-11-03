package com.example.pdmtema4ejercicio2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pdmtema4ejercicio2.ui.theme.Pdmtema4ejercicio2Theme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pdmtema4ejercicio2.ui.OperacionRestaViewModel
import com.example.pdmtema4ejercicio2.ui.OperacionSumaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pdmtema4ejercicio2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun App(
    modifier: Modifier = Modifier,
){
    Column (
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Text(
            text = stringResource(R.string.calculadora),
            style = MaterialTheme.typography.displayMedium
        )

        CalculadoraSuma(

        )

        CalculadoraResta(

        )
    }
}
@Composable
fun CalculadoraSuma(
    modifier: Modifier = Modifier,
    operacionViewModel: OperacionSumaViewModel = viewModel()
) {

    // Cada vez que haya un cambio en el valor de operacionUIState se produce una
    // recomposición para los elementos componibles con el valor de uiState.
    val uIState by operacionViewModel.operacionUIState.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){

        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            TextField(
                // El número a mostrar será el que está almacenado en el uIState
                value = uIState.numero1,
                label = {Text (text = stringResource(R.string.numero_1)) },
                onValueChange = {
                    // Al escribir el número lo actualizamos en nuestro ViewModel
                    operacionViewModel.actualizarNumero1(it)
                },
                modifier = Modifier.weight(1F)
                    .onFocusChanged { focus ->
                        if (focus.isFocused) {
                            operacionViewModel.actualizarNumero1("")
                        }
                    }
            )
            Text(
                text = "+",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1F)
            )
            TextField(
                // El número a mostrar será el que está almacenado en el uIState
                value = uIState.numero2,
                label = {Text (text = stringResource(R.string.numero_2))},
                onValueChange = {
                    // Al escribir el número lo actualizamos en nuestro ViewModel
                    operacionViewModel.actualizarNumero2(it)
                },
                modifier = Modifier.weight(1F)
                    .onFocusChanged { focus ->
                        if (focus.isFocused) {
                            operacionViewModel.actualizarNumero2("")
                        }
                    }
            )
            Text(
                text = "= ${uIState.resultado}",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
fun CalculadoraResta(
    modifier: Modifier = Modifier,
    operacionViewModel: OperacionRestaViewModel = viewModel()
) {

    // Cada vez que haya un cambio en el valor de operacionUIState se produce una
    // recomposición para los elementos componibles con el valor de uiState.
    val uIState by operacionViewModel.operacionUIState.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            TextField(
                // El número a mostrar será el que está almacenado en el uIState
                value = uIState.numero1,
                label = {Text (text = stringResource(R.string.numero_1)) },
                onValueChange = {
                    // Al escribir el número lo actualizamos en nuestro ViewModel
                    operacionViewModel.actualizarNumero1(it)
                },
                modifier = Modifier.weight(1F)
                    .onFocusChanged { focus ->
                        if (focus.isFocused) {
                            operacionViewModel.actualizarNumero1("")
                        }
                    }
            )
            Text(
                text = "-",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1F)
            )
            TextField(
                // El número a mostrar será el que está almacenado en el uIState
                value = uIState.numero2,
                label = {Text (text = stringResource(R.string.numero_2))},
                onValueChange = {
                    // Al escribir el número lo actualizamos en nuestro ViewModel
                    operacionViewModel.actualizarNumero2(it)
                },
                modifier = Modifier.weight(1F)
                    .onFocusChanged { focus ->
                        if (focus.isFocused) {
                            operacionViewModel.actualizarNumero2("")
                        }
                    }
            )
            Text(
                text = "= ${uIState.resultado}",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1F)
            )
        }
    }
}