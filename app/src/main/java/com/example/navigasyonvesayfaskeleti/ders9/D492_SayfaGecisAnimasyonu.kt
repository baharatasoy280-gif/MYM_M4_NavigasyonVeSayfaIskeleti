package com.example.navigasyonvesayfaskeleti.ders9

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

sealed interface D492Rotalar {
    @Serializable
    data object AnaEkran : D492Rotalar

    @Serializable
    data object DetayEkran : D492Rotalar
}


@Composable
fun D492_SayfaGecisAnimasyonlari(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = D492Rotalar.AnaEkran,
        modifier = modifier,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(400)
            ) + fadeIn(tween(400))
            //      scaleIn(initialScale = 2f, animationSpec = tween(400))

        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(400)
            ) + fadeOut(tween(4000))
            //   scaleOut(targetScale = 0f, animationSpec = tween(400))

        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(400)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(400)
            )
        },


        ) {
        composable<D492Rotalar.AnaEkran> {
            D492AnaEkran(navController = navController)
        }

        composable<D492Rotalar.DetayEkran> {
            D492DetayEkrani(navController = navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun D492AnaEkran(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("🎬 Sayfa Animasyonları", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF005A9E),
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF0F8FF))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Bilgi Kartı
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = Color(0xFF005A9E)
                        )
                        Text(
                            text = "1. Aşama: Ana Sayfa",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF005A9E)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Aşağıdaki butona bastığınızda 'enterTransition' ve 'exitTransition' devreye girecek:\n\n" +
                                "• Detay Ekranı sağdan sola doğru kayarak gelecek (SlideDirection.Left + fadeIn).\n" +
                                "• Bu ekran ise sola doğru kayıp solarak sahneden çıkacak.",
                        fontSize = 14.sp,
                        color = Color(0xFF334155),
                        lineHeight = 20.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Detaya Git Butonu (navController ile doğrudan yönlendirme)
            Button(
                onClick = {
                    navController.navigate(D492Rotalar.DetayEkran)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF005A9E))
            ) {
                Text(
                    "Detay Sayfasına İlerle",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = null
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun D492DetayEkrani(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("📄 Detay Sayfası", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Geri Dön",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF16A34A),
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFFF0FDF4))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null,
                            tint = Color(0xFF16A34A)
                        )
                        Text(
                            text = "2. Aşama: Detay Sayfası Açıldı",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF16A34A)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Geri tuşuna veya aşağıdaki butona bastığınızda 'popEnterTransition' ve 'popExitTransition' devreye girecek:\n\n" +
                                "• Bu detay ekranı sağa doğru kayıp solarak yok olacak (SlideDirection.Right + fadeOut).\n" +
                                "• Ana ekran ise soldan sağa geri gelecek (SlideDirection.Right + fadeIn).",
                        fontSize = 14.sp,
                        color = Color(0xFF334155),
                        lineHeight = 20.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedButton(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF16A34A))
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Geri Dön (Ana Ekrana Akış)",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
