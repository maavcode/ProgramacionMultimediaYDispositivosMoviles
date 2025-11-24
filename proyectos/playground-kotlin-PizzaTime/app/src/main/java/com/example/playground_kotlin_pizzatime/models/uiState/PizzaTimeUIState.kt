package com.example.playground_kotlin_pizzatime.models.uiState

import com.example.playground_kotlin_pizzatime.models.Order

data class PizzaTimeUIState (
    val order: Order = Order(),
    val orderList: List<Order> = emptyList()
)