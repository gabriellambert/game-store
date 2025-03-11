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
import com.gabriel.game_store.modules.Games


class Game_Banners {

    var game: List<Games> = listOf( // lista em memória que deverá ser substituída por uma lista vinda da API quando integrada
        Games(name = "Red Dead Redemption 2", image = R.drawable.rdr2),
        Games(name = "COD: Warzone", image = R.drawable.warzone),
        Games(name = "Red Dead Redemption 2", image = R.drawable.rdr2),
        Games(name = "COD: Warzone", image = R.drawable.warzone),
        Games(name = "Red Dead Redemption 2", image = R.drawable.rdr2),
        Games(name = "COD: Warzone", image = R.drawable.warzone),

    )

    @Composable
    fun GameBanner(game: Games, modifier: Modifier = Modifier) { // Imagem maior do jogo
        Image(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(16.dp))
                .clickable {  }
                .focusable()
            ,
            painter = painterResource(id = game.image), // recebe a imagem do objeto Games.kt
            contentDescription = "Game Banner",
            contentScale = ContentScale.Crop
        )

    }

    @Composable
    fun Featured(game: Games) { // Seção que deixará o banner com maior tamanho/destaque
        Column{
            Text("Featured",
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp))
            Box(modifier = Modifier
                .height(235.dp)){
                GameBanner(game, modifier = Modifier.fillMaxSize()) // chama a imagem do jogo

            }
        }
    }
    @Composable
    fun Game_Banner_Section(sectionTitle: String, games: List<Games>) { // lista com imagens maiores dos jogos
        Column {
            Text(sectionTitle, modifier = Modifier.padding(bottom = 8.dp))
            Row(
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .height(90.dp),
                horizontalArrangement = Arrangement.spacedBy(21.dp),
            ) {
                games.forEach(){Games ->
                    GameBanner(Games, modifier = Modifier.width(180.dp))
                }
                }

            }
        }

}
