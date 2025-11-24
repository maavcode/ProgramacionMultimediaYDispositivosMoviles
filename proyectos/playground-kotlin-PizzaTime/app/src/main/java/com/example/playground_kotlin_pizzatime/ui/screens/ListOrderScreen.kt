package com.example.playground_kotlin_pizzatime.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.playground_kotlin_pizzatime.R
import com.example.playground_kotlin_pizzatime.models.Order
import com.example.playground_kotlin_pizzatime.ui.viewmodel.PizzaTimeViewModel

@Composable
fun ListOrderScreen (
    modifier: Modifier = Modifier,
    viewModel: PizzaTimeViewModel
){
    val orderList = viewModel.listaPedidos
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.order_list),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
            )

            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp
            )
        }

        items(orderList) { currentOrder ->
            TarjetaPedido(
                order = currentOrder,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun TarjetaPedido (
    order: Order,
    modifier: Modifier,
){
    var expanded by remember { mutableStateOf(false) }
    Card (
        modifier = Modifier
            .width(350.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Pedido: "
                        + order.pizzaCart.sumOf { it.pizzaAmount } + stringResource(R.string.pizzas) +
                        " " +
                        + order.drinkCart.sumOf { it.drinkAmount } + stringResource(R.string.drinks) +
                        "| Total: " + order.totalPrice
            )
            Button(
                onClick = { expanded = !expanded }
            ) {
                Text(
                    text = stringResource(R.string.order_summary)
                )
            }
        }

        if (expanded) {
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = stringResource(R.string.pizza) + ":",
                    fontSize = 18.sp
                )
                order.pizzaCart.forEach { pizza ->
                    Text(
                        text = "\uD83C\uDF55" + pizza.pizzaAmount + "x " + stringResource(pizza.pizzaType.title) + " - " + pizza.pizzaSize
                    )
                    Text(
                        text = "Subtypes: " + stringResource(pizza.pizzaSubType.title)
                    )
                }

                Text(
                    text = stringResource(R.string.drink) + ":",
                    fontSize = 18.sp
                )
                order.drinkCart.forEach { drink ->
                    Text(
                        "\uD83E\uDD64" + drink.drinkAmount + "x"  + stringResource(drink.drinkType.title)
                    )
                }

                Text(
                    text = stringResource(R.string.payment) + ":",
                    fontSize = 18.sp
                )

                Text("💳 Pago con ${order.payment.paymentOption}")
                Text("💰 Total: ${order.totalPrice} €")
            }

        }
    }
}