package com.example.examenmarioaguilaravila

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.material3.Switch
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.examenmarioaguilaravila.ui.theme.Examen1Theme

@Composable
fun PantallaAnadirPersona(
    modifier: Modifier = Modifier
){
    // variables necesarias
    var codigoIdentificacion by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var rol by remember { mutableStateOf("") }
    var tutor by remember { mutableStateOf(false) }
    var nia by remember { mutableStateOf("") }
    var curso by remember { mutableStateOf("") }

    // Da error y no se porque
    if (rol == "Alumno" && nombre.isNotEmpty() && nia.length==5){
        val ultimaLetra = nombre.get(nombre.length)
        val niaNumeros = nia[0].toString() + nia[1].toString() + nia[2].toString()
        codigoIdentificacion = ultimaLetra + niaNumeros
    } else if (rol == "Profesor" && nombre.isNotEmpty()){
        codigoIdentificacion = "Funciono profe"
    }

    LazyColumn (
        modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Añadir Persona",
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
            Column (
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ){
                // Codigo
                    Text(
                        text = "Código" + ": " + codigoIdentificacion,
                        fontSize = 24.sp
                    )
                // Nombre
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = {
                        Text(
                            text = "Nombre"
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                // Elige el rol
                    Text(
                        text = "Elige el rol",
                        fontSize = 24.sp
                    )
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.alumno),
                        contentDescription = "Alumnado",
                        modifier = Modifier.size(100.dp)

                    )
                    Image(
                        painterResource(R.drawable.profesor),
                        contentDescription = "Profesorado",
                        modifier = Modifier.size(100.dp)
                    )
                }
                Row (
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    val listaOpciones = listOf("Alumno", "Profesor")
                    listaOpciones.forEach { opcion ->
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            RadioButton(
                                selected = (rol == opcion),
                                onClick = { rol = opcion }
                            )
                            Text(
                                text = opcion,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
                // Apartado mutable
                if (rol == "Alumno"){
                    // NIA
                    OutlinedTextField(
                        value = nia,
                        onValueChange = {
                                if (it.length <= 5) {
                                    nia = it
                                }
                                        },
                        label = {
                            Text(
                                text = "NIA"
                            )
                        },

                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Curso",
                            fontSize = 20.sp
                        )
                        Column {
                            val listaOpciones = listOf("Primero", "Segundo")
                            listaOpciones.forEach { opcion ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(vertical = 4.dp)
                                ) {
                                    Checkbox(
                                        checked = (curso == opcion),
                                        onCheckedChange = { curso = opcion } // solo uno se marca
                                    )
                                    Text(
                                        text = opcion,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )
                                }
                            }
                        }
                    }
                } else if(rol == "Profesor"){
                    Row (
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            "Tutor",
                            fontSize = 20.sp
                        )

                        Switch(
                            checked = tutor,
                            onCheckedChange = {
                                tutor = it
                            }
                        )
                    }

                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Curso",
                            fontSize = 20.sp
                        )
                        Column {
                            val listaOpciones = listOf("Primero", "Segundo")
                            listaOpciones.forEach { opcion ->
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .padding(vertical = 4.dp)
                                ) {
                                    Checkbox(
                                        checked = (curso == opcion),
                                        onCheckedChange = { curso = opcion } // solo uno se marca
                                    )
                                    Text(
                                        text = opcion,
                                        modifier = Modifier.padding(start = 10.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        item {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    16.dp,
                    Alignment.CenterHorizontally
                ),

                ){
                Button(
                    onClick = {}
                ) {
                    Text(
                        text = "Añadir"
                    )
                }
                Button(
                    onClick = {}
                ) {
                    Text(
                        text = "Cancelar"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaAnadirPersonaPreview() {
    Examen1Theme {
        PantallaAnadirPersona()
    }
}