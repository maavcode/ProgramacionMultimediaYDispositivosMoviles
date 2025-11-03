package com.example.pdmtema2ejercicio2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    companion object {
        const val IVA = 21.0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Parte1(
                        modifier = Modifier.padding(innerPadding)
                    )


                    //Ud2Ejercicio2App(
                    //    modifier = Modifier.padding(innerPadding)
                    //)
                }

        }
    }
}
@Composable
fun Parte1(modifier: Modifier = Modifier){
    var precioInput by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .statusBarsPadding() // Respeta la barra de arriba
            .safeDrawingPadding() // Respeta los espacios ocupados como la camara
            .padding(horizontal = 25.dp)
            .background(color = Color.Red)
            .fillMaxSize()
    ){
        CampoEdicionPrecio(
            value = precioInput,
            onValueChange = { precioInput = it },
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()

        )

        CampoRadioButtons(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .background(color = Color.Blue)
        )
    }
}

@Composable
fun CampoEdicionPrecio(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {


    Text(
        text = stringResource(R.string.calcular_precio_con_iva),
        fontSize = 20.sp
    )

    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = {Text(text = stringResource(R.string.precio_del_producto))},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )

}

@Composable
fun CampoRadioButtons(modifier: Modifier) {

}