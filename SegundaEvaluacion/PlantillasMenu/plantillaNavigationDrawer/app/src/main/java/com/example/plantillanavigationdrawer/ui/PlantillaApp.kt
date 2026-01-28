package com.example.plantillanavigationdrawer.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.plantillanavigationdrawer.R
import com.example.plantillanavigationdrawer.datos.DrawerMenu
import com.example.plantillanavigationdrawer.ui.pantallas.PantallaInicio
import com.example.plantillanavigationdrawer.ui.pantallas.PantallaInsertar
import com.example.plantillanavigationdrawer.ui.pantallas.PantallaListar
import com.example.plantillanavigationdrawer.ui.viewmodel.PlantillaViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

enum class Pantallas(@StringRes val titulo: Int) {
    PantallaInicio(titulo = R.string.pantalla_incio),
    PantallaInsertarUsuario(titulo = R.string.pantalla_insertar_usuario),
    PantallaInsertarReserva(titulo = R.string.pantalla_insertar_reserva)
}

val menu = arrayOf(
    DrawerMenu(Icons.Filled.Face, Pantallas.PantallaInicio.titulo, Pantallas.PantallaInicio.name),
    DrawerMenu(Icons.Filled.Add, Pantallas.PantallaInsertarUsuario.titulo, Pantallas.PantallaInsertarUsuario.name)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantillaApp(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),

){
    val pilaRetroceso by navController.currentBackStackEntryAsState()

    val pantallaActual = Pantallas.valueOf(
        pilaRetroceso?.destination?.route ?: Pantallas.PantallaInicio.name
    )

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val plantillaViewModel: PlantillaViewModel = viewModel(factory = PlantillaViewModel.Factory)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerContent(
                    menu = menu,
                    pantallaActual = pantallaActual
                ) { ruta ->
                    coroutineScope.launch {
                        drawerState.close()
                    }

                    navController.navigate(ruta)
                }
            }
        },
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    pantallaActual = pantallaActual,
                    drawerState = drawerState,

                    navController = navController,
                    scrollBehavior = scrollBehavior
                )
            },
            floatingActionButton = {
                if(pantallaActual == Pantallas.PantallaInsertarReserva) {
                    FloatingActionButton(
                        onClick = {
                            navController.navigate(route = Pantallas.PantallaInsertarUsuario.name)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = stringResource(R.string.texto_insertar_usuario)
                        )
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = Pantallas.PantallaInicio.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                // Grafo de las rutas
                composable (route = Pantallas.PantallaInicio.name) {
                    PantallaInicio(
                        estado = plantillaViewModel.plantillaUIState,
                        obtenerUsuarios = {plantillaViewModel.obtenerUsuarios()}
                    )
                }
                composable (route = Pantallas.PantallaInsertarUsuario.name) {
                    PantallaInsertar(

                    )
                }
            }
        }
    }
}

@Composable
private fun DrawerContent(
    menu: Array<DrawerMenu>,
    pantallaActual: Pantallas,
    onMenuClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.size(150.dp),
                imageVector = Icons.Filled.AccountCircle,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        menu.forEach {
            NavigationDrawerItem(
                label = { Text(text = stringResource(id = it.titulo)) },
                icon = { Icon(imageVector = it.icono, contentDescription = null) },
                selected = it.titulo == pantallaActual.titulo,
                onClick = {
                    onMenuClick(it.ruta)
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    pantallaActual: Pantallas,
    drawerState: DrawerState?,
    modifier: Modifier = Modifier,

    navController: NavHostController,
    scrollBehavior: TopAppBarScrollBehavior
){
    val coroutineScope = rememberCoroutineScope()

    var mostrarMenu by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = stringResource(id = pantallaActual.titulo)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if (drawerState != null) {
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = stringResource(id = R.string.atras)
                    )
                }
            }
        },
        actions = {
            if(pantallaActual == Pantallas.PantallaInsertarUsuario) {
                IconButton(onClick = { mostrarMenu = true }) {
                    Icon(
                        imageVector = Icons.Outlined.MoreVert,
                        contentDescription = stringResource(R.string.abrir_menu)
                    )
                }
                DropdownMenu(
                    expanded = mostrarMenu,
                    onDismissRequest = { mostrarMenu = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(text = stringResource(id = R.string.pantalla_incio)) },
                        onClick = {
                            mostrarMenu = false
                            navController.navigate(Pantallas.PantallaInicio.name)
                        }
                    )
                }
            }
        },
        modifier = modifier
    )
}