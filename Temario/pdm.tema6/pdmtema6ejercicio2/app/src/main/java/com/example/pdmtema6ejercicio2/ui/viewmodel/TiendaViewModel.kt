package com.example.pdmtema6ejercicio2.ui.viewmodel

import android.net.http.HttpException
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pdmtema6ejercicio2.TiendaAplicacion
import com.example.pdmtema6ejercicio2.datos.repositorios.ProductoRepositorio
import com.example.pdmtema6ejercicio2.datos.repositorios.UsuarioRepositorio
import com.example.pdmtema6ejercicio2.modelo.Producto
import com.example.pdmtema6ejercicio2.modelo.Usuario
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface TiendaUIState {
    // EXITOS
    data class ObtenerExito(val listaUsuarios: List<Usuario>) : TiendaUIState
    data class ActualizarExito(val usuario: Usuario) : TiendaUIState

    // Otros estados
    object Cargando : TiendaUIState
    object Error : TiendaUIState
}

sealed interface ProductosUIState {
    // EXITOS
    data class ObtenerExito(val listaProductos: List<Producto>): ProductosUIState;
    data class InsertarExito(val producto: Producto): ProductosUIState
    // Otros estados
    object Cargando : ProductosUIState
    object Error : ProductosUIState
}


class TiendaViewModel (
    // Añadir repositorios
    private val usuarioRepositorio: UsuarioRepositorio,
    private val productoRepositorio: ProductoRepositorio
): ViewModel() {
    var tiendaUIState: TiendaUIState by mutableStateOf(TiendaUIState.Cargando)
        private set
    var productoUIState: ProductosUIState by mutableStateOf(ProductosUIState.Cargando)
        private set

    var usuarioSeleccionado: Usuario by mutableStateOf(Usuario("","","","",listOf()))
        private set

    // IMPORTANTE TRABAJAR CON MODELOS
    fun actualizarUsuarioSeleccionado(usuario: Usuario){
        usuarioSeleccionado = usuario
    }

    init {
        obtenerUsuarios()
    }

    fun obtenerUsuarios(){
        viewModelScope.launch {
            // Me aseguro de que esta en cargando el estado
            tiendaUIState = TiendaUIState.Cargando

            tiendaUIState = try {
                // Obtengo el usuario
                val listaUsuarios = usuarioRepositorio.obtenerUsuarios()
                Log.d("TiendaViewModel", "Usuarios recibidos: $listaUsuarios")
                TiendaUIState.ObtenerExito(listaUsuarios)
            } catch (e: Exception){
                Log.e("TiendaViewModel", "Error al obtener los usuarios", e)
                TiendaUIState.Error
            }

        }
    }

    fun obtenerProductos(){
        viewModelScope.launch {
            // Me aseguro de que esta en cargando el estado
            productoUIState = ProductosUIState.Cargando

            productoUIState = try {
                // Obtengo el usuario
                val listaProductos = productoRepositorio.obtenerProductos()
                Log.d("TiendaViewModel", "Usuarios recibidos: $listaProductos")
                ProductosUIState.ObtenerExito(listaProductos)
            } catch (e: Exception){
                Log.e("TiendaViewModel", "Error al obtener los productos", e)
                ProductosUIState.Error
            }

        }
    }

    fun anyadirProductoUsuario (producto: Producto) {
        viewModelScope.launch {
            // Me aseguro de que esta en cargando el estado
            tiendaUIState = TiendaUIState.Cargando

            val usuarioActualizado = usuarioSeleccionado.copy(
                productos = usuarioSeleccionado.productos + producto
            )
            actualizarUsuarioSeleccionado(usuarioActualizado)

            tiendaUIState = try {

                usuarioRepositorio.actualizarUsuario(usuarioSeleccionado.id, usuarioSeleccionado)
                Log.d("EXITO", "Usuario: $usuarioSeleccionado añadido correctamente")
                TiendaUIState.ActualizarExito(usuarioSeleccionado)
            }catch (e: Exception){
                Log.e("TiendaViewModel", "Error al obtener los productos", e)
                TiendaUIState.Error
            } finally {
                obtenerUsuarios()
            }
        }
    }

    fun insertarProducto(producto: Producto){
        viewModelScope.launch {
            productoUIState = ProductosUIState.Cargando

            productoUIState = try {
                productoRepositorio.insertarProducto(producto.id, producto)
                Log.d("EXITO", "Producto: $producto añadido correctamente")
                ProductosUIState.InsertarExito(producto)
            }catch (e: Exception){
                Log.e("TiendaViewModel", "Error al obtener los productos", e)
                ProductosUIState.Error
            } finally {
                obtenerProductos()
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this [APPLICATION_KEY] as TiendaAplicacion)
                // Repositorios
                val usuarioRepositorio = aplicacion.contenedor.usuarioRepositorio
                val productoRepositorio = aplicacion.contenedor.productoRepositorio

                TiendaViewModel(
                    usuarioRepositorio = usuarioRepositorio,
                    productoRepositorio = productoRepositorio
                )
            }
        }
    }
}