package com.example.proyectopizzatime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopizzatime.ui.theme.ProyectoPizzaTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoPizzaTimeTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    /*PantallaInicial(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .statusBarsPadding()
                            .padding(start = 20.dp, end = 20.dp)
                    )*/
                    /*PantallaListarPedidos(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .statusBarsPadding()
                            .padding(start = 20.dp, end = 20.dp)
                    )*/
                    PantallaRealizarPedido(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .statusBarsPadding()
                            .padding(start = 20.dp, end = 20.dp)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoPizzaTimeTheme {
        PantallaInicial()
    }
}