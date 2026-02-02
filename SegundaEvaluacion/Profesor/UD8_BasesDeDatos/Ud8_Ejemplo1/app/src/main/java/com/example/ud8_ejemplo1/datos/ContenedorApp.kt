package com.example.ud8_ejemplo1.datos

import android.content.Context
import com.example.ud8_ejemplo1.conexion.InventarioBaseDatos

interface ContenedorApp {
    val productoRepositorio: ProductoRepositorio
}

class ProductoContenedorApp(private val context: Context) : ContenedorApp {

    override val productoRepositorio: ProductoRepositorio by lazy {
        ConexionProductoRepositorio(InventarioBaseDatos.obtenerBaseDatos(context).inventarioDao())
    }
}