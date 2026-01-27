package com.example.ud7_ejemplo3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ud7_ejemplo3.ui.theme.Ud7_Ejemplo3Theme
import com.example.ud7_ejemplo3.ui.Ud7_Ejemplo3App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ud7_Ejemplo3Theme {
                Ud7_Ejemplo3App()
            }
        }
    }
}