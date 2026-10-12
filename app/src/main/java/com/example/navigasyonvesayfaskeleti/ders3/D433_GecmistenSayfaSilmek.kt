package com.example.navigasyonvesayfaskeleti.ders3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun D433_GecmistenSayfaSilmek(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "ana_sayfa", modifier) {
        composable("ana_sayfa") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Restoran Ana Sayfası")
                Button(onClick = { navController.navigate("sepet_sayfasi") }) {
                    Text("Sepete Git")

                }
            }
        }
        composable("sepet_sayfasi") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Sepet Sayfası")
                Button(onClick = { navController.navigate("odeme_sayfasi") }) {
                    Text("Ödemeye Geç")

                }
            }

        }
        composable("odeme_sayfasi") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Ödeme Sayfası")
                Button(onClick = { navController.navigate("siparis_basarili") }) {
                    Text("Ödemeyi Tamamla")
                }
            }
        }

        composable("siparis_basarili") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Sipariş Başarılı")
                Button(onClick = {
                    navController.navigate("ana_sayfa") {
                        popUpTo("ana_sayfa"){
                            inclusive =true
                        }
                        launchSingleTop =true
                    }

                }) {
                    Text("Anasayfaya Dön")

                }
            }
        }

    }
}