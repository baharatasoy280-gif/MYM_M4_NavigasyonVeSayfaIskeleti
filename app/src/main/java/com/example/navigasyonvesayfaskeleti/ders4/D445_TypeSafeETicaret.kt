package com.example.navigasyonvesayfaskeleti.ders4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

sealed class Sayfa {
    @Serializable
    object Kategoriler : Sayfa()

    @Serializable
    data class UrunListesi(val kategoriAdi: String) : Sayfa()

    @Serializable
    data class UrunDetay(val urunId: Int) : Sayfa()
}

@Composable
fun D445_TypeSafeETicaret(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Sayfa.Kategoriler,
        modifier = modifier
    ) {
        composable<Sayfa.Kategoriler> {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Kategoriler", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = { navController.navigate(Sayfa.UrunListesi("Elektronik")) }) {
                    Text("Elektronik Kategorisine Git")
                }
                Spacer(modifier = Modifier.height(20.dp))


                Button(onClick = { navController.navigate(Sayfa.UrunListesi("Giyim")) }) {
                    Text("Giyim Kategorisine Git")
                }
            }
        }

        composable<Sayfa.UrunListesi> { backStackEntry ->
            val args = backStackEntry.toRoute<Sayfa.UrunListesi>()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Kategori Adı: ${args.kategoriAdi}",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = { navController.navigate(Sayfa.UrunDetay(1453)) }) {
                    Text("1453 Numaralı Ürünün Detayına Git")
                }
                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = { navController.navigate(Sayfa.UrunDetay(2023)) }) {
                    Text("2023 Numaralı Ürünün Detayına Git")
                }
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedButton(onClick = { navController.popBackStack() }) {
                    Text("Geri Dön")
                }
            }

        }

        composable<Sayfa.UrunDetay> { backStackEntry ->
            val args = backStackEntry.toRoute<Sayfa.UrunDetay>()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Kategoriler", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(20.dp))

                Text("Gelen Ürün ID'si ${args.urunId}")

                Spacer(modifier = Modifier.height(20.dp))
                OutlinedButton(onClick = { navController.popBackStack() }) {
                    Text("Geri Dön")
                }


            }


        }

    }
}

