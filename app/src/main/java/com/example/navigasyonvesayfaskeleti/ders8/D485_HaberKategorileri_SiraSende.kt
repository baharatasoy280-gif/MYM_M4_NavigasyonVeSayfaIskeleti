package com.example.navigasyonvesayfaskeleti.ders8

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigationevent.NavigationEventDispatcher


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun D485_HaberKategorileri_SiraSende() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column() {
                TopAppBar(
                    title = {
                        Text(
                            " \uD83D\uDCF0 Haber Ekpress",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Notifications, contentDescription = "Bildirimler")
                        }
                        IconButton(onClick = {}) {
                            Icon(Icons.Default.Search, contentDescription = "Bildirimler")

                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFFB81B1C),
                        titleContentColor = Color.White,
                        actionIconContentColor = Color.White
                    )
                )
                PrimaryTabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = Color(0xFFB81B1C)
                ) {
                    Tab(
                        selected = selectedTabIndex == 0,
                        onClick = { selectedTabIndex = 0 },
                        text = { Text("Gündem", fontSize = 13.sp) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color(0xFFFAE2E2)
                    )
                    Tab(
                        selected = selectedTabIndex == 1,
                        onClick = { selectedTabIndex = 1 },
                        text = { Text("Ekonomi", fontSize = 13.sp) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color(0xFFFAE2E2)
                    )
                    Tab(
                        selected = selectedTabIndex == 2,
                        onClick = { selectedTabIndex = 2 },
                        text = { Text("Spor", fontSize = 13.sp) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color(0xFFFAE2E2)
                    )
                    Tab(
                        selected = selectedTabIndex == 3,
                        onClick = { selectedTabIndex = 3 },
                        text = { Text("Teknoloji", fontSize = 13.sp) },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color(0xFFFAE2E2)
                    )

                }

            }
        }


    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
               // .padding(16.dp)
                .background(Color(0xFFF6F8F9))
        ) {
            when (selectedTabIndex) {
                0 -> GundemHaberleriEkrani()
                1 -> EkonomiHaberleriEkrani()
                2 -> SporHaberleriEkrani()
                3 -> TeknolojiHaberleriEkrani()
            }


        }


    }

}

@Composable
fun GundemHaberleriEkrani() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            HaberKartiItem(
                etiket = "⚡ SON DAKİKA",
                baslik = "Küresel Çevre Zirvesi İstanbul'da Başladı",
                ozet = "Liderler sürdürülebilir enerji ve sıfır karbon hedeflerini görüşmek üzere bir araya geldi.",
                saat = "15 dk önce"
            )
        }
        item {
            HaberKartiItem(
                etiket = "🌍 GÜNDEM",
                baslik = "Yeni Hızlı Tren Hattı Hizmete Açılıyor",
                ozet = "Ulaşım süresini yarı yarıya indirecek mega projede ilk seferler bu hafta sonu başlıyor.",
                saat = "45 dk önce"
            )
        }
    }
}

@Composable
fun EkonomiHaberleriEkrani() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            HaberKartiItem(
                etiket = "📈 BORSA",
                baslik = "Borsa Endeksi Haftaya Yükselişle Başladı",
                ozet = "Teknoloji ve sanayi hisseleri öncülüğünde BIST 100 endeksi yeni rekor seviyesini test ediyor.",
                saat = "1 saat önce"
            )
        }
        item {
            HaberKartiItem(
                etiket = "💰 FİNANS",
                baslik = "Merkez Bankası Yıl Sonu Enflasyon Raporunu Açıkladı",
                ozet = "Piyasaların merakla beklediği üçüncü çeyrek enflasyon tahminleri kamuoyuyla paylaşıldı.",
                saat = "2 saat önce"
            )
        }
    }
}

@Composable
fun SporHaberleriEkrani() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            HaberKartiItem(
                etiket = "⚽ FUTBOL",
                baslik = "Süper Lig'de Dev Derbi Heyecanı Yaklaşıyor",
                ozet = "Şampiyonluk yarışındaki iki dev ekip pazar günü kozlarını paylaşacak. Biletler tükendi.",
                saat = "30 dk önce"
            )
        }
        item {
            HaberKartiItem(
                etiket = "🏀 BASKETBOL",
                baslik = "Milli Takım Avrupa Şampiyonası Elemelerinde Galip",
                ozet = "Son saniye üçlüğüyle maçı kazanan 12 Dev Adam gruptan çıkmayı garantiledi.",
                saat = "3 saat önce"
            )
        }
    }
}

@Composable
fun TeknolojiHaberleriEkrani() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            HaberKartiItem(
                etiket = "🤖 YAPAY ZEKA",
                baslik = "Yeni Nesil Açık Kaynaklı Yapay Zeka Modelleri Duyuruldu",
                ozet = "Mobil cihazlarda yerel çalışan modeller yazılımcıların kullanımına ücretsiz açıldı.",
                saat = "10 dk önce"
            )
        }
        item {
            HaberKartiItem(
                etiket = "💻 KOTLIN & COMPOSE",
                baslik = "Jetpack Compose 1.8 ile Sekme Animasyonları Hızlandı",
                ozet = "TabRow ve Scaffold performans iyileştirmeleri bellek kullanımını %40 oranında azalttı.",
                saat = "1 saat önce"
            )
        }
    }
}

// Ortak Haber Kartı Bileşeni
@Composable
fun HaberKartiItem(
    etiket: String,
    baslik: String,
    ozet: String,
    saat: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                text = etiket,
                color = Color(0xFFB91C1C),
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = baslik,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color(0xFF1E293B)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = ozet,
                fontSize = 13.sp,
                lineHeight = 18.sp,
                color = Color(0xFF64748B)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = saat, fontSize = 11.sp, color = Color(0xFF94A3B8))
        }
    }
}
