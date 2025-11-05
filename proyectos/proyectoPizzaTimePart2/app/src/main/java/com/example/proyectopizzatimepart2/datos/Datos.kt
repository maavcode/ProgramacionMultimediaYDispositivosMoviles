package com.example.proyectopizzatimepart2.datos

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.proyectopizzatimepart2.R
import com.example.proyectopizzatimepart2.modelo.Pago
import com.example.proyectopizzatimepart2.modelo.Pedido
import com.example.proyectopizzatimepart2.modelo.Persona
import com.example.proyectopizzatimepart2.modelo.Pizza

class Datos {

    @Composable
    fun cargarPersonas(): List<Persona> {
        return listOf(
            Persona(
                idPersona = 1,
                nombre = "Yunara Sanchis Kolombo",
                correo = "yunarasanchiskolo@gmail.com",
                telefono = "678925478",
                imageResourceId = R.drawable.person,
                listaPedidos = listOf(
                    cargarPedidos()[0],
                    cargarPedidos()[1],
                    cargarPedidos()[2],
                    cargarPedidos()[3],
                    cargarPedidos()[4]
                )
            ),
            Persona(
                idPersona = 2,
                nombre = "Carlos Martínez López",
                correo = "carlosmartinezlopez@gmail.com",
                telefono = "612345678",
                imageResourceId = R.drawable.person,
                listaPedidos = listOf(
                    cargarPedidos()[5],
                    cargarPedidos()[6],
                    cargarPedidos()[7],
                    cargarPedidos()[8],
                    cargarPedidos()[9]
                )
            )
        )
    }

    @Composable
    fun cargarPizzas(): List<Pizza> {
        return listOf(
            Pizza(0, stringResource(R.string.margarita), stringResource(R.string.grande), stringResource(R.string.con_pi_a)),
            Pizza(1, stringResource(R.string.barbacoa), stringResource(R.string.mediana), stringResource(R.string.carne_de_pollo)),
            Pizza(2, stringResource(R.string.romana), stringResource(R.string.peque_a), stringResource(R.string.sin_pi_a)),
            Pizza(3, stringResource(R.string.margarita), stringResource(R.string.peque_a), stringResource(R.string.vegana)),
            Pizza(4, stringResource(R.string.barbacoa), stringResource(R.string.grande), stringResource(R.string.carne_de_pollo)),
            Pizza(5, stringResource(R.string.romana), stringResource(R.string.mediana), stringResource(R.string.con_pi_a)),
            Pizza(6, stringResource(R.string.margarita), stringResource(R.string.grande), stringResource(R.string.sin_pi_a)),
            Pizza(7, stringResource(R.string.barbacoa), stringResource(R.string.peque_a), stringResource(R.string.carne_de_pollo)),
            Pizza(8, stringResource(R.string.romana), stringResource(R.string.grande), stringResource(R.string.vegana)),
            Pizza(9, stringResource(R.string.margarita), stringResource(R.string.mediana), stringResource(R.string.con_pi_a))
        )
    }

    @Composable
    fun cargarPedidos(): List<Pedido> {
        val pizzas = cargarPizzas()
        val pagos = cargarPagos()

        return listOf(
            Pedido(0, pizzas[0], 1, stringResource(R.string.agua), 1, 12.95, pagos[0]),
            Pedido(1, pizzas[1], 2, stringResource(R.string.cola), 2, 18.90, pagos[1]),
            Pedido(2, pizzas[2], 1, stringResource(R.string.sin_bebida), 0, 4.95, pagos[2]),
            Pedido(3, pizzas[3], 3, stringResource(R.string.agua), 1, 17.85, pagos[3]),
            Pedido(4, pizzas[4], 1, stringResource(R.string.cola), 1, 13.45, pagos[4]),
            Pedido(5, pizzas[5], 2, stringResource(R.string.sin_bebida), 0, 13.90, pagos[5]),
            Pedido(6, pizzas[6], 1, stringResource(R.string.agua), 1, 12.95, pagos[6]),
            Pedido(7, pizzas[7], 2, stringResource(R.string.cola), 2, 14.90, pagos[7]),
            Pedido(8, pizzas[8], 1, stringResource(R.string.agua), 1, 12.95, pagos[8]),
            Pedido(9, pizzas[9], 1, stringResource(R.string.sin_bebida), 0, 6.95, pagos[9])
        )
    }

    @Composable
    fun cargarPagos(): List<Pago> {
        return listOf(
            Pago(0, stringResource(R.string.visa), "01/26", 123, "4111111111111111", 12.95),
            Pago(1, stringResource(R.string.visa), "02/26", 123, "4111111111111111", 18.90),
            Pago(2, stringResource(R.string.visa), "03/26", 123, "4111111111111111", 4.95),
            Pago(3, stringResource(R.string.visa), "04/26", 123, "4111111111111111", 17.85),
            Pago(4, stringResource(R.string.visa), "05/26", 123, "4111111111111111", 13.45),
            Pago(5, stringResource(R.string.mastercard), "06/27", 456, "5500000000000004", 13.90),
            Pago(6, stringResource(R.string.mastercard), "07/27", 456, "5500000000000004", 12.95),
            Pago(7, stringResource(R.string.mastercard), "08/27", 456, "5500000000000004", 14.90),
            Pago(8, stringResource(R.string.mastercard), "09/27", 456, "5500000000000004", 12.95),
            Pago(9, stringResource(R.string.mastercard), "10/27", 456, "5500000000000004", 6.95)
        )

    }
}
