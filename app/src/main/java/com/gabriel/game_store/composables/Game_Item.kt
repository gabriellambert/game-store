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

    var game: List<Games> = listOf(
        Games("God of War", R.drawable.gow),
        Games("The Last Of Us", R.drawable.tlou),
        Games("Zelda: Breath of the wild", R.drawable.zelda),
        Games("Spider man: Miles Morales", R.drawable.milesmorales),
        Games("DarkSouls", R.drawable.darksouls)
    )
    @Composable
    fun Game_Card(game: Games) {
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
    fun Game_Card_Section(sectionTitle: String, games: List<Games>) {
        Column {
            Text(sectionTitle, modifier = Modifier.padding(bottom = 8.dp))
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(19.dp)
            ) {
                Game_Card(games[0])
                Game_Card(games[1])
                Game_Card(games[2])
                Game_Card(games[3])
                Game_Card(games[4])
            }
        }
    }
}