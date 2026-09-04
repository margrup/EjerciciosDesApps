package com.example.ejercicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicios.ui.theme.EjerciciosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjerciciosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FichaDelEstudiante(
                        modifier = Modifier.padding(paddingValues = innerPadding)
                    )
                }
            }
        }
    }
}

// Función Kotlin no composable
fun descripcionEdad(edad: Int): String {
    val condicion = if (edad >= 18) "mayor de edad" else "menor de edad"
    return "Edad: $edad años ($condicion)"
}

// Composable reutilizable
@Composable
fun DatoEstudiante(etiqueta: String, valor: String, modifier: Modifier = Modifier) {
    Text(
        text = "$etiqueta: $valor",
        modifier = modifier
    )
}

@Composable
fun FichaDelEstudiante(modifier: Modifier = Modifier) {
    val edad = 20

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp) // Modificador 1: Margen externo
            .background(Color(0xFFEFEFEF)) // Modificador 2: Fondo
            .padding(16.dp) // Modificador 3: Padding interno
    ) {
        // Título de la ficha
        Text(
            text = "Perfil del Estudiante",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        DatoEstudiante("Nombre", "Ana")

        Spacer(modifier = Modifier.height(8.dp))

        // Fila con dos elementos (Row)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DatoEstudiante("Carrera", "Sistemas")
            DatoEstudiante("Año", "1º")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = descripcionEdad(edad))

        Spacer(modifier = Modifier.height(16.dp))

        // Componente adicional Material 3 (Button)
        Button(onClick = { /* Todavía sin comportamiento */ }) {
            Text("Ver Detalles")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FichaDelEstudiantePreview() {
    EjerciciosTheme {
        FichaDelEstudiante()
    }
}