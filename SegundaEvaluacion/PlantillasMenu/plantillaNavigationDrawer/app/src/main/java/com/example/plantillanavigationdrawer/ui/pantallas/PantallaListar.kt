package com.example.plantillanavigationdrawer.ui.pantallas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.plantillanavigationdrawer.modelo.Usuario
import com.example.plantillanavigationdrawer.ui.viewmodel.PlantillaUIState

@Composable
fun PantallaListar(
    listaUsuarios: List<Usuario>
){
    LazyColumn (

    ){
        items(listaUsuarios){ usuario ->
            Box(

            ){
                Row (

                ){
                    Text(
                        text = usuario.nombre
                    )

                }
            }
        }
    }
}