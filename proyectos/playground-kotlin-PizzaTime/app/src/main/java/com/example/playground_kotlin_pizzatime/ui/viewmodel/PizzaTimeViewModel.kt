package com.example.playground_kotlin_pizzatime.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.playground_kotlin_pizzatime.data.Data
import com.example.playground_kotlin_pizzatime.models.Drink
import com.example.playground_kotlin_pizzatime.models.DrinkType
import com.example.playground_kotlin_pizzatime.models.Order
import com.example.playground_kotlin_pizzatime.models.Payment
import com.example.playground_kotlin_pizzatime.models.Pizza
import com.example.playground_kotlin_pizzatime.models.PizzaSize
import com.example.playground_kotlin_pizzatime.models.uiState.PizzaTimeUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaTimeViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(PizzaTimeUIState())
    private val _orderList = mutableStateOf(Data().updateOrders())

    val listaPedidos: List<Order> get() = _orderList.value
    val uiState: StateFlow<PizzaTimeUIState> = _uiState.asStateFlow()

    fun addOrder(
        order: Order
    ){
        _uiState.update { currentOrder ->
            currentOrder.copy(
                orderList = currentOrder.orderList + order
            )
        }
    }

    fun updatePizza(updatedPizza: Pizza) {
        _uiState.update { currentState ->
            val cart = currentState.order.pizzaCart.toMutableList()
            val index = _uiState.value.order.pizzaCart.indexOfFirst { it.pizzaId == updatedPizza.pizzaId }
            if (index != -1) {
                cart[index] = updatedPizza
            }
            currentState.copy(
                order = currentState.order.copy(
                    pizzaCart = cart
                )
            )
        }

        updateTotalPrice()
    }

    fun updateDrink(updatedDrink: Drink) {
        _uiState.update { currentState ->
            val cart = currentState.order.drinkCart.toMutableList()
            val index = cart.indexOfFirst { it.drinkId == updatedDrink.drinkId }
            if (index != -1) {
                cart[index] = updatedDrink
            }
            currentState.copy(
                order = currentState.order.copy(
                    drinkCart = cart
                )
            )
        }

        updateTotalPrice()
    }

    fun updatePayment(
        payment: Payment
    ){
        _uiState.update { currentPayment ->
            currentPayment.copy(
                order = currentPayment.order.copy(
                    payment = payment
                )
            )
        }
    }

    fun updatePizzaCart(
        pizzaCart: List<Pizza>
    ){
        _uiState.update { currentPizzaCart ->
            currentPizzaCart.copy(
                order = currentPizzaCart.order.copy(
                    pizzaCart = pizzaCart,
                    // TODO() totalPrice =
                )
            )
        }
    }

    fun updateDrinkCart(
        drinkCart: List<Drink>
    ) {
        _uiState.update { currentDrinkCart ->
            currentDrinkCart.copy(
                order = currentDrinkCart.order.copy(
                    drinkCart = drinkCart,
                )
            )
        }
    }

    private fun updateTotalPrice() {
        _uiState.update { currentState ->

            val pizzasTotal = currentState.order.pizzaCart.sumOf { pizza ->
                val basePrice = when (pizza.pizzaSize) {
                    PizzaSize.small -> 4.95
                    PizzaSize.medium -> 6.95
                    PizzaSize.large -> 10.95
                }

                basePrice * pizza.pizzaAmount
            }

            val drinksTotal = currentState.order.drinkCart.sumOf { drink ->
                val drinkPrice = when (drink.drinkType) {
                    DrinkType.water -> 2.00
                    DrinkType.cola -> 2.50
                    DrinkType.no_drink -> 0.0
                }

                drinkPrice * drink.drinkAmount
            }

            currentState.copy(
                order = currentState.order.copy(
                    totalPrice = pizzasTotal + drinksTotal
                )
            )
        }
    }


}