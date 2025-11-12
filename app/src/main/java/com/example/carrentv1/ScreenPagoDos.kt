package com.example.carrentv1

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPagoDos(navController: NavController){
    val blueColor = Color(0xFF1565C0)
    val grayText = Color.DarkGray
    val borderColor = Color(0xFFE0E0E0)
    val paypalYellow = Color(0xFFFFCC00)
    val totalAmount = 900

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { /* acción volver */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color.White
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
                .background(Color.White)
                .padding(padding)
                .padding(24.dp,15.dp)
        ) {
            // Título
            Text(
                text = "Resumen",
                color = blueColor,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Caja de resumen
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, borderColor, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Text("Chevy Monza", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Precio: \$150 por hora", color = grayText)
                    Text("Rentado por: 6 horas", color = grayText)
                    Text("Ubicación: Aguascalientes", color = grayText)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Total a pagar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, borderColor, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total a pagar:",
                        fontWeight = FontWeight.Bold,
                        color = grayText
                    )
                    Text(
                        text = "\$$totalAmount M.X",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Cuadro de métodos de pago (PayPal)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Choose a payment method",
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Botón PayPal
                    Button(
                        onClick = { /* Acción PayPal */ },
                        colors = ButtonDefaults.buttonColors(containerColor = paypalYellow),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "Pay with PayPal",
                            color = Color(0xFF003087),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Botón Pay Later
                    Button(
                        onClick = { /* Acción Pay Later */ },
                        colors = ButtonDefaults.buttonColors(containerColor = paypalYellow),
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "Pay Later",
                            color = Color(0xFF003087),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}