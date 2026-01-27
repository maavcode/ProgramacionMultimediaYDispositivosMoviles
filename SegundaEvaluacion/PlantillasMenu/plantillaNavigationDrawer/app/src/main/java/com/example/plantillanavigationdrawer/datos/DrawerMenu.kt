package com.example.plantillanavigationdrawer.datos

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerMenu(
    val icono: ImageVector,
    @StringRes val titulo: Int,
    val ruta: String
)