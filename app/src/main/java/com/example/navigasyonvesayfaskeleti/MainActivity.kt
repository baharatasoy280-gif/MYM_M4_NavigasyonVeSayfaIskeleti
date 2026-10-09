package com.example.navigasyonvesayfaskeleti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.navigasyonvesayfaskeleti.ders2.KahveSiparisUygulamasi
import com.example.navigasyonvesayfaskeleti.ders3.D433_GecmistenSayfaSilmek
import com.example.navigasyonvesayfaskeleti.ui.theme.GR01_MYM_M4_NavigasyonVeSayfaİskeletiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GR01_MYM_M4_NavigasyonVeSayfaİskeletiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    KahveSiparisUygulamasi(modifier= Modifier.padding(innerPadding))





                }
            }
        }
    }
}



