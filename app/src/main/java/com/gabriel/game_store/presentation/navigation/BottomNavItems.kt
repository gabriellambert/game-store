package com.gabriel.game_store.presentation.navigation

import com.gabriel.game_store.R
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomNavItems<T>(val label: String, val icon: Int, val route: T) {
    @Serializable
    data object Home : BottomNavItems<HomeScreen>(
        label = HOME_LABEL,
        icon = R.drawable.home_icon,
        route = HomeScreen
    )
    @Serializable
    data object Search : BottomNavItems<SearchScreen>(
        label = SEARCH_LABEL,
        icon = R.drawable.search_icon,
        route = SearchScreen
    )
    @Serializable
    data object Favorites : BottomNavItems<FavoritesScreen>(
        label = FAVORITES_LABEL,
        icon = R.drawable.save_icon,
        route = FavoritesScreen
    )
    companion object {
        private const val HOME_LABEL = "Home"
        private const val SEARCH_LABEL = "Search"
        private const val FAVORITES_LABEL = "Saved"
    }
}
