package com.example.carrentv1

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AgregarAutoUno(navController: NavController){
    // Colores principales
    val backgroundColor = Color(0xFFFFD68A)
    val buttonColor = Color(0xFF03A9F4)
    val blueText = Color(0xFF1976D2)

    // Estados de los campos
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var aireAcondicionado by remember { mutableStateOf(false) }
    var anio by remember { mutableStateOf("2025") }
    var puertas by remember { mutableStateOf("2") }
    var precio by remember { mutableStateOf("") }
    var tipoRenta by remember { mutableStateOf("Hora") }

    val listaAnios = listOf("2025", "2024", "2023")
    val listaPuertas = listOf("2", "4")
    val listaTipo = listOf("Hora", "Día")

    // Layout general
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp,120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título principal
        Text(
            text = "Renta tu\nvehículo",
            color = blueText,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Subtítulo
        Text(
            text = "Ingresa los datos del vehículo",
            color = Color.DarkGray,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo Marca
        OutlinedTextField(
            value = marca,
            onValueChange = { marca = it },
            label = { Text("Marca") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Campo Modelo
        OutlinedTextField(
            value = modelo,
            onValueChange = { modelo = it },
            label = { Text("Modelo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Aire acondicionado (switch)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Aire Acondicionado",
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Switch(
                checked = aireAcondicionado,
                onCheckedChange = { aireAcondicionado = it },
                colors = SwitchDefaults.colors(checkedThumbColor = Color.Blue)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Año y Puertas
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Dropdown Año
            var expandedYear by remember { mutableStateOf(false) }
            Box {
                OutlinedTextField(
                    value = anio,
                    onValueChange = {},
                    label = { Text("Año") },
                    modifier = Modifier
                        .width(255.dp)
                        .clickable { expandedYear = true },
                    readOnly = true,
                )
                DropdownMenu(expanded = expandedYear, onDismissRequest = { expandedYear = false }) {
                    listaAnios.forEach {
                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                anio = it
                                expandedYear = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Dropdown Puertas
            var expandedDoors by remember { mutableStateOf(false) }
            Box {
                OutlinedTextField(
                    value = puertas,
                    onValueChange = {},
                    label = { Text("Puertas") },
                    modifier = Modifier
                        .clickable { expandedDoors = true },
                    readOnly = true,
                )
                DropdownMenu(expanded = expandedDoors, onDismissRequest = { expandedDoors = false }) {
                    listaPuertas.forEach {
                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                puertas = it
                                expandedDoors = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Precio y tipo de renta
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = precio,
                onValueChange = { precio = it },
                label = { Text("Precio") },
                modifier = Modifier.width(255.dp),
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Dropdown tipo
            var expandedTipo by remember { mutableStateOf(false) }
            Box {
                OutlinedTextField(
                    value = tipoRenta,
                    onValueChange = {},
                    label = { Text("") },
                    modifier = Modifier
                        .clickable { expandedTipo = true },
                    readOnly = true,
                )
                DropdownMenu(expanded = expandedTipo, onDismissRequest = { expandedTipo = false }) {
                    listaTipo.forEach {
                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                tipoRenta = it
                                expandedTipo = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botones inferior (anterior y siguiente)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Acción anterior */
                    navController.navigate(Routes.screenInicio)
                },
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text("Anterior", color = Color.White)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = { /* Acción siguiente */
                    navController.navigate(Routes.agregarAutoDos)
                },
                colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
            ) {
                Text("Siguiente", color = Color.White)
            }
        }
    }
}