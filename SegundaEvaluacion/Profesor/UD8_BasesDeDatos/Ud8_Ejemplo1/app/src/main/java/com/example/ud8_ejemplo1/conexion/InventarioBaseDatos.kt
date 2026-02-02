package com.example.ud8_ejemplo1.conexion

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ud8_ejemplo1.dao.InventarioDao
import com.example.ud8_ejemplo1.modelo.Producto

@Database(entities = [Producto::class], version = 1, exportSchema = false)
abstract class InventarioBaseDatos: RoomDatabase() {

    abstract fun inventarioDao(): InventarioDao

    companion object {
        @Volatile
        private var Instance: InventarioBaseDatos? = null

        fun obtenerBaseDatos(context: Context): InventarioBaseDatos {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, InventarioBaseDatos::class.java, "inventariodb")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}