package com.example.playground_kotlin_pizzatime.data

import androidx.compose.runtime.Composable
import com.example.playground_kotlin_pizzatime.R
import com.example.playground_kotlin_pizzatime.models.Drink
import com.example.playground_kotlin_pizzatime.models.DrinkType
import com.example.playground_kotlin_pizzatime.models.Order
import com.example.playground_kotlin_pizzatime.models.Payment
import com.example.playground_kotlin_pizzatime.models.PaymentOptions
import com.example.playground_kotlin_pizzatime.models.Person
import com.example.playground_kotlin_pizzatime.models.Pizza
import com.example.playground_kotlin_pizzatime.models.PizzaSize
import com.example.playground_kotlin_pizzatime.models.PizzaSubType
import com.example.playground_kotlin_pizzatime.models.PizzaType

class Data {

    @Composable
    fun updatePersons(): List<Person> {
        return listOf(
            Person(
                idPersona = 1,
                name = "Mario Aguilar Avila",
                email = "mario.aguilar.dev@hotmail.com",
                mobile = "888888888",
                imageResourceId = R.drawable.uknownperson
            ),
            Person(
                idPersona = 2,
                name = "Carlos Martínez López",
                email = "carlosmartinezlopez@gmail.com",
                mobile = "612345678",
                imageResourceId = R.drawable.uknownperson
            )
        )
    }

    fun updatePizzas(): List<Pizza> {
        return listOf(
            Pizza(pizzaType = PizzaType.margherita, pizzaSubType = PizzaSubType.with_pineapple, pizzaSize = PizzaSize.large, pizzaAmount = 1, pizzaId = 0),
            Pizza(pizzaType = PizzaType.barbacue, pizzaSubType = PizzaSubType.pork, pizzaSize = PizzaSize.medium, pizzaAmount = 2, pizzaId = 0),
            Pizza(pizzaType = PizzaType.roman, pizzaSubType = PizzaSubType.no_pineapple, pizzaSize = PizzaSize.small, pizzaAmount = 1, pizzaId = 0),
            Pizza(pizzaType = PizzaType.margherita, pizzaSubType = PizzaSubType.vegan, pizzaSize = PizzaSize.small, pizzaAmount = 3, pizzaId = 0),
            Pizza(pizzaType = PizzaType.barbacue, pizzaSubType = PizzaSubType.chicken_meat, pizzaSize = PizzaSize.large, pizzaAmount = 1, pizzaId = 0),
            Pizza(pizzaType = PizzaType.roman, pizzaSubType = PizzaSubType.with_pineapple, pizzaSize = PizzaSize.medium, pizzaAmount = 2, pizzaId = 0),
            Pizza(pizzaType = PizzaType.margherita, pizzaSubType = PizzaSubType.no_vegan, pizzaSize = PizzaSize.large, pizzaAmount = 1, pizzaId = 0),
            Pizza(pizzaType = PizzaType.barbacue, pizzaSubType = PizzaSubType.beef, pizzaSize = PizzaSize.small, pizzaAmount = 2, pizzaId = 0),
            Pizza(pizzaType = PizzaType.roman, pizzaSubType = PizzaSubType.vegan, pizzaSize = PizzaSize.large, pizzaAmount = 1, pizzaId = 0),
            Pizza(pizzaType = PizzaType.margherita, pizzaSubType = PizzaSubType.no_mushroom, pizzaSize = PizzaSize.medium, pizzaAmount = 1, pizzaId = 0)
        )
    }

    fun updateDrinks(): List<Drink> {
        return listOf(
            Drink(drinkType = DrinkType.water, drinkAmount = 1, drinkId = 0),
            Drink(drinkType = DrinkType.cola, drinkAmount = 2, drinkId = 0),
            Drink(drinkType = DrinkType.no_drink, drinkAmount = 0, drinkId = 0)
        )
    }

    fun updatePayments(): List<Payment> {
        return listOf(
            Payment(paymentOption = PaymentOptions.visa, expeditionDate = "01/26", cvv = "123", cardNumber = "4111111111111111"),
            Payment(paymentOption = PaymentOptions.visa, expeditionDate = "02/26", cvv = "123", cardNumber = "4111111111111111"),
            Payment(paymentOption = PaymentOptions.visa, expeditionDate = "03/26", cvv = "123", cardNumber = "4111111111111111"),
            Payment(paymentOption = PaymentOptions.visa, expeditionDate = "04/26", cvv = "123", cardNumber = "4111111111111111"),
            Payment(paymentOption = PaymentOptions.visa, expeditionDate = "05/26", cvv = "123", cardNumber = "4111111111111111"),
            Payment(paymentOption = PaymentOptions.master_card, expeditionDate = "06/27", cvv = "456", cardNumber = "5500000000000004"),
            Payment(paymentOption = PaymentOptions.master_card, expeditionDate = "07/27", cvv = "456", cardNumber = "5500000000000004"),
            Payment(paymentOption = PaymentOptions.master_card, expeditionDate = "08/27", cvv = "456", cardNumber = "5500000000000004"),
            Payment(paymentOption = PaymentOptions.master_card, expeditionDate = "09/27", cvv = "456", cardNumber = "5500000000000004"),
            Payment(paymentOption = PaymentOptions.master_card, expeditionDate = "10/27", cvv = "456", cardNumber = "5500000000000004")
        )
    }

    fun updateOrders(): List<Order> {
        val pizzas = updatePizzas()
        val drinks = updateDrinks()
        val payments = updatePayments()

        return listOf(
            Order(pizzaCart = listOf(pizzas[0], pizzas[5],  pizzas[2]), drinkCart = listOf(drinks[0]), payment = payments[0], totalPrice = 12.95),
            Order(pizzaCart = listOf(pizzas[1]), drinkCart = listOf(drinks[1]), payment = payments[1], totalPrice = 18.90),
            Order(pizzaCart = listOf(pizzas[2]), drinkCart = listOf(drinks[2]), payment = payments[2], totalPrice = 4.95),
            Order(pizzaCart = listOf(pizzas[3]), drinkCart = listOf(drinks[0]), payment = payments[3], totalPrice = 17.85),
            Order(pizzaCart = listOf(pizzas[4]), drinkCart = listOf(drinks[1]), payment = payments[4], totalPrice = 13.45),
            Order(pizzaCart = listOf(pizzas[5]), drinkCart = listOf(drinks[2]), payment = payments[5], totalPrice = 13.90),
            Order(pizzaCart = listOf(pizzas[6]), drinkCart = listOf(drinks[0]), payment = payments[6], totalPrice = 12.95),
            Order(pizzaCart = listOf(pizzas[7]), drinkCart = listOf(drinks[1]), payment = payments[7], totalPrice = 14.90),
            Order(pizzaCart = listOf(pizzas[8]), drinkCart = listOf(drinks[0]), payment = payments[8], totalPrice = 12.95),
            Order(pizzaCart = listOf(pizzas[9]), drinkCart = listOf(drinks[2]), payment = payments[9], totalPrice = 6.95)
        )
    }
}