package com.gabriel.game_store.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gabriel.game_store.R
import com.gabriel.game_store.model.Game

@Composable
fun GameBanner(game: Game, modifier: Modifier, navController: NavController) {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(20.dp))
            .clickable { navController.navigate("DetailScreen") }
            .focusable(),
        painter = painterResource(id = game.image),
        contentDescription = "Game Banner",
        contentScale = ContentScale.Crop
    )

}

@Composable
fun Featured(game: Game, navController: NavController) {
    Column {
        Text(
            text = stringResource(R.string.featured),
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        Box(
            modifier = Modifier
                .height(235.dp)
        ) {
            GameBanner(game, modifier = Modifier.fillMaxSize(), navController = navController)

        }
    }
}

@Composable
fun GameBannerSection(sectionTitle: String, games: List<Game>, navController: NavController) {
    Column {
        Text(sectionTitle, modifier = Modifier.padding(bottom = 8.dp))
        LazyRow(
            modifier = Modifier.height(90.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            items(games.size) { i ->
                GameBanner(
                    games[i],
                    modifier = Modifier.width(180.dp),
                    navController = navController
                )
            }

        }
    }

}
