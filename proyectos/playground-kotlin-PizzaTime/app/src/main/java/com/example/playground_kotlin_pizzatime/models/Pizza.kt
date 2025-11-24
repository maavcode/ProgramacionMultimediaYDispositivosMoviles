package com.example.playground_kotlin_pizzatime.models

import androidx.annotation.StringRes
import com.example.playground_kotlin_pizzatime.R

enum class PizzaType (@StringRes val title: Int){ // TODO() title
    barbacue (title = R.string.barbacue),
    roman (title = R.string.roman),
    margherita (title = R.string.margherita)
}
enum class PizzaSize (@StringRes val title: Int){ // TODO() title
    small (title = R.string.small),
    medium (title = R.string.medium),
    large (title = R.string.large)
}
enum class PizzaSubType (@StringRes val title: Int){ // TODO() title
    non (title = R.string.nothing),
    pork(title = R.string.pork),
    chicken_meat(title = R.string.chicken_meat),
    beef(title = R.string.beef),
    with_pineapple(title = R.string.with_pineapple),
    no_pineapple(title = R.string.without_pinneapple),
    vegan(title = R.string.vegan),
    no_vegan(title = R.string.no_vegan),
    with_mushroom(title = R.string.with_mushroom),
    no_mushroom(title = R.string.without_mushroom)
}
data class Pizza(
    val pizzaId: Int,
    val pizzaType: PizzaType = PizzaType.barbacue,
    val pizzaSubType: PizzaSubType = PizzaSubType.non,
    val pizzaSize: PizzaSize = PizzaSize.medium,
    val pizzaAmount: Int = 1
)