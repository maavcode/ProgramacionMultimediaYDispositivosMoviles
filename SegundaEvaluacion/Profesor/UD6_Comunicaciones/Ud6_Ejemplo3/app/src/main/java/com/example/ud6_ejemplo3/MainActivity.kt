package com.example.ud6_ejemplo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ud6_ejemplo3.ui.Ud6Ejemplo3App
import com.example.ud6_ejemplo3.ui.theme.Ud6_Ejemplo3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ud6_Ejemplo3Theme {
                Ud6Ejemplo3App()
            }
        }
    }
}