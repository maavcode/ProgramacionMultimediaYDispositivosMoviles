package com.example.proyectopizzatimepart2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectopizzatimepart2.ui.PizzaTimeApp
import com.example.proyectopizzatimepart2.ui.theme.ProyectoPizzaTimePart2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoPizzaTimePart2Theme {
                PizzaTimeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoPizzaTimePart2Theme {
        PizzaTimeApp()
    }
}