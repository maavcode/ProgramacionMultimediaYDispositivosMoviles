package com.example.simulacroconversaciones

import android.app.Application
import com.example.simulacroconversaciones.datos.ContenedorApp
import com.example.simulacroconversaciones.datos.IContenedorApp

class SimulacroAplicacion : Application(){
    lateinit var contenedor: IContenedorApp
    override fun onCreate() {
        super.onCreate()
        contenedor = ContenedorApp()
    }
}