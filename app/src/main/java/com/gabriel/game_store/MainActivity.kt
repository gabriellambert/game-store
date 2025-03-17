package com.gabriel.game_store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.gabriel.game_store.presentation.navigation.MyNavHost
import com.gabriel.game_store.presentation.navigation.BottomNavBar
import com.gabriel.game_store.presentation.ui.theme.GamestoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamestoreTheme {
                val navController = rememberNavController()
                Scaffold(
                    floatingActionButton = {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 6.dp, start = 30.dp)
                        ) {
                        BottomNavBar(
                        navController = navController

                    ) }}
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        MyNavHost(
                            navController = navController,
                            modifier = Modifier
                                .fillMaxSize()

                        )
                    }
                }
            }
        }
    }
}