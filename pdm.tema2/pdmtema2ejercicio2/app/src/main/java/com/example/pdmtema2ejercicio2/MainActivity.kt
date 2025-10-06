package com.example.pdmtema2ejercicio2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.HistoricalChange
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.NumberFormat

class MainActivity : ComponentActivity() {

    companion object {
        const val IVA = 21.0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ud2Ejercicio2App(
                        modifier = Modifier.padding(innerPadding)
                    )
                }

        }
    }
}

@Composable
fun Ud2Ejercicio2App(modifier: Modifier = Modifier) {
    // Guardamos el estado del precio escrito por el usuario en el TextField.
    var precioInput by remember { mutableStateOf("") }

    val listaIVA = listOf(21, 10, 3)

    var (eleccion, onOpcionElegida) = remember { mutableStateOf(listaIVA[0])}

    var ivaRadio by remember { mutableStateOf(eleccion.toDouble()) }


    // Si el valor de precioInput es null se asignará el valor 0.0
    val precio = precioInput.toDoubleOrNull() ?: 0.0

    val iva = calcularIva(precio, ivaRadio)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calcular_precio_con_iva) ,
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        CampoEdicionPrecio(
            value = precioInput,
            onValueChange = {precioInput = it},
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        Column (Modifier.selectableGroup()) {
            listaIVA.forEach { opcion ->
                Row(
                    modifier = Modifier.selectable(
                        selected = (opcion == eleccion),
                        onClick = {
                            eleccion = opcion
                            onOpcionElegida(opcion)
                            ivaRadio = eleccion.toDouble()}
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    RadioButton(selected = (opcion == eleccion),
                        onClick = {
                            eleccion = opcion
                            onOpcionElegida(opcion)
                            ivaRadio = eleccion.toDouble()})
                    Text(text = "${opcion}%")
                }
            }
        }

        Text(
            text = stringResource(R.string.precio, iva),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun CampoEdicionPrecio(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = { Text(text = stringResource(R.string.precio_del_producto))},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = modifier
    )
}

private fun calcularIva(precio: Double, ivaRadio: Double): String {
    val iva = precio + (ivaRadio / 100 * precio)

    // Devolvemos el precio final en la moneda del país en el que está configurado el dispositivo.
    return NumberFormat.getCurrencyInstance().format(iva)
}
