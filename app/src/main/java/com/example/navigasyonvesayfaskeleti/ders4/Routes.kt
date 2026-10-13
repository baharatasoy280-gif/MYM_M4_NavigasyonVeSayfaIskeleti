package com.example.navigasyonvesayfaskeleti.ders4

import kotlinx.serialization.Serializable

sealed class Ekran {
    @Serializable
    object AnaSayfa : Ekran()

    @Serializable
    object Ayarlar : Ekran()

    @Serializable
    data class UrunDetay(val urunId: Int) : Ekran()
}

