package com.example.playground_kotlin_pizzatime.models

import androidx.annotation.StringRes
import com.example.playground_kotlin_pizzatime.R

enum class DrinkType (@StringRes val title: Int){
    water(title = R.string.water),
    cola(title = R.string.cola),
    no_drink(title = R.string.no_drink)
}
data class Drink (
    val drinkId: Int,
    val drinkType: DrinkType = DrinkType.water,
    val drinkAmount: Int = 1
)