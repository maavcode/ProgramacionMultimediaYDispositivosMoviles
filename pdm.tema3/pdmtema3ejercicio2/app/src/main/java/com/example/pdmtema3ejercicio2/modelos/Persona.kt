package com.example.pdmtema3ejercicio2.modelos

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Persona (
    @StringRes val stringResourceNameId: Int,
    @StringRes val stringResourceDniId: Int,
    @StringRes val stringResourceTelefonoId: Int,
    @StringRes val stringResourceIdId: Int,
    @DrawableRes val imageResourceId: Int
)