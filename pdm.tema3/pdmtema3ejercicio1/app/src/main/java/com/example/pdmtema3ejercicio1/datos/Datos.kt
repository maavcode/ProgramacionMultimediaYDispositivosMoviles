package com.example.pdmtema3ejercicio1.datos

import com.example.pdmtema3ejercicio1.modelo.Bandera

data class Datos{
    fun cargarBanderas(): List<Bandera> = ListOf(
        Bandera(),
        Bandera(),
        Bandera(),
        Bandera(),
        Bandera()
    )
}
