package com.example.pdmtema3ejercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pdmtema3ejercicio1.datos.Datos
import com.example.pdmtema3ejercicio1.modelo.Persona
import com.example.pdmtema3ejercicio1.ui.theme.Pdmtema3ejercicio1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pdmtema3ejercicio1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(modifier = Modifier

                        .padding(innerPadding)
                        .fillMaxSize())

                }
            }
        }
    }
}



@Composable
fun TarjetaPersona(
   persona: Persona,
   modifier: Modifier = Modifier
){
    Card (
        modifier = Modifier
            .padding(50.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
               painter = painterResource(persona.imageResourceId),
                contentDescription = stringResource(persona.stringResourceIdId),
                modifier = Modifier
                    .width(150.dp)
                    .padding(10.dp)
            )
            Column {
                Text(
                    text = stringResource(persona.stringResourceIdId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = stringResource(persona.stringResourceNameId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = stringResource(persona.stringResourceTelefonoId),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@Composable
fun ListaPersonas(lista: List<Persona>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(lista) { persona ->
            TarjetaPersona(
                persona = persona,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    ListaPersonas(
        lista = Datos().cargarPersonas(),
        modifier = modifier
    )

}


@Preview(showBackground = true)
@Composable
fun App() {
    Pdmtema3ejercicio1Theme {

    }
}