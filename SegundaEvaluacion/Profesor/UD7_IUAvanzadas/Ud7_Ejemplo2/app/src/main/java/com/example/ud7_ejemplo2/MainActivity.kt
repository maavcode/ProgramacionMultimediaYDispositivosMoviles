package com.example.ud7_ejemplo2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ud7_ejemplo2.ui.Ud7_Ejemplo2App
import com.example.ud7_ejemplo2.ui.theme.Ud7_Ejemplo2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ud7_Ejemplo2Theme {
                Ud7_Ejemplo2App()
            }
        }
    }
}