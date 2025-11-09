package com.example.proyectopizzatimepart2.datos

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.proyectopizzatimepart2.R
import com.example.proyectopizzatimepart2.modelo.OpcionesPago
import com.example.proyectopizzatimepart2.modelo.Pago
import com.example.proyectopizzatimepart2.modelo.Pedido
import com.example.proyectopizzatimepart2.modelo.Persona
import com.example.proyectopizzatimepart2.modelo.Pizza
import com.example.proyectopizzatimepart2.modelo.SubTipoPizza
import com.example.proyectopizzatimepart2.modelo.TamanoPizza
import com.example.proyectopizzatimepart2.modelo.TipoBebida
import com.example.proyectopizzatimepart2.modelo.TipoPizza

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

    fun cargarPizzas(): List<Pizza> {
        return listOf(
            Pizza(0, TipoPizza.margarita, SubTipoPizza.con_pina, TamanoPizza.grande),
            Pizza(1, TipoPizza.barbacoa, SubTipoPizza.carne_de_cerdo, TamanoPizza.mediana),
            Pizza(2, TipoPizza.romana, SubTipoPizza.sin_pina, TamanoPizza.pequena),
            Pizza(3, TipoPizza.margarita, SubTipoPizza.vegana, TamanoPizza.pequena),
            Pizza(4, TipoPizza.barbacoa, SubTipoPizza.carne_de_pollo, TamanoPizza.grande),
            Pizza(5, TipoPizza.romana, SubTipoPizza.con_pina, TamanoPizza.mediana),
            Pizza(6, TipoPizza.margarita, SubTipoPizza.sin_pina, TamanoPizza.grande),
            Pizza(7, TipoPizza.barbacoa, SubTipoPizza.carne_de_ternera, TamanoPizza.pequena),
            Pizza(8, TipoPizza.romana, SubTipoPizza.vegana, TamanoPizza.grande),
            Pizza(9, TipoPizza.margarita, SubTipoPizza.no_vegana, TamanoPizza.mediana)
        )

    }

    fun cargarPedidos(): List<Pedido> {
        val pizzas = cargarPizzas()
        val pagos = cargarPagos()

        return listOf(
            Pedido(0, pizzas[0], 1, TipoBebida.agua, 1, 12.95, pagos[0]),
            Pedido(1, pizzas[1], 2, TipoBebida.cola, 2, 18.90, pagos[1]),
            Pedido(2, pizzas[2], 1, TipoBebida.sin_bebida, 0, 4.95, pagos[2]),
            Pedido(3, pizzas[3], 3, TipoBebida.agua, 1, 17.85, pagos[3]),
            Pedido(4, pizzas[4], 1, TipoBebida.cola, 1, 13.45, pagos[4]),
            Pedido(5, pizzas[5], 2, TipoBebida.sin_bebida, 0, 13.90, pagos[5]),
            Pedido(6, pizzas[6], 1, TipoBebida.agua, 1, 12.95, pagos[6]),
            Pedido(7, pizzas[7], 2, TipoBebida.cola, 2, 14.90, pagos[7]),
            Pedido(8, pizzas[8], 1, TipoBebida.agua, 1, 12.95, pagos[8]),
            Pedido(9, pizzas[9], 1, TipoBebida.sin_bebida, 0, 6.95, pagos[9])
        )

    }

    fun cargarPagos(): List<Pago> {
        return listOf(
            Pago(0, OpcionesPago.Visa, "01/26", "123", "4111111111111111"),
            Pago(1, OpcionesPago.Visa, "02/26", "123", "4111111111111111"),
            Pago(2, OpcionesPago.Visa, "03/26", "123", "4111111111111111"),
            Pago(3, OpcionesPago.Visa, "04/26", "123", "4111111111111111"),
            Pago(4, OpcionesPago.Visa, "05/26", "123", "4111111111111111"),
            Pago(5, OpcionesPago.MasterCard, "06/27", "456", "5500000000000004"),
            Pago(6, OpcionesPago.MasterCard, "07/27", "456", "5500000000000004"),
            Pago(7, OpcionesPago.MasterCard, "08/27", "456", "5500000000000004"),
            Pago(8, OpcionesPago.MasterCard, "09/27", "456", "5500000000000004"),
            Pago(9, OpcionesPago.MasterCard, "10/27", "456", "5500000000000004")
        )

    }
}
