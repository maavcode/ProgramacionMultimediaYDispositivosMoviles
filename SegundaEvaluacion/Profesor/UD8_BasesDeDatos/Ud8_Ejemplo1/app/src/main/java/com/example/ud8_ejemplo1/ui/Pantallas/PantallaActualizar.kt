
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ud8_ejemplo1.R
import com.example.ud8_ejemplo1.modelo.Producto

@Composable
fun PantallaActualizar(
    producto: Producto,
    onProductoActualizado: (Producto) -> Unit,
    modifier: Modifier = Modifier
) {

    var nombre by remember { mutableStateOf(producto.nombre) }
    var precio by remember { mutableStateOf(producto.precio) }
    var cantidad by remember { mutableStateOf(producto.cantidad) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Spacer(Modifier.height(16.dp))

        TextField(
            value = producto.id.toString(),
            label = { Text(text = "Id") },
            onValueChange = {},
            enabled = false
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = nombre,
            label = { Text(text = stringResource(R.string.nombre)) },
            onValueChange = { nombre = it }
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = precio.toString(),
            label = { Text(text = stringResource(R.string.precio)) },
            onValueChange = { precio = it.toDouble() }
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = cantidad.toString(),
            label = { Text(text = stringResource(R.string.cantidad)) },
            onValueChange = { cantidad = it.toInt() }
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                val productoActualizado = Producto(
                    id = producto.id,
                    nombre = nombre,
                    precio = precio,
                    cantidad = cantidad
                )
                onProductoActualizado(productoActualizado)
            }) {
            Text(text = stringResource(R.string.actualizar))
        }
    }
}