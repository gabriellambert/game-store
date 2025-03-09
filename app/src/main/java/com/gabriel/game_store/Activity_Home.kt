package com.gabriel.game_store

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabriel.game_store.composables.Game_Banners
import com.gabriel.game_store.composables.Game_Item
import com.gabriel.game_store.modules.Games

class Activity_Home : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeBrew()
        }
    }
}

@Composable
fun HomeBrew() {
    Column(modifier = Modifier
        .padding(horizontal = 16.dp)
        .windowInsetsPadding(insets = WindowInsets.systemBars)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(32.dp)){
            Game_Banners().Featured(Games("COD: Warzone", R.drawable.warzone))
            Game_Item().Game_Card_Section("Top Rated", Game_Item().game)
            Game_Banners().Game_Banner_Section("Recommended", Game_Banners().game)
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_TYPE_NORMAL, showBackground = true)
@Composable
private fun PrevHome() {
    HomeBrew()
}

