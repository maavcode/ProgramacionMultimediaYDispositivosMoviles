package com.example.pdmtema3ejercicio1.modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Bandera(
    // Dos IDs, uno para el texto de la bandera y otro para la imagen
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
