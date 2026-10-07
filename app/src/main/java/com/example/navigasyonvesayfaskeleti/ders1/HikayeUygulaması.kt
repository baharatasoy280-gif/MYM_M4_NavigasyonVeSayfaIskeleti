package com.example.navigasyonvesayfaskeleti.ders1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasyonvesayfaskeleti.R

@Composable
fun HikayeUygulamasi(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = "giris_sayfasi"
    ) {
        composable("giris_sayfasi") {
            GirisSayfasi(navController)


        }


        composable("bolum_1") {

            Bolum1Sayfasi(navController)


        }

        composable("son_sayfa") {
            SonSayfa(navController)


        }

    }

}

@Composable
fun GirisSayfasi(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(

            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(64.dp)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = CircleShape
                ),

            ) {
            Text("\uD83D\uDCDA", fontSize = 32.sp)
            Spacer(modifier = Modifier.height(16.dp))


        }
        Text(
            text = "Karanlık Orman", fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.orman_giris),
            contentDescription = "Orman Resmi",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Karanlık bir ormanın girişindesin. İçeriden garip sesler geliyor. Ne yapacaksın?",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("bolum_1") }) {
            Text("Ormana Giriş")

        }
    }
}

@Composable
fun Bolum1Sayfasi(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(

            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(64.dp)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = CircleShape
                ),

            ) {
            Text(" \uD83C\uDF32", fontSize = 32.sp)
            Spacer(modifier = Modifier.height(16.dp))


        }
        Text(
            text = "Ormanın Derinlikleri", fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.magara_giris),
            contentDescription = "Mağara Resmi",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "İlerledikçe hava soğudu. Karşına parlayan bir mağara çıktı.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("son_sayfa") }) {
            Text("Mağaraya Gir")

        }
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(onClick = { navController.popBackStack() }) {
            Text("Korktum Geri Dön")

        }

    }
}
@Composable
fun SonSayfa(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Box(

            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(64.dp)
                .background(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = CircleShape
                ),

            ) {
            Text("\uD83D\uDC8E", fontSize = 32.sp)
            Spacer(modifier = Modifier.height(16.dp))


        }
        Text(
            text = "Hazine Bulundu", fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.magara_giris),
            contentDescription = "hazine_magarasi",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Mağaranın sonunda devasa bir hazine buldun. Macera başarıyla tamamlandı!",
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("giris_sayfasi") }) {
            Text("Yeniden la")

        }
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(onClick = { navController.popBackStack() }) {
            Text("Korktum Geri Dön")

        }

    }
}
