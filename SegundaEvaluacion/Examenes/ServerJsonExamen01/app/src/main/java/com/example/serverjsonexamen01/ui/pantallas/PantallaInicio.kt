package com.example.serverjsonexamen01.ui.pantallas

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.serverjsonexamen01.R
import com.example.serverjsonexamen01.modelo.Alumnado
import com.example.serverjsonexamen01.modelo.Persona
import com.example.serverjsonexamen01.modelo.Profesorado
import com.example.serverjsonexamen01.ui.viewmodel.ExamenUIState

@Composable
fun PantallaInicio(
    estado: ExamenUIState
){
    when(estado){
        is ExamenUIState.Cargando -> PantallaCargando()
        is ExamenUIState.Error -> PantallaError()
        is ExamenUIState.obtenerPersonasExito ->
            PantallaPersonas(
                listaPersonas = estado.listaPersonas
            )
    }
}

@Composable
fun PantallaPersonas(listaPersonas: List<Persona>) {

    val listaMezclada = remember { listaPersonas.shuffled() }

    val totalPersonas = listaPersonas.size
    val totalAlumnos = listaPersonas.count { it is Alumnado }
    val totalProfesores = listaPersonas.count { it is Profesorado }

    Box(modifier = Modifier.fillMaxSize()) {

        // CABECERA
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Examen 2ºDAM",
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )

            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(30.dp)
            )
        }

        // GRID
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 120.dp, bottom = 140.dp), // deja espacio arriba y abajo
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(listaMezclada) { persona ->
                when (persona) {
                    is Alumnado -> AlumnadoCard(persona)
                    is Profesorado -> ProfesoradoCard(persona)
                }
            }
        }

        // TOTALES ABAJO
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Total: $totalPersonas", fontSize = 25.sp)
            Text("Alumnos: $totalAlumnos", fontSize = 25.sp)
            Text("Profesores: $totalProfesores", fontSize = 25.sp)
        }
    }
}



@Composable
fun ProfesoradoCard(
    profesorado: Profesorado
){
    Card (
        modifier = Modifier
            .width(180.dp),
        shape = RectangleShape,


        ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(10.dp)
        ){
            Image(
                painter = painterResource(R.drawable.alumno),
                contentDescription = stringResource(R.string.profesorado),
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),

                )
            Column (
                modifier = Modifier.height(70.dp),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = stringResource(R.string.profesor),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = profesorado.nombre
                )
            }

        }
    }
}

@Composable
fun AlumnadoCard(
    alumnado: Alumnado
){
    Card (
        modifier = Modifier
            .width(180.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors()

    ){
        Row (
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(10.dp)
        ){
            Image(
                painter = painterResource(R.drawable.alumno),
                contentDescription = stringResource(R.string.alumnado),
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape),

                )
            Column (
                modifier = Modifier.height(70.dp),
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = stringResource(R.string.alumno),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = alumnado.nombre
                )
            }

        }
    }
}