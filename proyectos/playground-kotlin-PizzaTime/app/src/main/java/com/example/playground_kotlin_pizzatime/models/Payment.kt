package com.example.playground_kotlin_pizzatime.models

import androidx.annotation.StringRes
import com.example.playground_kotlin_pizzatime.R

enum class PaymentOptions(@StringRes val title: Int){
    visa (title = R.string.visa),
    master_card (title = R.string.mastercard),
    euro_6000 (title = R.string.euro_6000)
}

data class Payment(
    val paymentOption: PaymentOptions = PaymentOptions.visa,
    val expeditionDate: String = "",
    val cvv: String = "",
    val cardNumber: String = "",
)
