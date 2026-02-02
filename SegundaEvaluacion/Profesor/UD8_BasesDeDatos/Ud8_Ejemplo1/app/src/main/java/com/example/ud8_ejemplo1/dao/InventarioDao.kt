package com.example.ud8_ejemplo1.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ud8_ejemplo1.modelo.Producto

@Dao
interface InventarioDao {
    @Query("SELECT * from Productos WHERE id = :id")
    suspend fun obtenerProducto(id: Int): Producto

    @Query("SELECT * from Productos ORDER BY nombre ASC")
    suspend fun obtenerTodosProductos(): List<Producto>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertar(producto: Producto)

    @Update
    suspend fun actualizar(producto: Producto)

    @Delete
    suspend fun eliminar(producto: Producto)
}