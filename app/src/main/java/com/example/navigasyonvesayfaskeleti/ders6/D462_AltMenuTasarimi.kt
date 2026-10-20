package com.example.navigasyonvesayfaskeleti.ders6

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable


sealed class Rota {
    @Serializable
    object Akis : Rota()

    @Serializable
    object Arama : Rota()

    @Serializable
    object Profil : Rota()
}

@Composable
fun D462_AltMenuTasarimi() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    Scaffold(
        bottomBar = {
            NavigationBar() {
                NavigationBarItem(
                    selected = currentDestination?.hasRoute(Rota.Akis::class) == true,
                    onClick = {
                        navController.navigate(Rota.Akis) {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            restoreState = true

                        }
                    },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Akış") },
                    label = { Text("Akış") }
                )

                NavigationBarItem(
                    selected = currentDestination?.hasRoute(Rota.Arama::class) == true,
                    onClick = {
                        navController.navigate(Rota.Arama) {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            restoreState = true

                        }
                    },
                    icon = { Icon(Icons.Default.Search, contentDescription = "Arama") },
                    label = { Text("Arama") }
                )


                NavigationBarItem(
                    selected = currentDestination?.hasRoute(Rota.Profil::class) == true,
                    onClick = {
                        navController.navigate(Rota.Profil) {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            restoreState = true
                        }
                    },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profil") },
                    label = { Text("Profil") }
                )


            }

        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Rota.Akis,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Rota.Akis> {
                AkisEkrani()
            }
            composable<Rota.Arama> {

                AramaEkrani()
            }
            composable<Rota.Profil> {

                ProfilEkrani()
            }
        }
    }
}

@Composable
fun AkisEkrani() {
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Akış Ekranı")
    }
}

@Composable
fun AramaEkrani() {
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Arama Ekranı")
    }
}

@Composable
fun ProfilEkrani() {
    Column(
        modifier = Modifier.fillMaxSize(),
        Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Profil Ekranı")
    }
}


