package com.gabriel.game_store.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable



@Serializable
sealed class BottomNavItems<T>(val label: String, val icon: @Contextual ImageVector, val route: T) {
    @Serializable
    data object Home : BottomNavItems<HomeScreen>(
        label = "Home",
        icon = Icons.Filled.Home,
        route = HomeScreen
    )

    @Serializable
    data object Search : BottomNavItems<SearchScreen>(
        label = "Search",
        icon = Icons.Filled.Search,
        route = SearchScreen
    )

    @Serializable
    data object Favorites : BottomNavItems<FavoritesScreen>(
        label = "Favorites",
        icon = Icons.Filled.Favorite,
        route = FavoritesScreen
    )
}
