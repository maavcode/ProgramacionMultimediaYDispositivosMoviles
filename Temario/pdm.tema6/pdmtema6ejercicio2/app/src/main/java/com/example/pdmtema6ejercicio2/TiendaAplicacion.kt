package com.example.pdmtema6ejercicio2

import android.app.Application
import com.example.pdmtema6ejercicio2.datos.ContenedorApp
import com.example.pdmtema6ejercicio2.datos.TiendaContenedorApp

class TiendaAplicacion: Application(){
    lateinit var contenedor: ContenedorApp
    override fun onCreate() {
        super.onCreate()
        contenedor = TiendaContenedorApp()
    }
}