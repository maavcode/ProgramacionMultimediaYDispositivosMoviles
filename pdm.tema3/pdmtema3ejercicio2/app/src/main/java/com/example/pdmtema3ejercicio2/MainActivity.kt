package com.example.pdmtema3ejercicio2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pdmtema3ejercicio2.datos.Datos
import com.example.pdmtema3ejercicio2.modelos.Persona
import com.example.pdmtema3ejercicio2.ui.theme.Pdmtema3ejercicio2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pdmtema3ejercicio2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(
                        modifier = Modifier
                            .background(color = Color.DarkGray)
                            .statusBarsPadding()
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TarjetaPersona (
    persona: Persona,
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(150.dp)
    ){
        Row (

        ){
            Image(
                painter = painterResource(persona.imageResourceId),
                contentDescription = stringResource(persona.stringResourceNameId)
            )
            Column (

            ){
                Text(
                    text = stringResource(persona.stringResourceNameId)
                )
                Text(
                    text = stringResource(persona.stringResourceDniId)
                )
                Text(
                    text = stringResource(persona.stringResourceTelefonoId)
                )
            }

        }
    }
}



@Composable
fun ListaPersonas (
    lista: List<Persona>,
    modifier: Modifier = Modifier
){
    LazyColumn (
        modifier = modifier
    ){
        items(lista){persona->
            ItemPersona(
                persona = persona,
                onItemClick = { personaElegida ->
                    Log.v("Persona pulsada: ", personaElegida.stringResourceIdId.toString())
                }
            )
        }

    }
}

@Composable
fun ItemPersona (
    persona: Persona,
    onItemClick: (Persona) -> Unit
){
    TarjetaPersona(
        persona = persona,
        modifier = Modifier
            .clickable{onItemClick(persona)}
            .padding(8.dp)
    )
}

@Composable
fun App (
    modifier: Modifier = Modifier
){
    ListaPersonas(
        modifier = modifier,
        lista = Datos().cargarPersonas()
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pdmtema3ejercicio2Theme {
        App()
    }
}