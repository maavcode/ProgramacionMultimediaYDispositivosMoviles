package com.example.proyectopizzatime.datos

import com.example.proyectopizzatime.R
import com.example.proyectopizzatime.modelos.Pedido
import com.example.proyectopizzatime.ui.theme.Persona

class Datos{
    fun cargarPersonas(): List<Persona> {
        return listOf(
            Persona(
                personaId = 1,
                nombre = "Yunara Sanchis Kolombo",
                correo = "yunarasanchiskolo@gmail.com",
                telefono = "678925478",
                R.drawable.person
            )
        )
    }

    fun cargarPedidos(): List<Pedido> {
        return listOf(
            Pedido(
                idPedido = 0,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58
            )
        )
    }
}


