package com.example.navigasyonvesayfaskeleti.ders7

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

sealed class HaberRota {
    @Serializable
    object Gundem : HaberRota()

    @Serializable
    object Teknoloji : HaberRota()

    @Serializable
    object Kaydedilenler : HaberRota()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun D475_HaberPortaliSiraSende() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet() {
                HaberDrawerHeader()
                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
                NavigationDrawerItem(
                    label = { Text("Gündem & Son Dakika") },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Gündem") },
                    badge = { Text("12", fontWeight = FontWeight.Bold) },
                    selected = currentDestination?.hasRoute(HaberRota.Gundem::class) == true,
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate(HaberRota.Gundem) {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true

                            }
                            restoreState = true
                        }

                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)


                )
                NavigationDrawerItem(
                    label = { Text("Teknoloji & Bilim") },
                    icon = { Icon(Icons.Default.Star, contentDescription = "Teknoloji") },
                    badge = {
                        Text(
                            "Yeni",
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    },
                    selected = currentDestination?.hasRoute(HaberRota.Teknoloji::class) == true,
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate(HaberRota.Teknoloji) {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true

                            }
                            restoreState = true
                        }

                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)


                )

                NavigationDrawerItem(
                    label = { Text("Kaydedilen Haberler") },
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Kaydedilenler") },
                    badge = { Text("4") },
                    selected = currentDestination?.hasRoute(HaberRota.Kaydedilenler::class) == true,
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate(HaberRota.Kaydedilenler) {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true

                            }
                            restoreState = true
                        }

                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )

            }
        }


    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        val sayfaBasligi = when {
                            currentDestination?.hasRoute(HaberRota.Teknoloji::class) == true -> "Teknoloji Dünyasi"
                            currentDestination?.hasRoute(HaberRota.Teknoloji::class) == true -> "Kaydedilenler"
                            else -> "Haber360 Gündem"
                        }
                        Text(sayfaBasligi, fontWeight = FontWeight.Bold)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Kategori Menüsü Aç")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = Color.Black
                    )
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = HaberRota.Gundem,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable<HaberRota.Gundem> {
                    HaberGundemEkrani()

                }
                composable<HaberRota.Teknoloji> {
                    HaberTeknolojiEkrani()

                }
                composable<HaberRota.Kaydedilenler> {
                    HaberKaydedilenlerEkrani()

                }
            }

        }

    }
}


@Composable
fun HaberDrawerHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "360",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "Haber 360",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Dijital Haber Portalı",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Son Güncelleme: 14:30 • Canlı Akış",
            fontSize = 11.sp,
            color = MaterialTheme.colorScheme.outline
        )
    }
}

@Composable
fun HaberGundemEkrani() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "⚡ Son Dakika & Manşetler",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
        item {
            HaberKarti(
                etiket = "🔴 CANLI",
                baslik = "Yapay Zeka ve Geleceğin Teknolojileri Zirvesi Başladı",
                ozet = "Dünyanın önde gelen teknoloji liderleri, yeni nesil üretken yapay zekayı ve mobil ekosistemdeki etkilerini tartışıyor.",
                zaman = "12 dk önce • Gündem Masası"
            )
        }
        item {
            HaberKarti(
                etiket = "🌍 DÜNYA",
                baslik = "Temiz Enerji Yatırımlarında Küresel Rekor Kırıldı",
                ozet = "Güneş ve rüzgar enerjisi santralleri, bu yıl küresel elektrik üretiminin %35'ini karşılayarak tarihe geçti.",
                zaman = "40 dk önce • Çevre & Ekonomi"
            )
        }
        item {
            HaberKarti(
                etiket = "🚀 BİLİM",
                baslik = "Yeni Nesil Derin Uzay Teleskobu İlk Verilerini Gönderdi",
                ozet = "Gökbilimciler, erken evrene ait bugüne kadar kaydedilmiş en net yıldız kümesi görüntülerini kamuoyuyla paylaştı.",
                zaman = "1 saat önce • Bilim Masası"
            )
        }
    }
}

@Composable
fun HaberTeknolojiEkrani() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "💻 Teknoloji, Yazılım & İnovasyon",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
        item {
            HaberKarti(
                etiket = "⚡ KOTLIN",
                baslik = "Kotlin 2.0 ve K2 Derleyicisiyle Jetpack Compose Çok Daha Hızlı",
                ozet = "Yeni derleyici mimarisi, derleme sürelerini yarı yarıya indirirken tip güvenliğini en üst seviyeye taşıyor.",
                zaman = "2 saat önce • Yazılım Dünyası"
            )
        }
        item {
            HaberKarti(
                etiket = "📱 ANDROID",
                baslik = "Android 16 Geliştirici Önizlemesi Yayınlandı: Tahmini Geri Tuşu Varsayılan Oluyor",
                ozet = "Modern navigasyon ve çekmece (drawer) animasyonları yeni sürümle birlikte çok daha akıcı hale geliyor.",
                zaman = "3 saat önce • Mobil Geliştirme"
            )
        }
        item {
            HaberKarti(
                etiket = "🤖 YAPAY ZEKA",
                baslik = "Cihaz Üzerinde Çalışan Küçük Dil Modelleri Yaygınlaşıyor",
                ozet = "İnternet bağlantısı olmadan yerel cihaz üzerinde çalışan yapay zeka asistanları gizlilik standartlarını yükseltiyor.",
                zaman = "5 saat önce • AI Araştırma"
            )
        }
    }
}

@Composable
fun HaberKaydedilenlerEkrani() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "⭐ Okuma Listem (4 Kayıtlı Haber)",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.primary
            )
        }
        item {
            HaberKarti(
                etiket = "📌 OKUMA LİSTESİ",
                baslik = "Kotlin 2.0 ve K2 Derleyicisiyle Jetpack Compose Çok Daha Hızlı",
                ozet = "Daha sonra okumak üzere kaydettiğiniz makale. Tahmini okuma süresi: 4 dakika.",
                zaman = "Kaydedildi • Yazılım Dünyası"
            )
        }
        item {
            HaberKarti(
                etiket = "📌 OKUMA LİSTESİ",
                baslik = "Temiz Enerji Yatırımlarında Küresel Rekor Kırıldı",
                ozet = "Daha sonra okumak üzere kaydettiğiniz makale. Tahmini okuma süresi: 3 dakika.",
                zaman = "Kaydedildi • Çevre & Ekonomi"
            )
        }
        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "💡 İpucu: Beğendiğiniz haberleri kart üzerindeki yer işareti ikonuna basarak bu listeye ekleyebilirsiniz.",
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(14.dp)
                )
            }
        }
    }
}

// Ortak Haber Kartı Bileşeni
@Composable
fun HaberKarti(
    etiket: String,
    baslik: String,
    ozet: String,
    zaman: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Text(
                text = etiket,
                fontWeight = FontWeight.Bold,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = baslik,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = ozet,
                fontSize = 13.sp,
                lineHeight = 18.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = zaman,
                fontSize = 11.sp,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}