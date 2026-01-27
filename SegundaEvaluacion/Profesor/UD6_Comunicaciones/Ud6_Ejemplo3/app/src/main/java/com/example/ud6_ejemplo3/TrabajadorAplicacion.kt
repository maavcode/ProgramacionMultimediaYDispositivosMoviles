package com.example.ud6_ejemplo3

import android.app.Application
import com.example.ud6_ejemplo3.datos.ContenedorApp
import com.example.ud6_ejemplo3.datos.TrabajadorContenedorApp

class TrabajadorAplicacion : Application() {
    lateinit var contenedor: ContenedorApp
    override fun onCreate() {
        super.onCreate()
        contenedor = TrabajadorContenedorApp()
    }
}