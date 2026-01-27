package com.example.plantillanavigationdrawer.datos.repositorios

import com.example.plantillanavigationdrawer.conexion.PlantillaServicioApi

interface PlantillaRepositorio {
    /* EJEMPLO
suspend fun obtenerProductos(): List<Producto>
suspend fun insertarProducto(id: String, producto: Producto): Producto
suspend fun actualizarProducto(id: String, producto: Producto): Producto
 */

}

class ConexionPlantillaRepositorio(
    private val plantillaServicioApi: PlantillaServicioApi
): PlantillaRepositorio{
    /* EJEMPLO
   override suspend fun obtenerProductos(): List<Producto> = tiendaServicioAPI.obtenerProductos()
   override suspend fun insertarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.insertarProducto(id, producto)
   override suspend fun actualizarProducto(id: String, producto: Producto): Producto = tiendaServicioAPI.actualizarProducto(id, producto)
    */

}