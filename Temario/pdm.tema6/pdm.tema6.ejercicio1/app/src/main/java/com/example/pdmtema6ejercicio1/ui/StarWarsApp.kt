package com.example.pdmtema6ejercicio1.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pdmtema6ejercicio1.R
import com.example.pdmtema6ejercicio1.ui.pantallas.PantallaDatosNaves
import com.example.pdmtema6ejercicio1.ui.pantallas.PantallaDatosPersonajes
import com.example.pdmtema6ejercicio1.ui.pantallas.PantallaInicio
import com.example.pdmtema6ejercicio1.ui.viewmodel.StarwarsUIState
import com.example.pdmtema6ejercicio1.ui.viewmodel.StarwarsViewModel

// Enum para guardar las pantallas existentes y sus titulos
enum class Pantallas(@StringRes val titulo: Int) {
    PantallaInicio (titulo = R.string.pantalla_inicio),
    PantallaDatosNaves (titulo = R.string.pantalla_datos_naves),
    PantallaDatosPersonajes (titulo = R.string.pantalla_datos_personajes),
}

@Composable
fun StarWarsApp(
    navController: NavHostController = rememberNavController()
){

    // Para controlar que en la primera pantalla no aparezca la flecha de atrás en el TopBar
    // controlamos si en la pila de retroceso hay alguna pantalla destrás de la actual.
    // Si la hay, mostramos la flecha.
    val pilaRetroceso by navController.currentBackStackEntryAsState()

    val pantallaActual = Pantallas.valueOf(
        pilaRetroceso?.destination?.route ?: Pantallas.PantallaInicio.name
    )

    val starWarsViewModel: StarwarsViewModel = viewModel ()

    Scaffold(
        topBar = {
            AppTopBar(
                pantallaActual = pantallaActual,
                puedeNavegarAtras = navController.previousBackStackEntry != null,
                onNavegarAtras = {navController.navigateUp()}
            )
        }
    ) { innerPadding ->


        NavHost(
            navController = navController,
            startDestination = Pantallas.PantallaInicio.name,
            modifier = Modifier.padding(innerPadding)
        ){
            // Grafo de las rutas
            composable(route = Pantallas.PantallaInicio.name) {
                starWarsViewModel.resetearEstado() // Cada vez que pasa por el inicio resetea el estado
                PantallaInicio(
                    onNavesPulsado = {
                        navController.navigate(Pantallas.PantallaDatosNaves.name)
                    },
                    onPersonajesPulsado = {
                        navController.navigate(Pantallas.PantallaDatosPersonajes.name)
                    }
                )
            }
            composable(route = Pantallas.PantallaDatosPersonajes.name) {
                PantallaDatosPersonajes(
                    modifier = Modifier,
                    viewModel = starWarsViewModel
                )
            }


            composable(route = Pantallas.PantallaDatosNaves.name) {
                PantallaDatosNaves(
                    modifier = Modifier,
                    viewModel = starWarsViewModel
                    // onNavePulsada -> actualizarNavePuklsada y navigate pantallaLista
                )
            }
            // Pantalla Listar solo con la nave = viewmodel.navepulsada

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    pantallaActual: Pantallas,
    puedeNavegarAtras: Boolean,
    onNavegarAtras: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(text = stringResource(id = pantallaActual.titulo)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            scrolledContainerColor = Color.Unspecified,
            navigationIconContentColor = Color.Unspecified,
            titleContentColor = Color.Unspecified,
            actionIconContentColor = Color.Unspecified
        ),
        navigationIcon = {
            if(puedeNavegarAtras) {
                IconButton(onClick = onNavegarAtras) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.atras)
                    )
                }
            }
        },
        modifier = modifier
    )
}