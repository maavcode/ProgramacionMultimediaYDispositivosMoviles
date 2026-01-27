
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
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
import com.example.ud6_ejemplo3.R
import com.example.ud6_ejemplo3.modelo.Trabajador
import com.example.ud6_ejemplo3.ui.TrabajadorUIState

@Composable
fun PantallaInicio(
    appUIState: TrabajadorUIState,
    onTrabajadoresObtenidos: () -> Unit,
    onTrabajadorPulsado: (Trabajador) -> Unit,
    onTrabajadorEliminado: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    when (appUIState) {
        is TrabajadorUIState.Cargando -> PantallaCargando(modifier = modifier.fillMaxSize())
        is TrabajadorUIState.Error -> PantallaError(modifier = modifier.fillMaxWidth())
        is TrabajadorUIState.ObtenerExito -> PantallaListaTrabajadores(
            lista = appUIState.trabajadores,
            onTrabajadorPulsado = onTrabajadorPulsado,
            onTrabajadorEliminado = onTrabajadorEliminado,
            modifier = modifier.fillMaxWidth()
        )
        is TrabajadorUIState.CrearExito -> onTrabajadoresObtenidos()
        is TrabajadorUIState.ActualizarExito -> onTrabajadoresObtenidos()
        is TrabajadorUIState.EliminarExito -> onTrabajadoresObtenidos()
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PantallaListaTrabajadores(
    lista: List<Trabajador>,
    onTrabajadorPulsado: (Trabajador) -> Unit,
    onTrabajadorEliminado: (String) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier) {
        items(lista){ trabajador ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .combinedClickable(
                        onClick = { onTrabajadorPulsado(trabajador) },
                        onLongClick = { onTrabajadorEliminado(trabajador.id) }
                    )
            ){
                Column(
                    modifier= Modifier.fillMaxWidth()
                ){
                    Text(
                        text = trabajador.nombre
                    )
                    Text(
                        text = trabajador.apellidos
                    )
                    Text(
                        text = trabajador.email
                    )
                    HorizontalDivider()
                }

            }
        }
    }
}