package com.gabriel.game_store


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gabriel.game_store.composables.Game_Banners
import com.gabriel.game_store.composables.Game_Item
import com.gabriel.game_store.modules.Games

class ScreenHome {

@Composable
fun HomeBrew() { // Tela Home
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .windowInsetsPadding(insets = WindowInsets.systemBars)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Game_Banners().Featured(
            Games(
                name = "COD: Warzone",
                image = R.drawable.warzone
            )
        ) // componente visual da seção "Featured"
        Game_Item().Game_Card_Section(
            sectionTitle = "Top Rated",
            games = Game_Item().game
        ) // componente visual da seção "Top Rated"
        Game_Banners().Game_Banner_Section(
            sectionTitle = "Recommended",
            games = Game_Banners().game
        ) // componente visual da seção "Recommended"
    }
}
}
