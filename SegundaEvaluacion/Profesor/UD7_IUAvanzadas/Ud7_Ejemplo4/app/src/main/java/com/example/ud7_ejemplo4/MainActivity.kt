package com.example.ud7_ejemplo4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ud7_ejemplo4.ui.Ud7_Ejemplo4App
import com.example.ud7_ejemplo4.ui.theme.Ud7_Ejemplo4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ud7_Ejemplo4Theme {
                Ud7_Ejemplo4App()
            }
        }
    }
}