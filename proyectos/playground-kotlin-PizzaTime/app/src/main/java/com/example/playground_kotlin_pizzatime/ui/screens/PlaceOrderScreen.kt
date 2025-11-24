package com.example.playground_kotlin_pizzatime.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.util.copy
import com.example.playground_kotlin_pizzatime.R
import com.example.playground_kotlin_pizzatime.models.DrinkType
import com.example.playground_kotlin_pizzatime.models.PizzaSize
import com.example.playground_kotlin_pizzatime.models.PizzaSubType
import com.example.playground_kotlin_pizzatime.models.PizzaType
import com.example.playground_kotlin_pizzatime.models.uiState.PizzaTimeUIState
import com.example.playground_kotlin_pizzatime.ui.viewmodel.PizzaTimeViewModel

@Composable
fun PlaceOrderScreen(
    onAccept: () -> Unit,
    onCancel: () -> Unit,
    viewModel: PizzaTimeViewModel,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()
    var currentPizza by remember { mutableStateOf(0) }
    var currentDrink by remember { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp), modifier = modifier
    ) {

        Row (

        ){
            Text(
                text = stringResource(R.string.place_order),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )

            // PizzaCart control
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (currentPizza > 0) {
                    Button(
                        onClick = {
                            currentPizza = currentPizza - 1
                        },
                    ) {
                        Text("<-")
                    }
                }

                Text(
                    text = currentPizza.toString()
                )


            }
            Button(
                onClick = { currentPizza = currentPizza + 1 },
            ) {
                Text("->")
            }

        }


        HorizontalDivider(
            color = Color.Gray, thickness = 1.dp
        )



        Text(
            modifier = Modifier.fillMaxWidth(),
            text = " ${stringResource(R.string.total)} ${"%.2f".format(uiState.order.totalPrice)}",
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min) // para que la altura se ajuste al contenido
        ) {


            // Columna Izquierda
            Column(
                modifier = Modifier
                    .weight(1f)
                    .selectableGroup()
            ) {
                Text(
                    text = stringResource(R.string.pizza),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )

                val radioOptions = listOf(
                    PizzaType.roman,
                    PizzaType.barbacue,
                    PizzaType.margherita
                )
                radioOptions.forEach { radioOption ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    ) {

                        RadioButton(
                            selected = (radioOption == uiState.order.pizzaCart[currentPizza].pizzaType),
                            onClick = {
                                viewModel.updatePizza(
                                    uiState.order.pizzaCart[currentPizza].copy(pizzaType = radioOption)
                                )
                            }
                        )

                        Text(
                            text = stringResource(radioOption.title),
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }


            }

            // Columna Derecha
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),

                ) {

                    Column(

                    ) {
                        Text(
                            text = stringResource(R.string.pizza_options), fontSize = 20.sp
                        )
                        OpcionesPizza(
                            pizzaType = uiState.order.pizzaCart[currentPizza].pizzaType,
                            uiState = uiState,
                            viewModel = viewModel,
                            currentPizza = currentPizza
                        )
                    }



                }
        }

            Row(
                modifier = Modifier
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(
                        text = stringResource(R.string.amount)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        if (uiState.order.pizzaCart[currentPizza].pizzaAmount > 0) {
                            Button(
                                onClick = {
                                    viewModel.updatePizza( uiState.order.pizzaCart[currentPizza].copy(pizzaAmount = uiState.order.pizzaCart[currentPizza].pizzaAmount - 1))
                                }) {
                                Text("-")
                            }
                        }

                        Text(
                            text = uiState.order.pizzaCart[currentPizza].pizzaAmount.toString()
                        )

                        Button(
                            onClick = { viewModel.updatePizza( uiState.order.pizzaCart[currentPizza].copy(pizzaAmount = uiState.order.pizzaCart[currentPizza].pizzaAmount + 1)) },
                        ) {
                            Text("+")
                        }
                    }


                }
            }
            HorizontalDivider(
                color = Color.Gray, thickness = 1.dp
            )





                Text(
                    text = stringResource(R.string.pizza_size),
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
                val opciones = listOf(
                    PizzaSize.small,
                    PizzaSize.medium,
                    PizzaSize.large
                )

                opciones.forEach { option ->


                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .clickable {
                                viewModel.updatePizza(uiState.order.pizzaCart[currentPizza].copy(pizzaSize = option))
                            }) {
                        Checkbox(
                            checked = (uiState.order.pizzaCart[currentPizza].pizzaSize == option),
                            onCheckedChange = {
                                viewModel.updatePizza(uiState.order.pizzaCart[currentPizza].copy(pizzaSize = option))
                            })
                        Text(
                            text = stringResource(option.title), modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }



                HorizontalDivider(
                    color = Color.Gray, thickness = 1.dp
                )





            Text(
                text = stringResource(R.string.drink),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val listaBebidas = listOf(
                    DrinkType.water,
                    DrinkType.cola,
                    DrinkType.no_drink
                )

                listaBebidas.forEach { drink ->

                    Button(
                        onClick = {
                            viewModel.updateDrink( uiState.order.drinkCart[currentDrink].copy( drinkType = drink))
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (uiState.order.drinkCart[currentDrink].drinkType == drink) Color(0xFF4CAF50) else Color.Gray
                        ),
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(text = stringResource(drink.title))
                    }
                }

            }
            if (uiState.order.drinkCart[currentDrink].drinkType != DrinkType.no_drink) {
                Row(
                    modifier = Modifier
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Text(
                            text = stringResource(R.string.amount)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            if (uiState.order.drinkCart[currentDrink].drinkAmount > 0) {
                                Button(
                                    onClick = {
                                        viewModel.updateDrink( uiState.order.drinkCart[currentDrink].copy(drinkAmount = uiState.order.drinkCart[currentDrink].drinkAmount - 1))
                                    },
                                ) {
                                    Text("-")
                                }
                            }

                            Text(
                                text = uiState.order.drinkCart[currentDrink].drinkAmount.toString()
                            )

                            Button(
                                onClick = {
                                    viewModel.updateDrink( uiState.order.drinkCart[currentDrink].copy(drinkAmount = uiState.order.drinkCart[currentDrink].drinkAmount + 1))
                                },
                            ) {
                                Text("+")
                            }
                        }
                    }
                }
            }







            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Button(onClick = onCancel) {
                        Text(stringResource(R.string.cancel))
                    }
                    Button(onClick = onAccept) {
                        Text(stringResource(R.string.accept))
                    }
                }
            }



    }

}

