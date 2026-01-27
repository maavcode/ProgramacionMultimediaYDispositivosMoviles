package com.example.ud7_ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.example.ud7_ejemplo1.ui.Ud7Ejemplo1App
import com.example.ud7_ejemplo1.ui.theme.Ud7_Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ud7_Ejemplo1Theme {
                Ud7Ejemplo1App()
            }
        }
    }
}