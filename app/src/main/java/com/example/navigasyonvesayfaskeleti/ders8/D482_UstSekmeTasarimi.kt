package com.example.navigasyonvesayfaskeleti.ders8

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Expand
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun D482_UstSekmeTasarimi() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column() {
                TopAppBar(
                    title = {
                        Text("Whatsapp", color = Color.White, fontWeight = FontWeight.Bold)
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xff075E54)
                    )
                )
                SecondaryScrollableTabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = Color(0xff075E54)

                ) {
                    Tab(
                        selected = selectedTabIndex == 0,
                        onClick = { selectedTabIndex = 0 },
                        text = { Text("Sohbetler") },
                        //  icon = { Icon(Icons.Default.Email, contentDescription = "Sohbetler") },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color(0xFFCCE5CB)


                    )
                    Tab(
                        selected = selectedTabIndex == 1,
                        onClick = { selectedTabIndex = 1 },
                        text = { Text("Durumum") },
                        //  icon = { Icon(Icons.Default.Update, contentDescription = "Durumum") },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color(0xFFCCE5CB)


                    )
                    Tab(
                        selected = selectedTabIndex == 2,
                        onClick = { selectedTabIndex = 2 },
                        text = { Text("Aramalar") },
                        //   icon = { Icon(Icons.Default.Call, contentDescription = "Aramalar") },
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.Gray


                    )


                }

            }


        }


    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .padding(24.dp)) {
            when (selectedTabIndex) {
                0 -> Text("Sohbetler Ekranı")
                0 -> Text("Durumum Ekranı")
                0 -> Text("Aramalar Ekranı")


            }
        }


    }


}


