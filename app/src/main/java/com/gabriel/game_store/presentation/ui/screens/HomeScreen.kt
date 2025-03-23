package com.gabriel.game_store.presentation.ui.screens

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
import com.gabriel.game_store.R
import com.gabriel.game_store.composables.Featured
import com.gabriel.game_store.composables.GameBannerSection
import com.gabriel.game_store.composables.GameCardSection
import com.gabriel.game_store.model.Game

var gameItens: List<Game> = listOf(// TODO(devemos substituir por uma lista vinda da API quando integrada)
    Game(name = "God of War", image = R.drawable.gow),
    Game(name = "The Last Of Us", image = R.drawable.tlou),
    Game(name = "Zelda: Breath of the wild", image = R.drawable.zelda),
    Game(name = "Spider man: Miles Morales", image = R.drawable.milesmorales),
    Game(name = "DarkSouls", image = R.drawable.darksouls)
)

var gameBanner: List<Game> = listOf(
    // TODO(devemos substituir por uma lista vinda da API quando integrada)
    Game(name = "Red Dead Redemption 2", image = R.drawable.rdr2),
    Game(name = "COD: Warzone", image = R.drawable.warzone),
    Game(name = "Red Dead Redemption 2", image = R.drawable.rdr2),
    Game(name = "COD: Warzone", image = R.drawable.warzone),
    Game(name = "Red Dead Redemption 2", image = R.drawable.rdr2),
    Game(name = "COD: Warzone", image = R.drawable.warzone),
)

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
            .windowInsetsPadding(insets = WindowInsets.systemBars),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Featured(game = gameBanner[1])
        GameCardSection(sectionTitle = "Top Rated", games = gameItens)
        GameBannerSection(sectionTitle = "Recommended", games = gameBanner)
    }
}