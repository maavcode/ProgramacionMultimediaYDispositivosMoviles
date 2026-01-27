package com.example.serverjsonexamen01

import android.app.Application
import com.example.serverjsonexamen01.datos.ContenedorApp

import com.example.serverjsonexamen01.datos.IContenedorApp

class ExamenAplicacion : Application(){
    lateinit var contenedor: IContenedorApp
    override fun onCreate() {
        super.onCreate()
        contenedor = ContenedorApp()
    }
}