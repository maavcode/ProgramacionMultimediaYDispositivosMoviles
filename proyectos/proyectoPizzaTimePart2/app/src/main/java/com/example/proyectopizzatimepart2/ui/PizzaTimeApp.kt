package com.example.proyectopizzatimepart2.ui

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.proyectopizzatimepart2.R
import com.example.proyectopizzatimepart2.datos.Datos
import com.example.proyectopizzatimepart2.modelo.Pedido
import com.example.proyectopizzatimepart2.ui.viewmodel.RealizarPedidoViewModel

// Enum para guardar las pantallas existentes y sus titulos
enum class Pantallas(@StringRes val titulo: Int) {
    PantallaInicial (titulo = R.string.inicio),
    PantallaListaPedidos (titulo = R.string.lista_de_pedidos),
    PantallaRealizarPedido (titulo = R.string.realizar_un_pedido),
    PantallaResumenPedido (titulo = R.string.resumen_del_pedido),
    PantallaFormularioPago (titulo = R.string.formulario_del_pago),
    PantallaResumenPago (titulo = R.string.resumen_del_pago),
}

@Composable
fun PizzaTimeApp(
    navController: NavHostController = rememberNavController()
){

    // Para controlar que en la primera pantalla no aparezca la flecha de atrás en el TopBar
    // controlamos si en la pila de retroceso hay alguna pantalla destrás de la actual.
    // Si la hay, mostramos la flecha.
    val pilaRetroceso by navController.currentBackStackEntryAsState()

    val pantallaActual = Pantallas.valueOf(
        pilaRetroceso?.destination?.route ?: Pantallas.PantallaInicial.name
    )

    val pedidoViewModel: RealizarPedidoViewModel = viewModel ()

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
            startDestination = Pantallas.PantallaInicial.name,
            modifier = Modifier.padding(innerPadding)
        ){
            // Grafo de las rutas
            composable(route = Pantallas.PantallaInicial.name) {
                PantallaInicial(
                    onListarPedidoPulsado = {
                        navController.navigate(Pantallas.PantallaListaPedidos.name)
                    },
                    onRealizarPedidoPulsado = {
                        navController.navigate(Pantallas.PantallaRealizarPedido.name)
                        pedidoViewModel.reiniciarPedido() // Se reinicia el pedido cuando le das al boton
                    },
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            composable(route = Pantallas.PantallaListaPedidos.name) {
                PantallaListarPedidos(
                    onResumenPedidoPulsado = {
                        navController.navigate(Pantallas.PantallaResumenPedido.name)
                    },
                    modifier = Modifier
                        .fillMaxSize(),
                    viewModel = pedidoViewModel
                )
            }
            composable(route = Pantallas.PantallaRealizarPedido.name) {
                PantallaRealizarPedido(
                    onCancelarPulsado = {
                        navController.navigate(Pantallas.PantallaInicial.name)
                    },
                    onAceptarPulsado = {
                        navController.navigate(Pantallas.PantallaResumenPedido.name)
                    },
                    modifier = Modifier
                        .fillMaxSize(),
                    viewModel = pedidoViewModel
                )
            }
            composable(route = Pantallas.PantallaResumenPedido.name) {
                PantallaResumenPedido(
                    onCancelarPulsado = {
                        navController.navigate(Pantallas.PantallaRealizarPedido.name)
                    },
                    onPagarPulsado = {
                        navController.navigate(Pantallas.PantallaFormularioPago.name)
                    },
                    modifier = Modifier
                        .fillMaxSize(),
                    viewModel = pedidoViewModel
                )
            }
            composable(route = Pantallas.PantallaFormularioPago.name) {
                PantallaFormularioPago(
                    onCancelarPulsado = {
                        navController.navigate(Pantallas.PantallaRealizarPedido.name)
                    },
                    onAceptarPulsado = {
                        navController.navigate(Pantallas.PantallaResumenPago.name)
                    },
                    modifier = Modifier
                        .fillMaxSize(),
                    viewModel = pedidoViewModel
                )
            }
            composable(route = Pantallas.PantallaResumenPago.name) {
                PantallaResumenPago(
                    onEnviarPulsado = {
                        navController.navigate(Pantallas.PantallaInicial.name)
                    },
                    onAceptarPulsado = {
                        navController.navigate(Pantallas.PantallaInicial.name)
                    },
                    modifier = Modifier
                        .fillMaxSize(),
                    viewModel = pedidoViewModel
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