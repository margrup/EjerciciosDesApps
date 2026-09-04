package com.example.ejercicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

@Composable
fun Presentacion(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Nombre: [Tu Nombre]")
        Text(text = "Carrera: [Tu Carrera]")
        Text(text = "Tecnología a aprender: Jetpack Compose")
    }
}

@Preview(showBackground = true)
@Composable
fun PresentacionPreview() {
    EjerciciosTheme {
        Presentacion()
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

    Column(modifier = modifier) {
        DatoEstudiante("Nombre", "Ana")
        DatoEstudiante("Carrera", "Sistemas")
        DatoEstudiante("Año", "1")
        
        // Uso de la función no composable descripcionEdad() en un Text
        Text(text = descripcionEdad(edad))
    }
}

@Preview(showBackground = true)
@Composable
fun FichaDelEstudiantePreview() {
    EjerciciosTheme {
        FichaDelEstudiante()
    }
}