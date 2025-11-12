package com.example.carrentv1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPago(navController: NavController){
    val backgroundColor = Color.White
    val blueColor = Color(0xFF1565C0)
    val greenButton = Color(0xFF2E7D32)
    val grayText = Color.DarkGray

    var cantidad by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("Hora") }
    var expanded by remember { mutableStateOf(false) }
    val listaTipo = listOf("Hora", "Día")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* vacío para centrado visual */ },
                navigationIcon = {
                    IconButton(onClick = { /* acción volver */
                        navController.navigate(Routes.screenAuto)
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color.Black,
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = blueColor),
                modifier = Modifier
                    .padding(24.dp,95.dp)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(padding)
                .padding(24.dp,15.dp)
        ) {
            // Título
            Text(
                text = "Nuevo Alquilamiento",
                color = blueColor,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Información del auto
            Text("Chevy Monza", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("Dueño: Daniel Gutierrez", color = grayText)
            Text("Kilometraje: 90000 km", color = grayText)
            Text("Precio: \$150 por hora", color = grayText)

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Cantidad a contratar:",
                fontWeight = FontWeight.Medium,
                color = grayText
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo de cantidad y dropdown
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = cantidad,
                    onValueChange = { cantidad = it },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    placeholder = { Text("") }
                )

                Spacer(modifier = Modifier.width(8.dp))

                Box {
                    OutlinedTextField(
                        value = tipo,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .clickable { expanded = true }
                            .height(56.dp),
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
                        listaTipo.forEach {
                            DropdownMenuItem(
                                text = { Text(it) },
                                onClick = {
                                    tipo = it
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Botón de pago
            Button(
                onClick = { /* Acción continuar */
                    navController.navigate(Routes.screenPagoDos)
                },
                colors = ButtonDefaults.buttonColors(containerColor = greenButton),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text("Continuar con el pago", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

