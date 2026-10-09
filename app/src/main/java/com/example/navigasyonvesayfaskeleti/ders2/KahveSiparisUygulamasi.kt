package com.example.navigasyonvesayfaskeleti.ders2

import android.view.Menu
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fitInside
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun KahveSiparisUygulamasi(modifier: Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "menu_ekrani") {
        composable("menu_ekrani") {
            MenuEkrani(navController)


        }
        composable("detay_ekrani/{kahveAdi}") { backStackEntry ->
            val gelenKahve = backStackEntry.arguments?.getString("kahveAdi")

            DetayEkrani(navController, gelenKahve)
        }
    }
}

@Composable
fun KahveKarti(isim: String, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(text = "☕ $isim", fontSize = 20.sp, fontWeight = FontWeight.Medium)
            Button(onClick = {
                navController.navigate("detay_ekrani/$isim")
            }) {
                Text("Seç")
            }
        }

    }
}

@Composable
fun MenuEkrani(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Kahve Dünyası",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 24.dp)
        )

        KahveKarti("Espresso", navController)
        Spacer(modifier = Modifier.height(16.dp))
        KahveKarti("Latte", navController)
        Spacer(modifier = Modifier.height(16.dp))
        KahveKarti("Americano", navController)
    }

}

@Composable
fun DetayEkrani(navController: NavController, kahveAdi: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Sipariş Detayı", color = Color.Gray)
        Text(text = " ${kahveAdi ?: "Bilinmiyor"}", fontSize = 36.sp, fontWeight = FontWeight.Bold)
        Text(
            "Harika bir seçim! Kahveniz taze çekirdeklerden hazırlanacaktır.",
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
            Text("Siparişi Onayla ")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.popBackStack() }, modifier = Modifier.fillMaxWidth()) {
            Text("Menüye Dön")
        }


    }
}