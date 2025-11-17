package com.example.examen1_viewmodel

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.examen1_viewmodel.modelo.Alumno
import com.example.examen1_viewmodel.modelo.Profesor
import com.example.examen1_viewmodel.ui.appViewModel.AppViewModel

@Composable
fun ListarPersona(viewModel: AppViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .padding(top = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.examen),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(Modifier.height(16.dp))
        HorizontalDivider(Modifier.height(20.dp))

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            // Mostrar alumnos
            items(viewModel.appUIState.value.personas) { persona ->
                if (persona is Alumno){
                    PersonaCard(
                        rol = "Alumno",
                        nombre = persona.nombre,
                        curso = persona.cursoSeleccionado,
                        codigo = persona.codIden,
                        nia = persona.NIA
                    )
                }else if (persona is Profesor){
                    PersonaCard(
                        rol = "Profesor",
                        nombre = persona.nombre,
                        curso = persona.cursosImparte,
                        codigo = persona.codigoIdent,
                        esTutor = persona.esTutor
                    )
                }

            }
        }

        HorizontalDivider(Modifier.height(20.dp)
            .padding(top=500.dp))
    }
}

    @Composable
    fun PersonaCard(
        rol:String,
        nombre: String,
        curso: String,
        codigo: String,
        nia: String? = null,
        esTutor: Boolean? = null


    ) {
        var expandido by remember { mutableStateOf(false) }

        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable { expandido = !expandido }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(
                            id = if (rol == "Alumno") R.drawable.alumno else R.drawable.profesor
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text(text = "Rol: $rol", style = MaterialTheme.typography.titleMedium)
                        Text(text = "Nombre: $nombre", style = MaterialTheme.typography.bodyLarge)
                    }
                }

                if (expandido) {
                    Spacer(Modifier.height(12.dp))
                    Column {
                        Text(text = "Curso: $curso")
                        Text(text = "Código: $codigo")
                        if (rol == "Alumno" && nia != null) {
                            Text(text = "NIA: $nia")
                        }
                        if (rol == "Profesor" && esTutor != null) {
                            Text(text = "¿Es tutor?: ${if (esTutor) "Sí" else "No"}")
                        }
                    }
                }
            }
        }
    }






