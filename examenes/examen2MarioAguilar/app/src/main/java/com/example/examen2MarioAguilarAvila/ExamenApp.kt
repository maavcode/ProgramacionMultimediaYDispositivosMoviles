package com.example.examen2MarioAguilarAvila

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.examen2MarioAguilarAvila.ui.pantallas.PantallaPrincipal

enum class Pantallas(@StringRes val titulo: Int){
    PantallaPrincipal (titulo = R.string.pantalla_principal),
    //PantallaEjemplo1 (titulo = "Pantalla Ejemplo1"),
    //PantallaEjemplo2 (titulo = "Pantalla Ejemplo1"),

    // AQUI SE AÑADEN LAS PANTALLAS
}


@Composable
fun ExamenApp (
    navController: NavHostController = rememberNavController()
){
    // Para controlar que en la primera pantalla no aparezca la flecha de atrás en el TopBar controlamos si en la pila de retroceso hay alguna pantalla destrás de la actual. Si la hay, mostramos la flecha.
    val pilaRetroceso by navController.currentBackStackEntryAsState()
    // Para reiniciar la pila de retroceso: onBotonInicioPulsado = {navController.popBackStack(Pantallas.Inicio.name, inclusive = false)} ESTO VACIA LA PILA DE RETROCESO
    val pantallaActual = Pantallas.valueOf(
        pilaRetroceso?.destination?.route ?: Pantallas.PantallaPrincipal.name
    )

    // val ejemploViewModel: EjemploViewModel = viewModel() --- Aqui cargar el ViewModel

    Scaffold (
        topBar = {
            AppTopBar(
                pantallaActual = pantallaActual,
                puedeNavegarAtras = navController.previousBackStackEntry != null,
                onNavegarAtras ={ navController.navigateUp() }
            )
        }
    ){ innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Pantallas.PantallaPrincipal.name, // IMPORTANTE EL .NAME
            modifier = Modifier.padding(innerPadding)
        ){
            // Grafo de las rutas posibles AQUI VAN LAS RUTAS
            composable ( route = Pantallas.PantallaPrincipal.name ){ // IMPORTANTE EL .NAME
                PantallaPrincipal(
                    // AQUI VAN LOS BOTONES DE NAVEGACION (junto con las funciones que quiero que haga, como reiniciar un pedido) Y EL VIEW MODEL SI HACE FALTA
                    /*
                    onPantallaEjemploPulsado = {
                       navController.navigate(Pantallas.PantallaEjemplo.name)
                    },
                    viewModel = ejemploViewModel // El cual he declarado antes
                    * */
                )
            }
            composable ( route = Pantallas.PantallaPrincipal.name ){ // Poner la pantalla buena
                /*
                PantallaEjemplo1(
                    onBotonAtrasPulsado = {
                        navController.navigate(Pantallas.PantallaPrincipal.name)
                    },
                    onBotonSiguientePulsado = {
                        navController.navigate(Pantallas.PantallaEjemplo2.name)
                    },
                )
                */
            }
            composable ( route = Pantallas.PantallaPrincipal.name ){ // Poner la pantalla buena
                /*
                PantallaEjemplo2(
                    onBotonAtrasPulsado = {
                        navController.navigate(Pantallas.PantallaEjemplo1.name)
                    },
                    onBotonInicioPulsado = {
                        navController.popBackStack(Pantallas.PantallaPrincipal.name, inclusive = false)
                    }
                )
                */
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