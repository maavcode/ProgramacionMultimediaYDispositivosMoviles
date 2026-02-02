
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ud8_ejemplo1.R
import com.example.ud8_ejemplo1.modelo.Producto
import com.example.ud8_ejemplo1.ui.InventarioUIState

@Composable
fun PantallaInicio(
    appUIState: InventarioUIState,
    onProductosObtenidos: () -> Unit,
    onProductoPulsado: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    when (appUIState) {
        is InventarioUIState.Cargando -> PantallaCargando(modifier = modifier.fillMaxSize())
        is InventarioUIState.Error -> PantallaError(modifier = modifier.fillMaxWidth())
        is InventarioUIState.ObtenerExitoTodos -> PantallaListaProductos(
            lista = appUIState.productos,
            onProductoPulsado = onProductoPulsado,
            modifier = modifier.fillMaxWidth()
        )
        is InventarioUIState.ObtenerExito -> onProductosObtenidos()
        is InventarioUIState.CrearExito -> onProductosObtenidos()
        is InventarioUIState.ActualizarExito -> onProductosObtenidos()
    }
}

@Composable
fun PantallaCargando(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.cargando),
        contentDescription = stringResource(R.string.cargando)
    )
}

@Composable
fun PantallaError(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.error),
        contentDescription = stringResource(R.string.error)
    )
}

@Composable
fun PantallaListaProductos(
    lista: List<Producto>,
    onProductoPulsado: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier) {
        items(lista){ producto ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(
                        onClick = { onProductoPulsado(producto.id) }
                    )
            ){
                Column(
                    modifier= Modifier.fillMaxWidth()
                ){
                    Text(
                        text = producto.nombre
                    )
                    Text(
                        text = producto.precio.toString()
                    )
                    Text(
                        text = producto.cantidad.toString()
                    )
                    HorizontalDivider()
                }

            }
        }
    }
}