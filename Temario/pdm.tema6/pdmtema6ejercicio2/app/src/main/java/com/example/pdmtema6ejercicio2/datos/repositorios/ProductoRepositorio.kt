package com.example.pdmtema6ejercicio2.datos.repositorios

import com.example.pdmtema6ejercicio2.conexion.TiendaServicioAPI
import com.example.pdmtema6ejercicio2.modelo.Producto
import com.example.pdmtema6ejercicio2.modelo.Usuario

interface ProductoRepositorio {

}

class ConexionProductoRepositorio(
    private val tiendaServicioAPI: TiendaServicioAPI
): ProductoRepositorio {

}
