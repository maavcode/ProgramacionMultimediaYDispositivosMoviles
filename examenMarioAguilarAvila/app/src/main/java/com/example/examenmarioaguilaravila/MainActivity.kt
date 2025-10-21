package com.example.examenmarioaguilaravila

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.examenmarioaguilaravila.ui.theme.Examen1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Examen1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*PantallaListado(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .statusBarsPadding()
                            .padding(start = 20.dp, end = 20.dp)
                    )*/
                    PantallaAnadirPersona(
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
