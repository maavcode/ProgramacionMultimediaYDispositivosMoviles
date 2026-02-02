package com.example.ud8_ejemplo1.datos

import com.example.ud8_ejemplo1.dao.InventarioDao
import com.example.ud8_ejemplo1.modelo.Producto

interface ProductoRepositorio {
    suspend fun obtenerProducto(id: Int): Producto
    suspend fun obtenerTodosProductos(): List<Producto>
    suspend fun insertar(producto: Producto)
    suspend fun actualizar(producto: Producto)
    suspend fun eliminar(producto: Producto)
}

class ConexionProductoRepositorio(
    private val inventarioDao: InventarioDao
): ProductoRepositorio {
    override suspend fun obtenerProducto(id: Int): Producto = inventarioDao.obtenerProducto(id)
    override suspend fun obtenerTodosProductos(): List<Producto> = inventarioDao.obtenerTodosProductos()
    override suspend fun insertar(producto: Producto) = inventarioDao.insertar(producto)
    override suspend fun actualizar(producto: Producto) = inventarioDao.actualizar(producto)
    override suspend fun eliminar(producto: Producto) = inventarioDao.eliminar(producto)
}