@Composable
fun OpcionesPizza(
    modifier: Modifier = Modifier,
    pizzaType: PizzaType,
    uiState: PizzaTimeUIState,
    viewModel: PizzaTimeViewModel,
    currentPizza: Int,
) {
    // Segun el tipo de pizza de doy unas opciones u otras
    val radioOptions: List<PizzaSubType> = when (pizzaType) {
        PizzaType.roman -> listOf(
            PizzaSubType.with_mushroom,
            PizzaSubType.no_mushroom
        )

        PizzaType.barbacue -> listOf(
            PizzaSubType.pork,
            PizzaSubType.chicken_meat,
            PizzaSubType.beef,
        )

        PizzaType.margherita -> listOf(
            PizzaSubType.with_pineapple,
            PizzaSubType.no_pineapple,
            PizzaSubType.vegan,
        )
    }

    radioOptions.forEach { radioOption ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            RadioButton(
                onClick = {
                    viewModel.updatePizza( uiState.order.pizzaCart[currentPizza].copy(pizzaSubType = radioOption))
                },
                selected = (radioOption == uiState.order.pizzaCart[currentPizza].pizzaSubType),
            )
            Text(
                text = stringResource(radioOption.title), modifier = Modifier.padding(start = 10.dp)
            )
        }
    }
}