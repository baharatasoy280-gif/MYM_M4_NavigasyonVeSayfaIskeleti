package com.example.navigasyonvesayfaskeleti.ders1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun D415_TemelNavigasyonApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ana_sayfa") {
        composable("ana_sayfa") {

            AnaSayfa(navController= navController)

        }

        composable("detay_sayfasi") {
            Detaysayfa(navController =navController)
        }
    }
}

@Composable
fun AnaSayfa(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("\uD83C\uDFE0 Ana Sayfa")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {navController.navigate("detay_sayfasi")}) {
            Text("Detaylara Git")

        }

    }
}

@Composable
fun Detaysayfa(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("\uD83D\uDCC4 Detay Sayfası")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {navController.popBackStack()}) {
            Text("Geri Dön")

        }

    }
}