package com.example.pdmtema6ejercicio2.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.pdmtema6ejercicio2.R
import com.example.pdmtema6ejercicio2.ui.pantallas.PantallaInicio
import com.example.pdmtema6ejercicio2.ui.viewmodel.TiendaViewModel


enum class Pantallas (@StringRes val titulo: Int) {
    PantallaInicio (titulo = R.string.pantalla_inicio),
}

@Composable
fun TiendaApp(
    navController: NavHostController = rememberNavController()
) {
    val pilaRetroceso by navController.currentBackStackEntryAsState()

    val pantallaActual = Pantallas.valueOf(
        pilaRetroceso?.destination?.route ?: Pantallas.PantallaInicio.name
    )

    val tiendaViewModel: TiendaViewModel = viewModel (factory = TiendaViewModel.Factory)

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
                //starWarsViewModel.resetearEstado() // Cada vez que pasa por el inicio resetea el estado
                PantallaInicio(
                    estado = tiendaViewModel.tiendaUIState,
                    cargarUsuarios = { tiendaViewModel.obtenerUsuarios() },
                    onUsuarioPulsado = {}
                )
            }

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