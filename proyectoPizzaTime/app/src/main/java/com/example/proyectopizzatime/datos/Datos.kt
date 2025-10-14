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
                idPedido = 1,
                pizza = "Barbacoa",
                tamanoPizza = "Mediana",
                bebida = "Agua",
                precioPizza = 0.0,
                precioBebida = 0.0,
                precioTotal = 0.0,
            ),
            Pedido(
                idPedido = 1,
                pizza = "Barbacoa",
                tamanoPizza = "Mediana",
                bebida = "Agua",
                precioPizza = 0.0,
                precioBebida = 0.0,
                precioTotal = 0.0,
            ),
            Pedido(
                idPedido = 1,
                pizza = "Barbacoa",
                tamanoPizza = "Mediana",
                bebida = "Agua",
                precioPizza = 0.0,
                precioBebida = 0.0,
                precioTotal = 0.0,
            ),
            Pedido(
                idPedido = 1,
                pizza = "Barbacoa",
                tamanoPizza = "Mediana",
                bebida = "Agua",
                precioPizza = 0.0,
                precioBebida = 0.0,
                precioTotal = 0.0,
            ),
            Pedido(
                idPedido = 1,
                pizza = "Barbacoa",
                tamanoPizza = "Mediana",
                bebida = "Agua",
                precioPizza = 0.0,
                precioBebida = 0.0,
                precioTotal = 0.0,
            ),
            Pedido(
                idPedido = 1,
                pizza = "Barbacoa",
                tamanoPizza = "Mediana",
                bebida = "Agua",
                precioPizza = 0.0,
                precioBebida = 0.0,
                precioTotal = 0.0,
            ),
        )
    }
}


