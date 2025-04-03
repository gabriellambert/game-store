package com.gabriel.game_store.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gabriel.game_store.R
import com.gabriel.game_store.presentation.ui.theme.GamestoreTheme

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier.windowInsetsPadding(insets = WindowInsets.systemBars),
    navController: NavController
) {
    GamestoreTheme() {
        IconButton(
            modifier = modifier
                .padding(10.dp),
            onClick = { navController.popBackStack() }) {
            Image(painter = painterResource(R.drawable.back_arrow_icon), contentDescription = null)
        }//TODO(Quando criar layout, adicione o banner do jogo antes da column começar)
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Hi Detail Screen")
        }
    }
}

@Preview(showSystemUi= true)
@Composable
private fun DetailPrev() {
    DetailScreen(navController = TODO())
}