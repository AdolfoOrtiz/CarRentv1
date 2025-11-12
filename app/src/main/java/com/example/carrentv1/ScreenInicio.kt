package com.example.carrentv1

import android.R.attr.padding
import androidx.navigation.compose.NavHost
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch


@Composable
fun ScreenInicio(navController: NavController){
    design_t(navController)
}

@Composable
fun design(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
            .padding(15.dp,115.dp)
    ) {
        Text(
            text = "Renta de Autos",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF333333),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(3) { // 3 filas de productos
                CarsRow(navController)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun CarsRow(navController: NavController) {
    var Carro: String = "Nissan Sentra"
    var Ubicacion: String = "Aguascalientes"
    var Precio: Int = 200
    var Tiempo: String = "Hora"
    var Calificacion: Double = 4.8
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProductCard(
            nombre = Carro,
            ubicacion = Ubicacion,
            precio = Precio,
            tiempo = Tiempo,
            cal = Calificacion,
            imagen = R.drawable.sentra,
            navController
        )
        ProductCard(
            nombre = Carro,
            ubicacion = Ubicacion,
            precio = Precio,
            tiempo = Tiempo,
            cal = Calificacion,
            imagen = R.drawable.sentra,
            navController
        )
    }
}

@Composable
fun ProductCard(nombre: String, ubicacion: String, precio: Int, tiempo:String,cal:Double,imagen: Int,navController: NavController) {
    Box(
        modifier = Modifier
            .width(170.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .padding(8.dp)
            .shadow(2.dp, RoundedCornerShape(12.dp))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imagen),
                contentDescription = nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .clickable{
                        navController.navigate(Routes.screenAuto)
                    }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = nombre, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, textAlign = TextAlign.Left)
            Text(text = "En "+ubicacion, color = Color(0xFF00796B), fontSize = 14.sp, textAlign = TextAlign.Left)
            Text(text = "$"+precio+" por "+tiempo, color = Color(0xFF00796B), fontSize = 14.sp, textAlign = TextAlign.Left)
            Text(text = ""+cal, color = Color(0xFF00796B), fontSize = 14.sp, textAlign = TextAlign.Left)
        }
    }
}


@Composable
fun design_t(navController: NavController){
    design(navController)
}