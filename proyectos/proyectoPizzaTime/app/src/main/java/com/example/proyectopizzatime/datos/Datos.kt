package com.example.proyectopizzatime.datos

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.proyectopizzatime.R
import com.example.proyectopizzatime.modelos.Pago
import com.example.proyectopizzatime.modelos.Pedido
import com.example.proyectopizzatime.ui.theme.Persona

class Datos{
    @Composable
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

    @Composable
    fun cargarPedidos(): List<Pedido> {
        return listOf(
            Pedido(
                idPedido = 0,
                tipoPizza = stringResource(R.string.margarita),
                tamanoPizza = stringResource(R.string.mediana),
                cantidadPizza = 2,
                tipoBebida = stringResource(R.string.agua),
                cantidadBebida = 1,
                precioTotal = 15.9,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = stringResource(R.string.margarita),
                tamanoPizza = stringResource(R.string.mediana),
                cantidadPizza = 2,
                tipoBebida = stringResource(R.string.agua),
                cantidadBebida = 1,
                precioTotal = 15.9,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = stringResource(R.string.margarita),
                tamanoPizza = stringResource(R.string.mediana),
                cantidadPizza = 2,
                tipoBebida = stringResource(R.string.agua),
                cantidadBebida = 1,
                precioTotal = 15.9,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = stringResource(R.string.margarita),
                tamanoPizza = stringResource(R.string.mediana),
                cantidadPizza = 2,
                tipoBebida = stringResource(R.string.agua),
                cantidadBebida = 1,
                precioTotal = 15.9,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = stringResource(R.string.margarita),
                tamanoPizza = stringResource(R.string.mediana),
                cantidadPizza = 2,
                tipoBebida = stringResource(R.string.agua),
                cantidadBebida = 1,
                precioTotal = 15.9,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = stringResource(R.string.margarita),
                tamanoPizza = stringResource(R.string.mediana),
                cantidadPizza = 2,
                tipoBebida = stringResource(R.string.agua),
                cantidadBebida = 1,
                precioTotal = 15.9,
                pago = cargarPagos().get(0)
            ),
            Pedido(
                idPedido = 0,
                tipoPizza = stringResource(R.string.margarita),
                tamanoPizza = stringResource(R.string.mediana),
                cantidadPizza = 2,
                tipoBebida = stringResource(R.string.agua),
                cantidadBebida = 1,
                precioTotal = 15.9,
                pago = cargarPagos().get(0)
            ),
        )
    }

    @Composable
    fun cargarPagos(): List<Pago>{
        return listOf(
            Pago(
                idPago = 0,
                opcionPago = stringResource(R.string.visa),
                fechaCaducidad = stringResource(R.string._12_28),
                cvv = 123,
                importe = 15.90
            ),
            Pago(
                idPago = 1,
                opcionPago = stringResource(R.string.visa),
                fechaCaducidad = stringResource(R.string._12_28),
                cvv = 123,
                importe = 15.90
            )
        )
    }
}


