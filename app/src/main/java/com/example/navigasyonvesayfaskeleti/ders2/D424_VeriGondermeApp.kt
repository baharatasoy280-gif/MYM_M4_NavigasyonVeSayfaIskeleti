package com.example.navigasyonvesayfaskeleti.ders2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun D424_VeriGondermeApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "anket_sayfasi") {
        composable("anket_sayfasi") {

            AnketSayfasi(navController)

        }
        composable("sonuc_sayfasi/{secilenRenk}") { backStackEntry ->
            val secilenRenk = backStackEntry.arguments?.getString("secilenRenk")

            SonucSayfasi(navController, secilenRenk)
        }
    }

}

@Composable
fun AnketSayfasi(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "En sevdiğin renk hangisi?",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = { navController.navigate("sonuc_sayfasi/Kırmızı") }) {
                Text("Kırmızı")
            }
            Button(onClick = { navController.navigate("sonuc_sayfasi/Mavi") }) {
                Text("Mavi")
            }
        }
    }
}

@Composable
fun SonucSayfasi(navController: NavController, renk: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Seçtiğin renk: ${renk ?: "Bilinmiyor"}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Geri Dön ")
        }
    }
}






