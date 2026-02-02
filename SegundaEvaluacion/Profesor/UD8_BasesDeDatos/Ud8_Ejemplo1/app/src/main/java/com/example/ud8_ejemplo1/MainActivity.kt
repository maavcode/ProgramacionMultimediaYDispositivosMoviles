package com.example.ud8_ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ud8_ejemplo1.ui.Ud8_ejemplo1App
import com.example.ud8_ejemplo1.ui.theme.Ud8_Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ud8_Ejemplo1Theme {
                Ud8_ejemplo1App()
            }
        }
    }
}