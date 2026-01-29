package com.example.plantillanavigationdrawer.ui.viewmodel

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
import com.example.plantillanavigationdrawer.PlantillaAplicacion
import com.example.plantillanavigationdrawer.datos.repositorios.PlantillaRepositorio
import com.example.plantillanavigationdrawer.modelo.Usuario
import kotlinx.coroutines.launch

sealed interface PlantillaUIState {
    // EXITOS
    /* EJEMPLOS EXITOS
    data class ObtenerExito(val listaUsuarios: List<Usuario>) : TiendaUIState
    data class ActualizarExito(val usuario: Usuario) : TiendaUIState
     */
    data class ObtenerExito(val listaUsuarios: List<Usuario>): PlantillaUIState
    data class ActualizarExito(val usuarioActualizado: Usuario): PlantillaUIState
    data class InsertarExito(val usuarioInsertado: Usuario): PlantillaUIState
    data class EliminarExito(val usuarioEliminado: Usuario): PlantillaUIState

    // OTROS
    object Cargando : PlantillaUIState
    object Error : PlantillaUIState
}
class PlantillaViewModel (
    private val plantillaRepositorio: PlantillaRepositorio
): ViewModel(){
    // Inicializo el UIState en el ViewModel
    var plantillaUIState: PlantillaUIState by mutableStateOf(PlantillaUIState.Cargando)
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
    var usuarioSeleccionado: Usuario by mutableStateOf(Usuario("","","","",listOf()))
        private set

    fun actualizarUsuarioSeleccionado(usuario: Usuario){
        usuarioSeleccionado = usuario
    }

    // LO QUE SE EJECUTA AL INICIAL EL PROGRAMA
    init {
        /* EJEMPLO
            obtenerUsuarios()
         */
        obtenerUsuarios()
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

    fun obtenerUsuarios(){
        viewModelScope.launch {
            // Me aseguro de que esta en cargando el estado
            plantillaUIState = PlantillaUIState.Cargando

            plantillaUIState = try {
                // Obtengo el usuario
                val listaUsuarios = plantillaRepositorio.obtenerUsuarios()
                Log.d("EXITO OBTENER", "Usuarios recibidos: $listaUsuarios")
                PlantillaUIState.ObtenerExito(listaUsuarios)
            } catch (e: Exception){
                Log.e("ERROR", "Error al obtener los usuarios", e)
                PlantillaUIState.Error
            }

        }
    }
    fun actualizarUsuario (usuario: Usuario) {
        viewModelScope.launch {
            // Me aseguro de que esta en cargando el estado
            plantillaUIState = PlantillaUIState.Cargando

            actualizarUsuarioSeleccionado(usuario)

            plantillaUIState = try {

                plantillaRepositorio.actualizarUsuario(usuarioSeleccionado.id, usuarioSeleccionado)
                Log.d("EXITO ACTUALIZAR", "Usuario: $usuario actualizado correctamente")
                PlantillaUIState.ActualizarExito(usuario)
            }catch (e: Exception){
                Log.e("ERROR", "Error al obtener los usuarios", e)
                PlantillaUIState.Error
            }
        }
    }

    fun insertarUsuario(usuario: Usuario){
        viewModelScope.launch {
            plantillaUIState = PlantillaUIState.Cargando

            plantillaUIState = try {
                plantillaRepositorio.insertarUsuario(usuario)
                Log.d("EXITO INSERTAR", "Usuario: $usuario añadido correctamente")
                PlantillaUIState.InsertarExito(usuario)
            }catch (e: Exception){
                Log.e("ERROR", "Error al obtener los usuarios", e)
                PlantillaUIState.Error
            }
        }
    }

    fun eliminarUsuario(usuario: Usuario){
        viewModelScope.launch {
            plantillaUIState = PlantillaUIState.Cargando

            plantillaUIState = try {
                plantillaRepositorio.eliminarUsuario(usuario.id)
                Log.d("EXITO ELIMINAR", "Usuario: $usuario eliminado correctamente")
                PlantillaUIState.EliminarExito(usuario)
            }catch (e: Exception){
                Log.e("ERROR", "Error al obtener los usuarios", e)
                PlantillaUIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this [APPLICATION_KEY] as PlantillaAplicacion)
                // Repositorios
                /* EJEMPLO
                val usuarioRepositorio = aplicacion.contenedor.usuarioRepositorio
                val productoRepositorio = aplicacion.contenedor.productoRepositorio
                 */
                val plantillaRepositorio = aplicacion.contenedor.plantillaRepositorio

                PlantillaViewModel(
                    // Repositorios
                    /* EJEMPLO
                    usuarioRepositorio = usuarioRepositorio,
                    productoRepositorio = productoRepositorio
                    */
                    plantillaRepositorio = plantillaRepositorio

                )
            }
        }
    }
}