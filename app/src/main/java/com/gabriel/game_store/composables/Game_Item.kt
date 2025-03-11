package com.gabriel.game_store.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gabriel.game_store.R
import com.gabriel.game_store.modules.Games

class Game_Item {

    var game: List<Games> = listOf(// lista em memória que deverá ser substituída por uma lista vinda da API quando integrada
        Games(name = "God of War",image = R.drawable.gow),
        Games(name = "The Last Of Us", image = R.drawable.tlou),
        Games(name = "Zelda: Breath of the wild", image = R.drawable.zelda),
        Games(name = "Spider man: Miles Morales", image = R.drawable.milesmorales),
        Games(name = "DarkSouls", image = R.drawable.darksouls)
    )
    @Composable
    fun Game_Card(game: Games) { // capa do jogo que será exibido nas seções
        Image(modifier = Modifier
            .height(150.dp)
            .width(100.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .clickable { }
            .focusable(),
            painter = painterResource(id = game.image),
            contentDescription = "Game Card",
            contentScale = ContentScale.Crop)
    }

    @Composable
    fun Game_Card_Section(sectionTitle: String, games: List<Games>) { // sessão de jogos
        Column {
            Text(sectionTitle, modifier = Modifier.padding(bottom = 8.dp))
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(19.dp)
            ) {
                games.forEach{ Games ->
                    Game_Card(Games)

                }
            }
        }
    }
}