package com.example.pdmtema6ejercicio2.datos.repositorios

import com.example.pdmtema6ejercicio2.conexion.TiendaServicioAPI
import com.example.pdmtema6ejercicio2.modelo.Producto
import com.example.pdmtema6ejercicio2.modelo.Usuario

interface ProductoRepositorio {
    suspend fun obtenerProductos(): List<Producto>
    suspend fun insertarProducto(id: String, producto: Producto): Producto
    suspend fun actualizarProducto(id: String, producto: Producto): Producto
}

class ConexionProductoRepositorio(
    private val tiendaServicioAPI: TiendaServicioAPI
): ProductoRepositorio {
    override suspend fun obtenerProductos(): List<Producto> = tiendaServicioAPI.obtenerProductos()
    override suspend fun insertarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.insertarProducto(id, producto)
    override suspend fun actualizarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.actualizarProducto(id, producto)
}
