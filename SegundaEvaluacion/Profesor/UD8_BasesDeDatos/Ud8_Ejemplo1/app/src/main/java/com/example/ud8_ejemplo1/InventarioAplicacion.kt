package com.example.ud8_ejemplo1

import android.app.Application
import com.example.ud8_ejemplo1.datos.ContenedorApp
import com.example.ud8_ejemplo1.datos.ProductoContenedorApp

class InventarioAplicacion : Application() {
    lateinit var contenedor: ContenedorApp
    override fun onCreate() {
        super.onCreate()
        contenedor = ProductoContenedorApp(this)
    }
}