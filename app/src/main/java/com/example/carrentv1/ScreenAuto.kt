package com.example.carrentv1

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ScreenAuto(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp,128.dp)
    ) {
        // Flecha de regreso
        IconButton(onClick = { navController.navigate(Routes.screenInicio) }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Regresar"
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Imagen del auto
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(1.dp, Color.Gray.copy(alpha = 0.3f))
        ) {
            Image(
                painter = painterResource(id = R.drawable.sentra), // ← tu imagen en drawable
                contentDescription = "Auto",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Información del auto
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Nissan Sentra", fontWeight = FontWeight.Bold)
                Text(text = "En Aguascalientes", color = Color.Gray)
                Text(text = "$200 por hora", fontWeight = FontWeight.Medium)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(text = "Dueño: Daniel Gutierrez", fontWeight = FontWeight.Bold)
                Text(text = "Tel: 4490000000", color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Calificación y botón
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Estrella",
                    tint = Color.Black
                )
                Text(
                    text = "4.8",
                    modifier = Modifier.padding(start = 4.dp),
                    fontSize = 16.sp
                )
            }

            Button(
                onClick = { /* Acción de alquilar */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E7D32))
            ) {
                Text(text = "Alquilar")
            }
        }
    }
}