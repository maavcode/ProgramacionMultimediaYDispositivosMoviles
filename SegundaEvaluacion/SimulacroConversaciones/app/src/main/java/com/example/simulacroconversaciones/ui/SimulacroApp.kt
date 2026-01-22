package com.example.simulacroconversaciones.ui

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
import com.example.simulacroconversaciones.R
import com.example.simulacroconversaciones.ui.pantallas.PantallaConversacion
import com.example.simulacroconversaciones.ui.pantallas.PantallaInicio
import com.example.simulacroconversaciones.ui.viewmodel.SimulacroViewModel

enum class Pantallas (@StringRes val titulo: Int) {
    PantallaInicio (titulo = R.string.pantalla_inicio),
    PantallaConversacion(titulo = R.string.pantalla_conversacion)
}

@Composable
fun SimulacroApp(
    navController: NavHostController = rememberNavController()
) {
    val pilaRetroceso by navController.currentBackStackEntryAsState()
    // Pantalla Actual
    val pantallaActual = Pantallas.valueOf(
        pilaRetroceso?.destination?.route
            ?: Pantallas.PantallaInicio.name
    )
    // Obtengo el ViewModel
    val simulacroViewModel: SimulacroViewModel = viewModel(factory = SimulacroViewModel.Factory)
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
        ) {
            // GRAFO DE RUTAS
            /* EJEMPLO
            composable (route = Pantallas.PantallaInicio.name) {
                Log.d("TiendaViewModel", "Estado: ${tiendaViewModel.tiendaUIState}")
                PantallaInicio(
                    estado = tiendaViewModel.tiendaUIState,
                    onUsuarioPulsado = {
                        Log.d("","Usuario actualizado de ${tiendaViewModel.usuarioSeleccionado} a $it")
                        tiendaViewModel.actualizarUsuarioSeleccionado(it)
                        navController.navigate(route = Pantallas.PantallaUsuario.name)
                    },
                    onModificarProductos = {
                        tiendaViewModel.obtenerProductos()
                        navController.navigate(route = Pantallas.PantallaProductos.name)
                    },
                    onObtenerUsuarios = { tiendaViewModel.obtenerUsuarios() }
                )
            }
            composable (route = Pantallas.PantallaUsuario.name) {
                Log.d("TiendaViewModel", "Estado: ${tiendaViewModel.tiendaUIState}")
                PantallaUsuario(
                    usuario = tiendaViewModel.usuarioSeleccionado,
                    onListarPulsado = {
                        navController.navigate(route = Pantallas.PantallaProductosUsuario.name)
                    },
                    onAnyadirProductos = {
                        tiendaViewModel.obtenerProductos()
                        navController.navigate(route = Pantallas.PantallaAnyadirProductos.name)
                    }
                )
            }
            composable ( route = Pantallas.PantallaProductosUsuario.name ) {
                Log.d("TiendaViewModel", "Estado: ${tiendaViewModel.tiendaUIState}")
                PantallaProductosUsuario(
                    listaProductos = tiendaViewModel.usuarioSeleccionado.productos
                )
            }

            composable (route = Pantallas.PantallaAnyadirProductos.name) {
                PantallaAnyadirProductos(
                    estado = tiendaViewModel.productoUIState,
                    onAnyadirProducto = {
                        tiendaViewModel.anyadirProductoUsuario(producto = it)
                        navController.navigate(route = Pantallas.PantallaUsuario.name)
                    },
                    onObtenerProductos = {tiendaViewModel.obtenerProductos()}
                )
            }

            composable (route = Pantallas.PantallaProductos.name){
                PantallaProductos (
                    estado = tiendaViewModel.productoUIState,
                    onInsertarProducto = {
                        navController.navigate(route = Pantallas.PantallaInsertarProducto.name)
                    },
                    onModificarProducto = {
                        tiendaViewModel.actualizarProductoSeleccionado(it)
                        navController.navigate(route = Pantallas.PantallaModificarProductos.name)
                    },
                    onObtenerProductos = {
                        tiendaViewModel.obtenerProductos()
                    }
                )
            }

            composable (route = Pantallas.PantallaInsertarProducto.name){
                PantallaInsertarProducto (
                    onInsertarProducto = {
                        tiendaViewModel.insertarProducto(producto = it)
                        navController.navigate(route = Pantallas.PantallaProductos.name)
                    }
                )
            }
            composable (route = Pantallas.PantallaModificarProductos.name){
                PantallaModificarProductos (
                    producto = tiendaViewModel.productoSeleccionado,
                    onModificarProducto = {
                        tiendaViewModel.actualizarProducto(it)
                        navController.navigate(route = Pantallas.PantallaProductos.name)
                    }
                )
            }
             */
            composable (route = Pantallas.PantallaInicio.name) {
                PantallaInicio(
                    estado = simulacroViewModel.simulacroUIState,
                    cargarUsuarios = { simulacroViewModel.obtenerUsuarios() },
                    onPantallaConversacion = {
                        simulacroViewModel.actualizarUsuarioSeleccionado(it)
                        navController.navigate(route = Pantallas.PantallaConversacion.name)
                    }
                )
            }
            composable (route = Pantallas.PantallaConversacion.name){
                PantallaConversacion(
                    usuario = simulacroViewModel.usuarioSeleccionado,
                    onEscribirMensaje = {
                        simulacroViewModel.actualizarMensajesUsuario(it)
                    }
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