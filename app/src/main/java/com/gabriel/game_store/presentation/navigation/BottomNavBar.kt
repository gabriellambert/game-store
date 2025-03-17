package com.gabriel.game_store.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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

    NavigationBar(
        modifier = Modifier
            .width(210.dp)
            .heightIn( max = 90.dp)
            .clip(shape = RoundedCornerShape(20.dp)),
        containerColor = Color.DarkGray.copy(alpha = 0.5f)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            println("Current route: ${currentDestination?.route}")

            bottomNavDestinations.forEach { destination ->
                println("Checking route: ${destination.route}, Selected: ${currentDestination?.route == destination.route}")
                val isSelected = currentDestination?.route == destination.route::class.qualifiedName


                NavigationBarItem(
                    modifier = Modifier,
                    selected = isSelected,

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

                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(40.dp)
                                .align(Alignment.CenterVertically)
                                .background(if (isSelected) Color.Green else Color.LightGray),
                            contentAlignment = Alignment.Center

                        ) {

                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = destination.icon),
                                contentDescription = destination.label,
                                tint = Color.Black
                            )

                        }

                    },
                    label = {

                        Text(
                            text = destination.label,
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (isSelected) Color.White else Color.Transparent
                        )

                    },
                    colors = NavigationBarItemColors(
                        selectedIconColor = Color.Transparent,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        selectedIndicatorColor = Color.Transparent,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        unselectedTextColor = Color.Black,
                        disabledIconColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
                        disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                    ),
                )
            }
        }
    }
}


@Preview()
@Composable()
private fun BottomNavBarPreview() {
    BottomNavBar(
        navController = NavController(LocalContext.current)
    )
}