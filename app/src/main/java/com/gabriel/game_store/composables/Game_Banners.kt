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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gabriel.game_store.R
import com.gabriel.game_store.modules.Games


class Game_Banners {

    var game: List<Games> = listOf(
        Games("Red Dead Redemption 2", R.drawable.rdr2),
        Games("COD: Warzone", R.drawable.warzone),
        Games("Red Dead Redemption 2", R.drawable.rdr2),
        Games("COD: Warzone", R.drawable.warzone),
        Games("Red Dead Redemption 2", R.drawable.rdr2),
        Games("COD: Warzone", R.drawable.warzone),

    )

    @Composable
    fun GameBanner(game: Games, modifier: Modifier = Modifier) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(16.dp))
                .clickable { }
                .focusable()
            ,
            painter = painterResource(id = game.image),
            contentDescription = "Game Banner",
            contentScale = ContentScale.Crop
        )

    }

    @Composable
    fun Featured(game: Games) {
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
    fun Game_Banner_Section(sectionTitle: String, games: List<Games>) {
        Column {
            Text(sectionTitle, modifier = Modifier.padding(bottom = 8.dp))
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .height(90.dp),
                horizontalArrangement = Arrangement.spacedBy(21.dp),
            ) {
                for(i in games.indices){
                    GameBanner(games[i], modifier = Modifier.width(180.dp))
                    }
                }

            }
        }

    @Preview(showBackground = true)
    @Composable
    private fun sectionPrev() {
        Game_Banner_Section("Recommended", game)
    }

}
