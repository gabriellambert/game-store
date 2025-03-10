package com.gabriel.game_store.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBar(
    navController: NavController,
) {

    val bottomNavDestinations = remember {
        listOf(
            BottomNavItems.Home,
            BottomNavItems.Search,
            BottomNavItems.Favorites,
        )
    }
    NavigationBar {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        bottomNavDestinations.forEach { destination ->

            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any {
                    it.hasRoute(destination.route::class)
                } == true,
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = destination.icon, contentDescription = destination.label
                    )
                },
                label = {
                    Text(
                        text = destination.label,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                    selectedIndicatorColor = MaterialTheme.colorScheme.secondary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    disabledIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                    disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                ),
            )
        }
    }
}