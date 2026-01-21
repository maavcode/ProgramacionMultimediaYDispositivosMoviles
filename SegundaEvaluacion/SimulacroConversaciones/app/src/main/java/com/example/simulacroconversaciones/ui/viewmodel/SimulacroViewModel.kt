package com.example.simulacroconversaciones.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.simulacroconversaciones.SimulacroAplicacion

sealed interface SimulacroUIState {
    // EXITOS
    /* EJEMPLOS EXITOS
    data class ObtenerExito(val listaUsuarios: List<Usuario>) : TiendaUIState
    data class ActualizarExito(val usuario: Usuario) : TiendaUIState
     */

    // OTROS
    object Cargando : SimulacroUIState
    object Error : SimulacroUIState
}

class SimulacroViewModel (

): ViewModel(){
    // Inicializo el UIState en el ViewModel
    var simulacroUIState: SimulacroUIState by mutableStateOf(SimulacroUIState.Cargando)
        private set
    // LAS VARIABLES QUE SE SELECCIONAN SE GUARDAN Y ACTUALIZAN
    /* EJEMPLO
    var usuarioSeleccionado: Usuario by mutableStateOf(Usuario("","","","",listOf()))
        private set

    var productoSeleccionado: Producto by mutableStateOf(Producto("","",""))
        private set

    fun actualizarUsuarioSeleccionado(usuario: Usuario){
        usuarioSeleccionado = usuario
    }

    fun actualizarProductoSeleccionado(producto: Producto){
        productoSeleccionado = producto
    }
     */

    // LO QUE SE EJECUTA AL INICIAL EL PROGRAMA
    init {
    /* EJEMPLO
        obtenerUsuarios()
     */

    }
    // FUNCIONES CRUD
    /* EJEMPLO FUNCIONES CRUD
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

    fun actualizarProducto(producto: Producto){
        viewModelScope.launch {
            productoUIState = ProductosUIState.Cargando

            productoUIState = try {
                val productoActualizado = productoRepositorio.actualizarProducto(producto.id, producto)

                ProductosUIState.ActualizarExito(productoActualizado)
            } catch (e: IOException) {
                ProductosUIState.Error
            }
        }
    }
     */

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this [APPLICATION_KEY] as SimulacroAplicacion)
                // Repositorios
                /* EJEMPLO
                val usuarioRepositorio = aplicacion.contenedor.usuarioRepositorio
                val productoRepositorio = aplicacion.contenedor.productoRepositorio
                 */

                SimulacroViewModel(
                    // Repositorios
                    /* EJEMPLO
                    usuarioRepositorio = usuarioRepositorio,
                    productoRepositorio = productoRepositorio
                    */

                )
            }
        }
    }
}