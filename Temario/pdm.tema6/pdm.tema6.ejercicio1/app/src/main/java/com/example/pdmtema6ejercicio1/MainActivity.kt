package com.example.pdmtema6ejercicio1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pdmtema6ejercicio1.ui.StarWarsApp
import com.example.pdmtema6ejercicio1.ui.theme.Pdmtema6ejercicio1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pdmtema6ejercicio1Theme {
                StarWarsApp(

                )
            }
        }
    }
}