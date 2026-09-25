package com.example.ejercicios

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicios.ui.theme.EjerciciosTheme

@Composable
fun ExperimentoPersistencia(modifier: Modifier = Modifier) {
    var nombre by remember { mutableStateOf("") }
    var contador by remember { mutableIntStateOf(0) }

    // Opcional
    var nuevaTarea by remember { mutableStateOf("") }
    var listaTareas by remember { mutableStateOf(listOf<String>()) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "1. Nombre y Contador",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    OutlinedTextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        label = { Text("Escribe un nombre") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    HorizontalDivider()

                    Text(
                        text = "Contador: $contador",
                        style = MaterialTheme.typography.headlineSmall
                    )

                    // Botones +1 y Reiniciar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Button(onClick = { contador++ }) {
                            Text("+1")
                        }

                        OutlinedButton(onClick = {
                            contador = 0
                            nombre = ""
                        }) {
                            Text("Reiniciar")
                        }
                    }
                }
            }
        }

        // Opcional
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "2. Opcional",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = nuevaTarea,
                            onValueChange = { nuevaTarea = it },
                            label = { Text("Nueva tarea") },
                            modifier = Modifier.weight(1f),
                            singleLine = true
                        )

                        Button(
                            onClick = {
                                if (nuevaTarea.isNotBlank()) {
                                    listaTareas += nuevaTarea
                                    nuevaTarea = ""
                                }
                            }
                        ) {
                            Text("Agregar")
                        }
                    }

                    if (listaTareas.isNotEmpty()) {
                        Text(
                            text = "Tareas en memoria (${listaTareas.size}):",
                            style = MaterialTheme.typography.labelLarge
                        )
                    }
                }
            }
        }

        // Mostrar elementos de la lista de tareas
        items(listaTareas) { tarea ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Text(
                    text = "• $tarea",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExperimentoPersistenciaPreview() {
    EjerciciosTheme {
        ExperimentoPersistencia()
    }
}
