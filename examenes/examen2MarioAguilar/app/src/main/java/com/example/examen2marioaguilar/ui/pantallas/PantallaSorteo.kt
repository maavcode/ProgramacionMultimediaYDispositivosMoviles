package com.example.examen2marioaguilar.ui.pantallas

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.examen2marioaguilar.R
import com.example.examen2marioaguilar.modelos.uiState.TipoJuego
import com.example.examen2marioaguilar.ui.viewmodel.ExamenViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PantallaSorteo(
    onBotonJuegaPulsado: () -> Unit,
    onBotonAceptarPulsado: () -> Boolean,
    viewModel: ExamenViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    Column (
    ){
        if (viewModel.tipoJuego == TipoJuego.decimo){
            Text(
                text = "¡Juega al Decimo!",
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth()
            )

        }else if (viewModel.tipoJuego == TipoJuego.tuDia){
            Text(
                text = "¡Juega a Tu Dia!",
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth()
            )
            Row (

            ){

            }
        }
    }
}