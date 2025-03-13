package com.gabriel.game_store.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.sp
import com.gabriel.game_store.R
import com.gabriel.game_store.model.Game


class GameBanners {

    var game: List<Game> = listOf( // TODO(devemos substituir por uma lista vinda da API quando integrada)
        Game(name = "Red Dead Redemption 2", image = R.drawable.rdr2),
        Game(name = "COD: Warzone", image = R.drawable.warzone),
        Game(name = "Red Dead Redemption 2", image = R.drawable.rdr2),
        Game(name = "COD: Warzone", image = R.drawable.warzone),
        Game(name = "Red Dead Redemption 2", image = R.drawable.rdr2),
        Game(name = "COD: Warzone", image = R.drawable.warzone),

    )

    @Composable
    fun GameBanner(game: Game, modifier: Modifier) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(16.dp))
                .clickable {  }
                .focusable()
            ,
            painter = painterResource(id = game.image),
            contentDescription = "Game Banner",
            contentScale = ContentScale.Crop
        )

    }

    @Composable
    fun Featured(game: Game) {
        Column{
            Text("Featured",
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp))
            Box(modifier = Modifier
                .height(235.dp)){
                GameBanner(game, modifier = Modifier.fillMaxSize())

            }
        }
    }
    @Composable
    fun GameBannerSection(sectionTitle: String, games: List<Game>) {
        Column {
            Text(sectionTitle, modifier = Modifier.padding(bottom = 8.dp))
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .height(90.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                games.forEach{i ->
                    GameBanner(i, modifier = Modifier.width(180.dp))
                }
                }

            }
        }

}
