package com.example.playground_kotlin_pizzatime.models

import androidx.annotation.DrawableRes

class Person (
    val idPersona: Int,
    val name: String,
    val email: String,
    val mobile: String,
    @DrawableRes val imageResourceId: Int,
)