package com.example.plantillanavigationdrawer

import android.app.Application
import com.example.plantillanavigationdrawer.datos.ContenedorApp
import com.example.plantillanavigationdrawer.datos.IContenedorApp

class PlantillaAplicacion : Application(){
    lateinit var contenedor: IContenedorApp
    override fun onCreate() {
        super.onCreate()
        contenedor = ContenedorApp()
    }
}