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
fun PantallaInsertar(
    onInsertarPulsado: (Producto) -> Unit,
    modifier: Modifier = Modifier
){
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Spacer(Modifier.height(16.dp))

        TextField(
            value = nombre,
            label =  { Text(text = stringResource(R.string.nombre)) },
            onValueChange = {nombre = it}
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = precio,
            label =  { Text(text = stringResource(R.string.precio)) },
            onValueChange = {precio = it}
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = cantidad,
            label =  { Text(text = stringResource(R.string.cantidad)) },
            onValueChange = {cantidad = it}
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                val producto = Producto(nombre = nombre, precio = precio.toDouble(), cantidad = cantidad.toInt())
                onInsertarPulsado(producto)
            }) {
            Text(text = "Insertar")
        }
    }
}