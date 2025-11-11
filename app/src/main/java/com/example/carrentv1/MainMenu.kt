package com.example.carrentv1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carrentv1.ui.theme.yellowCanarian
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MainMenu(){
    LearnNavDrawer()
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavDrawer() {
    val navController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier.background(yellowCanarian)
                        .fillMaxWidth()
                        .height(150.dp)
                ) {
                    Text(text = "")
                }
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Inicio", color = Color.Black) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Inicio",
                            tint = Color.Black
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Routes.screenInicio) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Añadir", color = Color.Black) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Añadir",
                            tint = Color.Black
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Routes.screenAgregar) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Soporte", color = Color.Black) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Build,
                            contentDescription = "Soporte",
                            tint = Color.Black
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Routes.screenSoporte) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Contacto", color = Color.Black) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = "Contacto",
                            tint = Color.Black
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Routes.screenContacto) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Perfil", color = Color.Black) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Perfil",
                            tint = Color.Black
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Routes.screenPerfil) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Más Información", color = Color.Black) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "Más Información",
                            tint = Color.Black
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Routes.screenMasinfo) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Cerrar Sesión", color = Color.Black) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ExitToApp,
                            contentDescription = "Cerrar Sesión",
                            tint = Color.Black
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Routes.screenCerrar) {
                            popUpTo(0)
                        }
                    }
                )
            }
        },
    ) {
        Scaffold(
            topBar = {
                val CoroutineScope = rememberCoroutineScope()
                TopAppBar(
                    title = { Text(text = "Car-Rent") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = yellowCanarian,
                        titleContentColor = Color.Black,
                        navigationIconContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                Icons.Rounded.Menu, contentDescription = "Menu Button"
                            )
                        }
                    },
                )
            }
        ) {
            NavHost(navController = navController, startDestination = Routes.screenInicio) {
                composable(Routes.screenInicio,) {
                    ScreenInicio(navController)
                }
                composable(Routes.screenAgregar,) {
                    ScreenAgregar(navController)
                }
                composable(Routes.screenSoporte,) {
                    ScreenSoporte(navController)
                }
                composable(Routes.screenContacto,) {
                    ScreenContacto(navController)
                }
                composable(Routes.screenMasinfo,) {
                    ScreenMasinfo(navController)
                }
                composable(Routes.screenPerfil,) {
                    ScreenPerfil(navController)
                }
                composable(Routes.screenCerrar,) {
                    ScreenCerrar(navController)
                }
                composable(Routes.screenAuto,) {
                    ScreenAuto(navController)
                }
            }
        }
    }
}