package com.example.carrentv1

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
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
fun AgregarAutoDos(navController: NavController){
    // Colores principales
    val backgroundColor = Color(0xFFFFD68A)
    val buttonColor = Color(0xFF03A9F4)
    val blueText = Color(0xFF1976D2)

    // Estados de los campos
    var color by remember { mutableStateOf("") }
    var kilometraje by remember { mutableStateOf("") }
    var version by remember { mutableStateOf("") }
    var transmision by remember { mutableStateOf("Automática") }
    var expanded by remember { mutableStateOf(false) }

    val listaTransmisiones = listOf("Automática", "Manual", "CVT")

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
            text = "Especificaciones técnicas",
            color = Color.DarkGray,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo color
        OutlinedTextField(
            value = color,
            onValueChange = { color = it },
            label = { Text("Color") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Campo kilometraje
        OutlinedTextField(
            value = kilometraje,
            onValueChange = { kilometraje = it },
            label = { Text("Kilometraje") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Campo versión
        OutlinedTextField(
            value = version,
            onValueChange = { version = it },
            label = { Text("Versión (Básica, GT)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Dropdown transmisión
        Box {
            OutlinedTextField(
                value = transmision,
                onValueChange = {},
                label = { Text("Transmisión") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = true },
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Desplegar"
                    )
                }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listaTransmisiones.forEach {
                    DropdownMenuItem(
                        text = { Text(it) },
                        onClick = {
                            transmision = it
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Botón subir imagen
        OutlinedButton(
            onClick = { /* Acción para subir imagen */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Subir imagen", color = Color.Black)
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botones inferior (anterior y siguiente)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Acción anterior */
                    navController.navigate(Routes.agregarAutoUno)
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
                onClick = { /* Acción siguiente */ },
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