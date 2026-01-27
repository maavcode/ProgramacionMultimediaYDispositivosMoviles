
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
import androidx.compose.ui.unit.dp
import com.example.ud6_ejemplo3.modelo.Trabajador

@Composable
fun PantallaActualizar(
    trabajador: Trabajador,
    onTrabajadorActualizado: (Trabajador) -> Unit,
    modifier: Modifier = Modifier
) {
    var nombre by remember { mutableStateOf(trabajador.nombre) }
    var apellidos by remember { mutableStateOf(trabajador.apellidos) }
    var email by remember { mutableStateOf(trabajador.email) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Spacer(Modifier.height(16.dp))

        TextField(
            value = trabajador.id,
            label =  { Text(text = "Id") },
            onValueChange = {},
            enabled = false
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = nombre,
            label =  { Text(text = "Nombre") },
            onValueChange = {nombre = it}
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = apellidos,
            label =  { Text(text = "apellidos") },
            onValueChange = {apellidos = it}
        )

        Spacer(Modifier.height(16.dp))

        TextField(
            value = email,
            label =  { Text(text = "email") },
            onValueChange = {email = it}
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = {
                val trabajadorActualizado = Trabajador(id = trabajador.id, nombre = nombre, apellidos = apellidos, email = email)
                onTrabajadorActualizado(trabajadorActualizado)
            }) {
            Text(text = "Actualizar")
        }
    }
}