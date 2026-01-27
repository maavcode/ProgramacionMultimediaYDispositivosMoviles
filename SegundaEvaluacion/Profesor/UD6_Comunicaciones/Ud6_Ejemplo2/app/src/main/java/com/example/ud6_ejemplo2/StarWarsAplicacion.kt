package com.example.ud6_ejemplo2

import android.app.Application
import com.example.ud6_ejemplo2.datos.ContenedorApp
import com.example.ud6_ejemplo2.datos.StarWarsContenedorApp

class StarWarsAplicacion : Application() {
    lateinit var contenedor: ContenedorApp
    override fun onCreate() {
        super.onCreate()
        contenedor = StarWarsContenedorApp()
    }
}