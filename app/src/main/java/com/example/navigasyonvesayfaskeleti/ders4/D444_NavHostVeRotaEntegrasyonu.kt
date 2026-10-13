package com.example.navigasyonvesayfaskeleti.ders4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun D444_NavHostVeRotaEntegrasyonu(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Ekran.AnaSayfa,
        modifier = modifier
    ) {
        composable<Ekran.AnaSayfa> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Ana Sayfa")
                Button(onClick = { navController.navigate(Ekran.Ayarlar) }) {
                    Text("Ayarlara git")
                }
            }
        }

        composable<Ekran.Ayarlar> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Ayarlar Sayfası")
                Button(onClick = { navController.navigate(Ekran.UrunDetay(1)) }) {
                    Text("Ürün Detay Sayfasına Git")
                }

            }
        }
        composable<Ekran.UrunDetay> { backStackEntry ->
            val args = backStackEntry.toRoute<Ekran.UrunDetay>()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Ürün Detay Sayfası")
              Text("Ürün ID: ${args.urunId}")


            }

        }
    }

}


