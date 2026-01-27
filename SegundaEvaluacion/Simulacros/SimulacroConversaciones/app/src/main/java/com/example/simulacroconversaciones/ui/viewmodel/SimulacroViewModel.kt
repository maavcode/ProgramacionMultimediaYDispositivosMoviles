package com.example.simulacroconversaciones.ui.viewmodel

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
import com.example.simulacroconversaciones.SimulacroAplicacion
import com.example.simulacroconversaciones.datos.repositorios.SimulacroRepositorio
import com.example.simulacroconversaciones.modelo.Mensaje
import com.example.simulacroconversaciones.modelo.Usuario
import kotlinx.coroutines.launch

sealed interface SimulacroUIState {
    // EXITOS
    /* EJEMPLOS EXITOS
    data class ObtenerExito(val listaUsuarios: List<Usuario>) : TiendaUIState
    data class ActualizarExito(val usuario: Usuario) : TiendaUIState
     */
    data class ObtenerUsuariosExito(val listaUsuarios: List<Usuario>): SimulacroUIState
    data class ActualizarUsuarioExito(val usuario: Usuario): SimulacroUIState
    data class InsertarUsuarioExito(val usuario: Usuario): SimulacroUIState
    // OTROS
    object Cargando : SimulacroUIState
    object Error : SimulacroUIState
}

class SimulacroViewModel(
    // Añado repositorios
    /* EJEMPLO
    private val usuarioRepositorio: UsuarioRepositorio,
    private val productoRepositorio: ProductoRepositorio
     */
    private val simulacroRepositorio: SimulacroRepositorio
) : ViewModel(){
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
    var usuarioSeleccionado: Usuario by mutableStateOf(Usuario("","","",listOf()))

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
            simulacroUIState = SimulacroUIState.Cargando
            simulacroUIState = try {
                val listaUsuarios = simulacroRepositorio.obtenerUsuarios()
                Log.d("EXITO USUARIO","Usuarios recibidos: $listaUsuarios")
                SimulacroUIState.ObtenerUsuariosExito(listaUsuarios)
            } catch (e: Exception){
                Log.e("USUARIOS", "Error al obtener los usuarios", e)
                SimulacroUIState.Error
            }
        }
    }
    fun actualizarMensajesUsuario(mensaje: Mensaje){
        viewModelScope.launch {
            simulacroUIState = SimulacroUIState.Cargando

            val usuarioActualizado = usuarioSeleccionado.copy(
                mensajes = usuarioSeleccionado.mensajes + mensaje
            )
            actualizarUsuarioSeleccionado(usuarioActualizado)
            simulacroUIState = try {
                simulacroRepositorio.actualizarUsuario(usuarioSeleccionado.id, usuarioSeleccionado)
                Log.d("EXITO USUARIO","Usuario actualizado con exito")
                SimulacroUIState.ActualizarUsuarioExito(usuarioActualizado)
            } catch (e: Exception){
                Log.e("USUARIOS", "Error al actualizar el usuario", e)
                SimulacroUIState.Error
            }
        }
    }
    fun insertarUsuario(usuario: Usuario){
        viewModelScope.launch {
            simulacroUIState = SimulacroUIState.Cargando

            simulacroUIState = try {
                simulacroRepositorio.insertarUsuario(usuario)
                Log.d("EXITO USUARIO", "Usuario: $usuario añadido correctamente")
                SimulacroUIState.InsertarUsuarioExito(usuario)
            }catch (e: Exception){
                Log.e("ERROR", "Error al obtener los usuarios", e)
                SimulacroUIState.Error
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val aplicacion = (this [APPLICATION_KEY] as SimulacroAplicacion)
                // Repositorios
                /* EJEMPLO
                val usuarioRepositorio = aplicacion.contenedor.usuarioRepositorio
                val productoRepositorio = aplicacion.contenedor.productoRepositorio
                 */
                val simulacroRepositorio = aplicacion.contenedor.simulacroRepositorio

                SimulacroViewModel(
                    // Repositorios
                    /* EJEMPLO
                    usuarioRepositorio = usuarioRepositorio,
                    productoRepositorio = productoRepositorio
                    */
                    simulacroRepositorio = simulacroRepositorio

                )
            }
        }
    }
}