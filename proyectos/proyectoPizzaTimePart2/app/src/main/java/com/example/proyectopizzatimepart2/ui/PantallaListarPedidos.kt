package com.example.proyectopizzatimepart2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopizzatimepart2.R
import com.example.proyectopizzatimepart2.datos.Datos
import com.example.proyectopizzatimepart2.modelo.OpcionesPago
import com.example.proyectopizzatimepart2.modelo.Pedido
import com.example.proyectopizzatimepart2.modelo.SubTipoPizza
import com.example.proyectopizzatimepart2.modelo.TamanoPizza
import com.example.proyectopizzatimepart2.modelo.TipoBebida
import com.example.proyectopizzatimepart2.modelo.TipoPizza
import com.example.proyectopizzatimepart2.ui.viewmodel.RealizarPedidoViewModel

@Composable
fun PantallaListarPedidos(
    onResumenPedidoPulsado: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: RealizarPedidoViewModel
){
    val listaPedidos = viewModel.listaPedidos

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.lista_de_pedidos),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
            )

            HorizontalDivider(
                color = Color.Gray,
                thickness = 1.dp
            )
        }

        items(listaPedidos) { pedidoActual ->
            TarjetaPedido(
                pedido = pedidoActual,
                modifier = Modifier,
                onResumenPedidoPulsado
            )
        }
    }
}

@Composable
fun TarjetaPedido (
    pedido: Pedido,
    modifier: Modifier,
    onResumenPedidoPulsado: () -> Unit,
){

    Card (
        modifier = Modifier
            .width(350.dp)
    ){
        Column (
            modifier = Modifier
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Text(
                text = stringResource(R.string.pedido) + ": "
                        + transformarEnum(pedido.pizza.tipoPizza)
                        + " + "
                        + transformarEnum(pedido.bebida)
            )
            Button(
                onClick = onResumenPedidoPulsado
            ) {
                Text(
                    text = stringResource(R.string.resumen_del_pedido)
                )
            }
        }


    }
}
// De Enum a string
@Composable
fun transformarEnum (enumParaTransformar: TipoPizza): String {
    val opcionPizza = when (enumParaTransformar) {
        TipoPizza.barbacoa -> stringResource(R.string.barbacoa)
        TipoPizza.margarita -> stringResource(R.string.margarita)
        TipoPizza.romana -> stringResource(R.string.romana)
        TipoPizza.ninguno -> ""
    }
    return opcionPizza
}

@Composable
fun transformarEnum (enumParaTransformar: OpcionesPago): String {
    val opcionPago = when (enumParaTransformar) {
        OpcionesPago.Visa -> stringResource(R.string.visa)
        OpcionesPago.MasterCard -> stringResource(R.string.mastercard)
        OpcionesPago.Euro_6000 -> stringResource(R.string.euro_6000)
        OpcionesPago.ninguno -> ""
    }
    return opcionPago
}

@Composable
fun transformarEnum (enumParaTransformar: TipoBebida): String {
    val opcionBebida = when (enumParaTransformar) {
        TipoBebida.agua -> stringResource(R.string.agua)
        TipoBebida.cola -> stringResource(R.string.cola)
        TipoBebida.sin_bebida -> stringResource(R.string.sin_bebida)
        TipoBebida.ninguno -> ""
    }
    return opcionBebida
}

@Composable
fun transformarEnum (enumParaTransformar: SubTipoPizza): String {
    val opcionSubTipo = when (enumParaTransformar) {
        SubTipoPizza.carne_de_pollo -> stringResource(R.string.agua)
        SubTipoPizza.carne_de_cerdo-> stringResource(R.string.cola)
        SubTipoPizza.carne_de_ternera-> stringResource(R.string.sin_bebida)
        SubTipoPizza.con_pina -> stringResource(R.string.con_pi_a)
        SubTipoPizza.sin_pina -> stringResource(R.string.sin_pi_a)
        SubTipoPizza.vegana -> stringResource(R.string.vegana)
        SubTipoPizza.no_vegana -> stringResource(R.string.no_vegana)
        SubTipoPizza.con_champinones -> stringResource(R.string.con_champi_ones)
        SubTipoPizza.sin_chapinones -> stringResource(R.string.sin_champi_ones)
        SubTipoPizza.ninguno -> ""
    }
    return opcionSubTipo
}

@Composable
fun transformarEnum (enumParaTransformar: TamanoPizza): String {
    val opcionTamano = when (enumParaTransformar) {
        TamanoPizza.grande -> stringResource(R.string.grande)
        TamanoPizza.mediana -> stringResource(R.string.mediana)
        TamanoPizza.pequena -> stringResource(R.string.peque_a)
        TamanoPizza.ninguno -> ""
    }
    return opcionTamano
}

// De string a Enum

@Composable
fun transformarstringAEnumTipoPizza(texto: String): TipoPizza {
    val opcionTipoPizza = when (texto) {
        stringResource(R.string.barbacoa) -> TipoPizza.barbacoa
        stringResource(R.string.margarita) -> TipoPizza.margarita
        stringResource(R.string.romana) -> TipoPizza.romana
        else -> TipoPizza.ninguno // Por defecto
    }
    return opcionTipoPizza
}

@Composable
fun transformarStringAEnumOpcionesPago(texto: String): OpcionesPago {
    val opcionPago = when (texto) {
        stringResource(R.string.visa) -> OpcionesPago.Visa
        stringResource(R.string.mastercard) -> OpcionesPago.MasterCard
        stringResource(R.string.euro_6000) -> OpcionesPago.Euro_6000
        else -> OpcionesPago.ninguno // Por defecto
    }
    return opcionPago
}

@Composable
fun transformarStringAEnumTipoBebida(texto: String): TipoBebida {
    val opcionBebida = when (texto) {
        stringResource(R.string.agua) -> TipoBebida.agua
        stringResource(R.string.cola) -> TipoBebida.cola
        stringResource(R.string.sin_bebida) -> TipoBebida.sin_bebida
        else -> TipoBebida.ninguno
    }
    return opcionBebida
}

@Composable
fun transformarStringAEnumSubTipoPizza(texto: String): SubTipoPizza {
    val opcionSubTipo = when (texto) {
        stringResource(R.string.con_pi_a) -> SubTipoPizza.con_pina
        stringResource(R.string.sin_pi_a) -> SubTipoPizza.sin_pina
        stringResource(R.string.vegana) -> SubTipoPizza.vegana
        stringResource(R.string.no_vegana) -> SubTipoPizza.no_vegana
        stringResource(R.string.con_champi_ones) -> SubTipoPizza.con_champinones
        stringResource(R.string.sin_champi_ones) -> SubTipoPizza.sin_chapinones
        stringResource(R.string.carne_de_pollo) -> SubTipoPizza.carne_de_pollo
        stringResource(R.string.carne_de_cerdo) -> SubTipoPizza.carne_de_cerdo
        stringResource(R.string.carne_de_ternera) -> SubTipoPizza.carne_de_ternera
        else -> SubTipoPizza.ninguno
    }
    return opcionSubTipo
}

@Composable
fun transformarStringAEnumTamanoPizza(texto: String): TamanoPizza {
    val opcionTamano = when (texto) {
        stringResource(R.string.grande) -> TamanoPizza.grande
        stringResource(R.string.mediana) -> TamanoPizza.mediana
        stringResource(R.string.peque_a) -> TamanoPizza.pequena
        else -> TamanoPizza.ninguno
    }
    return opcionTamano
}








