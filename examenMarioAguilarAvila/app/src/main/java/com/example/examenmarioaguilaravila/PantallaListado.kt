package com.example.examenmarioaguilaravila

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examenmarioaguilaravila.datos.Datos
import com.example.examenmarioaguilaravila.modelos.Alumnado
import com.example.examenmarioaguilaravila.modelos.Profesorado
import com.example.examenmarioaguilaravila.ui.theme.Examen1Theme

@Composable
fun PantallaListado(
    modifier: Modifier = Modifier
){
    // Creo las variables a utilizar
    val listadoAlumnado: List<Alumnado> = Datos().cargarAlumnado()
    val listadoProfesorado: List<Profesorado> = Datos().cargarProfesorado()

    LazyColumn (
        modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        item {
            Text(
                text = stringResource(R.string.examen_2_dam),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
            )

            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(30.dp)
            )
        }

        item {
            Row (
                modifier = Modifier,

            ){
                // Columna Alumnos
                Column (
                    modifier = Modifier
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    listadoAlumnado.forEach { alumno->
                        TarjetaAlumnado(
                            alumnado = alumno
                        )
                    }
                }
                // Columna Profesores
                Column (
                    modifier = Modifier
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    listadoProfesorado.forEach { profesor->
                        TarjetaProfesorado(
                            profesorado = profesor
                        )
                    }
                }
            }
        }

        item {

            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(30.dp)
            )

            Column (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    text = stringResource(R.string.total) + ": " + (listadoAlumnado.size + listadoProfesorado.size).toString(),
                    fontSize = 40.sp
                )
                Text(
                    text = stringResource(R.string.total_alumnos) + ": " + listadoAlumnado.size.toString(),
                    fontSize = 40.sp
                )
                Text(
                    text = stringResource(R.string.total_profesores) + ": " + listadoProfesorado.size.toString(),
                    fontSize = 40.sp
                )
            }
        }
    }

}

@Composable
fun TarjetaAlumnado(
    modifier: Modifier = Modifier,
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

@Composable
fun TarjetaProfesorado(
    modifier: Modifier = Modifier,
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

@Preview(showBackground = true)
@Composable
fun PantallaListadoPreview() {
    Examen1Theme {
        PantallaListado()
    }
}