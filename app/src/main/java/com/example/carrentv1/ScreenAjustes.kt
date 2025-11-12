package com.example.carrentv1

import androidx.compose.runtime.Composable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenAjustes(navController: NavController){
    val grayText = Color(0xFF444444)
    val selectedColor = Color(0xFF1565C0)
    val greenButton = Color(0xFF2E7D32)

    var selectedTheme by remember { mutableStateOf("Blanco") }
    var selectedLanguage by remember { mutableStateOf("Blanco") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { /* Acción volver */
                        navController.navigate(Routes.screenInicio)
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF1565C0)),
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
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Logo
            Image(
                painter = painterResource(id = R.drawable.car_rent), // coloca tu icono aquí
                contentDescription = "Car-Rent Logo",
                modifier = Modifier.size(80.dp)
            )

            Text(
                text = "Car-Rent",
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Cambiar tema
            Text(
                text = "Cambiar Tema",
                fontWeight = FontWeight.SemiBold,
                color = grayText,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedTheme == "Oscuro",
                    onClick = { selectedTheme = "Oscuro" },
                    colors = RadioButtonDefaults.colors(selectedColor = selectedColor)
                )
                Text("Oscuro", color = grayText)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedTheme == "Blanco",
                    onClick = { selectedTheme = "Blanco" },
                    colors = RadioButtonDefaults.colors(selectedColor = selectedColor)
                )
                Text("Blanco", color = grayText)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Cambiar idioma
            Text(
                text = "Cambiar Idioma",
                fontWeight = FontWeight.SemiBold,
                color = grayText,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedLanguage == "Blanco",
                    onClick = { selectedLanguage = "Blanco" },
                    colors = RadioButtonDefaults.colors(selectedColor = selectedColor)
                )
                Text("Español", color = grayText)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selectedLanguage == "Ingles",
                    onClick = { selectedLanguage = "Ingles" },
                    colors = RadioButtonDefaults.colors(selectedColor = selectedColor)
                )
                Text("Ingles", color = grayText)
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Términos y condiciones
            Text(
                text = "Términos y condiciones",
                fontWeight = FontWeight.SemiBold,
                color = grayText,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { /* Acción para ver términos */ },
                colors = ButtonDefaults.buttonColors(containerColor = greenButton),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .height(45.dp),
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(text = "Ver", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}