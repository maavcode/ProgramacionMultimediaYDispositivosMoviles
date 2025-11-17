package com.example.examen1_viewmodel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.examen1_viewmodel.modelo.Alumno
import com.example.examen1_viewmodel.ui.appViewModel.AppViewModel


@Composable
fun AnadirPersona(viewModel: AppViewModel = viewModel(), modifier: Modifier =
Modifier) {
    var rolSeleccionado by remember { mutableStateOf("") }
    var cursoSeleccionado by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
             horizontalAlignment = Alignment.CenterHorizontally,
             //verticalArrangement = Arrangement.SpaceBetween
    ) {
            Text(
                text = stringResource(R.string.anadir),
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.codigo),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(8.dp))

            OutlinedTextField(
                value = viewModel.nombreSeleccionado,
                onValueChange = viewModel::actualizarNombre,
                singleLine = true,
                label = { Text(stringResource(R.string.nombre)) },
                modifier = Modifier.width(250.dp)
            )

            Spacer(Modifier.height(height=8.dp))

            Text(
                text = stringResource(R.string.rol),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(8.dp))

            Row(horizontalArrangement = Arrangement.Center) {
                Image(
                    painter = painterResource(id = R.drawable.alumno),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp).padding(end = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.profesor),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp).padding(start = 8.dp)
                )
            }

            Spacer(Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf("Alumno", "Profesor").forEach { opcion ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = (opcion == rolSeleccionado ),
                            onClick = { rolSeleccionado  = opcion }
                        )
                        Text(text = opcion)
                    }
                }
            }
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalAlignment = Alignment.CenterVertically
        ) {
            if (rolSeleccionado == "Alumno") {

                OutlinedTextField(
                    value = viewModel.NIASeleccionado ,
                    onValueChange = viewModel::actualizarNIA,
                    label = { Text(stringResource(R.string.nia)) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.width(250.dp),
                    textStyle = androidx.compose.ui.text.TextStyle(
                        if (viewModel.NIASeleccionado=="00000")
                            Color.Red else Color.Black
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                    ) {
                    Text(
                        text = stringResource(R.string.curso),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Column {
                        listOf("Primero", "Segundo").forEach { opcion ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = (opcion == viewModel.cursoSeleccionado),

                                    onClick = { viewModel.actualizarCurso(opcion) }

                                )
                                Text(text = opcion)
                            }
                        }
                    }
                }
                Spacer(Modifier.height(150.dp))
                Row    ( modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly){
                    BotonAnadir(
                        onClick = {
                            val codigo = viewModel.generarCodigoAlumno(
                                nombre = viewModel.nombreSeleccionado,
                                NIA = viewModel.NIASeleccionado
                            )
                            viewModel.actualizarCodIden(codigo)
                            viewModel.registrarPersonaActual(persona = Alumno())
                        }
                    )

                    BotonCancelar(onClick = { /* acción cancelar */ })
                }
            } else if (rolSeleccionado == "Profesor") {
                SwitchTutor(viewModel)

                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.curso),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Column {
                        listOf("Primero", "Segundo").forEach { opcion ->
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                RadioButton(
                                    selected = (opcion == cursoSeleccionado),
                                    onClick = { cursoSeleccionado = opcion }
                                )
                                Text(text = opcion)
                            }
                        }
                    }
                }
                Spacer(Modifier.height(150.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    BotonAnadir(
                        onClick = {
                            val codigo = viewModel.generarCodigoProfesor(
                                nombre = viewModel.nombreSeleccionado,
                                esTutor = viewModel.esTutor
                            )
                            viewModel.actualizarCodigoIdent(codigo)
                            viewModel.registrarPersonaActual()
                        }
                    )
                    BotonCancelar(onClick = { /* acción cancelar */ })
                }
            }

        }
    }
}


@Composable
fun BotonCancelar(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = stringResource(R.string.btn_cancelar))
    }
}

@Composable
fun BotonAnadir(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text = stringResource(R.string.btn_anadir))
    }
}
    @Composable
    fun SwitchTutor(viewModel: AppViewModel) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(R.string.tutor),
            modifier = Modifier .padding(end = 8.dp))
            Switch(
                checked = viewModel.esTutor,
                onCheckedChange = { viewModel.actualizarTutor(it) }
            )
        }
    }

