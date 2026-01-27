package com.example.ud7_ejemplo3.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ud7_ejemplo3.datos.lista


@Composable
fun PantallaInicio(
    modifier: Modifier = Modifier
){
    LazyColumn (modifier = modifier) {
      items(lista){ pais ->
          Box(
              modifier = Modifier.fillMaxWidth()
          ){
              Text(
                  text = pais,
                  modifier = Modifier.padding(16.dp)
              )
          }
      }
    }
}