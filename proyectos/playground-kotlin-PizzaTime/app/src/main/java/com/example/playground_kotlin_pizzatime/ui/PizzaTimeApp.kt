package com.example.playground_kotlin_pizzatime.ui

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
import com.example.playground_kotlin_pizzatime.R
import com.example.playground_kotlin_pizzatime.ui.screens.IndexScreen
import com.example.playground_kotlin_pizzatime.ui.screens.ListOrderScreen
import com.example.playground_kotlin_pizzatime.ui.screens.MakePaymentScreen
import com.example.playground_kotlin_pizzatime.ui.screens.OrderSummaryScreen
import com.example.playground_kotlin_pizzatime.ui.screens.PaymentSummaryScreen
import com.example.playground_kotlin_pizzatime.ui.screens.PlaceOrderScreen
import com.example.playground_kotlin_pizzatime.ui.viewmodel.PizzaTimeViewModel


enum class Pantallas(@StringRes val title: Int){
    IndexScreen (title = R.string.index_screen),
    ListOrderScreen (title = R.string.list_order_screen),
    PlaceOrderScreen (title = R.string.place_order_screen),
    OrderSummaryScreen (title = R.string.order_summary_screen),
    MakePaymentScreen (title = R.string.make_payment_screen),
    PaymentSummaryScreen (title = R.string.payment_summary_screen),

    // ADD SCREENS
}


@Composable
fun PizzaTimeApp (
    navController: NavHostController = rememberNavController()
){
    // In the Index will not appear the back button
    val pilaRetroceso by navController.currentBackStackEntryAsState()

    val pantallaActual = Pantallas.valueOf(
        pilaRetroceso?.destination?.route ?: Pantallas.IndexScreen.name
    )

    val pizzaTimeViewModel: PizzaTimeViewModel = viewModel()

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
            startDestination = Pantallas.IndexScreen.name, // IMPORTANTE EL .NAME
            modifier = Modifier.padding(innerPadding)
        ){
            // ROUTES
            composable ( route = Pantallas.IndexScreen.name ){ // Important the .name
                IndexScreen(
                    onListOrderButton = {
                        navController.navigate(Pantallas.ListOrderScreen.name)
                    },
                    onPlaceOrderButton = {
                        navController.navigate(Pantallas.PlaceOrderScreen.name)
                    }
                )
            }
            composable ( route = Pantallas.ListOrderScreen.name ){ // Poner la pantalla buena
                ListOrderScreen(
                   viewModel = pizzaTimeViewModel
                )
            }
            composable ( route = Pantallas.PlaceOrderScreen.name ){ // Poner la pantalla buena
                PlaceOrderScreen(
                    onCancel = {
                        navController.navigate(Pantallas.IndexScreen.name)
                    },
                    onAccept = {
                        navController.navigate(Pantallas.OrderSummaryScreen.name)
                    },
                    viewModel = pizzaTimeViewModel
                )
            }
            composable ( route = Pantallas.OrderSummaryScreen.name ){ // Poner la pantalla buena
                OrderSummaryScreen(
                    onCancel = {
                        navController.navigate(Pantallas.PlaceOrderScreen.name)
                    },
                    onMakePayment = {
                        navController.navigate(Pantallas.MakePaymentScreen.name)
                    },
                    // TODO () viewModel = ejemploViewModel // El cual he declarado antes
                )
            }
            composable ( route = Pantallas.MakePaymentScreen.name ){ // Poner la pantalla buena
                MakePaymentScreen(
                    onCancel = {
                        navController.navigate(Pantallas.PlaceOrderScreen.name)
                    },
                    onAccept = {
                        navController.navigate(Pantallas.MakePaymentScreen.name)
                    },
                    // TODO () viewModel = ejemploViewModel // El cual he declarado antes
                )
            }
            composable ( route = Pantallas.PaymentSummaryScreen.name ){ // Poner la pantalla buena
                PaymentSummaryScreen(
                    onSend = {
                        navController.navigate(Pantallas.PlaceOrderScreen.name)
                        // TODO() email send
                    },
                    onAccept = {
                        navController.navigate(Pantallas.MakePaymentScreen.name)
                    },
                    // TODO () viewModel = ejemploViewModel // El cual he declarado antes
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
        title = { Text(text = stringResource(id = pantallaActual.title)) },
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
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
            }
        },
        modifier = modifier
    )
}