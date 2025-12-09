package com.example.pdmtema6ejercicio1

import android.app.Application
import com.example.pdmtema6ejercicio1.datos.ContenedorApp
import com.example.pdmtema6ejercicio1.datos.StarWarsContenedorApp

class StarWarsAplicacion: Application() {
    lateinit var contenedor: ContenedorApp
    override fun onCreate() {
        super.onCreate()
        contenedor = StarWarsContenedorApp()
    }
}