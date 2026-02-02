package com.example.ud8_ejemplo1.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Productos")
data class Producto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val precio: Double,
    val cantidad: Int
)
