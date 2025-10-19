package com.example.proyectopizzatime.datos

import com.example.proyectopizzatime.R
import com.example.proyectopizzatime.modelos.Pago
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
                imageResourceId = R.drawable.person,
                listaPedidos = mutableListOf(
                    cargarPedidos().get(0),
                    cargarPedidos().get(1),
                    cargarPedidos().get(2),
                    cargarPedidos().get(3),
                    cargarPedidos().get(4),
                    cargarPedidos().get(5),
                ) // Luego podra tener pedidos dentro
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
                precioTotal = 15.9,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 1,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 15.9,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 2,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 3,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 4,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 5,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 6,
                tipoPizza = "Margarita",
                tamanoPizza = "Mediana",
                cantidadPizza = 2,
                tipoBebida = "Agua",
                cantidadBebida = 1,
                precioTotal = 24.58,
                pago = cargarPagos().get(0)
            ),
        )
    }

    fun cargarPagos(): List<Pago>{
        return listOf(
            Pago(
                idPago = 0,
                opcionPago = "Tarjeta",
                fechaCaducidad = "12/28",
                cvv = 123,
                importe = 15.90
            ),
            Pago(
                idPago = 1,
                opcionPago = "Tarjeta",
                fechaCaducidad = "12/28",
                cvv = 123,
                importe = 15.90
            )
        )
    }
}


