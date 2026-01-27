package com.example.ud7_ejemplo2.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ud7_ejemplo2.R
import com.example.ud7_ejemplo2.modelo.Ruta

enum class Pantallas(@StringRes val titulo: Int) {
    Inicio(titulo = R.string.pantalla_inicio),
    Pantalla1(titulo = R.string.pantalla1),
    Pantalla2(titulo = R.string.pantalla2)
}

val listaRutas = listOf(
    Ruta(Pantallas.Inicio.titulo, Pantallas.Inicio.name, Icons.Filled.Home, Icons.Outlined.Home),
    Ruta(Pantallas.Pantalla1.titulo, Pantallas.Pantalla1.name,  Icons.Filled.Place, Icons.Outlined.Place),
    Ruta(Pantallas.Pantalla2.titulo, Pantallas.Pantalla2.name, Icons.Filled.Email, Icons.Outlined.Email)
)

@Composable
fun Ud7_Ejemplo2App(
    navController: NavHostController = rememberNavController()
){
    var selectedItem by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                listaRutas.forEachIndexed { indice, ruta ->
                    NavigationBarItem(
                        icon = {
                            if(selectedItem == indice)
                                Icon(
                                    imageVector = ruta.iconoLleno,
                                    contentDescription = stringResource(id = ruta.nombre)
                                )
                            else
                                Icon(
                                    imageVector = ruta.iconoVacio,
                                    contentDescription = stringResource(id = ruta.nombre)
                                )
                        },
                        label = { Text(stringResource(id = ruta.nombre)) },
                        selected = selectedItem == indice,
                        onClick = {
                            selectedItem = indice
                            navController.navigate(ruta.ruta)
                        }
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Pantallas.Inicio.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Grafo de las rutas
            composable(route = Pantallas.Inicio.name) {
                PantallaInicio(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = Pantallas.Pantalla1.name) {
                PrimeraPantalla(
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
             composable(route = Pantallas.Pantalla2.name) {
                    SegundaPantalla(
                        modifier = Modifier
                            .fillMaxSize()
                    )
             }
        }
    }
}