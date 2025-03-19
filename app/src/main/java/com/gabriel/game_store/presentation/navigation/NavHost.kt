package com.gabriel.game_store.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gabriel.game_store.presentation.ui.screens.FavoritesScreen
import com.gabriel.game_store.presentation.ui.screens.HomeScreen
import com.gabriel.game_store.presentation.ui.screens.SearchScreen
import kotlinx.serialization.Serializable

@Serializable
object SearchScreen

@Serializable
object HomeScreen

@Serializable
object FavoritesScreen

@Composable
fun MyNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = HomeScreen,
        modifier = modifier.fillMaxSize()
    ) {
        composable<HomeScreen> {
            HomeScreen()
        }
        composable<SearchScreen> {
            SearchScreen()
        }
        composable<FavoritesScreen> {
            FavoritesScreen()
        }
    }
}