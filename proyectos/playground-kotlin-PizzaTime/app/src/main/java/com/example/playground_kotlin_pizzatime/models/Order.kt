package com.example.playground_kotlin_pizzatime.models

data class Order(
    val pizzaCart: List<Pizza> = listOf(Pizza( pizzaId = 0)),
    val drinkCart: List<Drink> = listOf(Drink( drinkId = 0)),
    val payment: Payment = Payment(),
    val totalPrice: Double = 0.0
)