package com.example.playground_kotlin_pizzatime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.playground_kotlin_pizzatime.ui.PizzaTimeApp
import com.example.playground_kotlin_pizzatime.ui.theme.PlaygroundkotlinPizzaTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlaygroundkotlinPizzaTimeTheme {
                PizzaTimeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaygroundkotlinPizzaTimeTheme {
        PizzaTimeApp()
    }
}