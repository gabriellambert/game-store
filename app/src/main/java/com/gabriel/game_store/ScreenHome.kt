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
import com.gabriel.game_store.composables.GameBanners
import com.gabriel.game_store.composables.GameItem
import com.gabriel.game_store.model.Game

class ScreenHome {

@Composable
fun HomeBrew() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .windowInsetsPadding(insets = WindowInsets.systemBars)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        GameBanners().Featured(
            Game(
                name = "COD: Warzone",
                image = R.drawable.warzone
            )
        )
        GameItem().GameCardSection(
            sectionTitle = "Top Rated",
            games = GameItem().game
        )
        GameBanners().GameBannerSection(
            sectionTitle = "Recommended",
            games = GameBanners().game
        )
    }
}
}
