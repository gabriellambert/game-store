package com.gabriel.game_store.model

import androidx.annotation.DrawableRes

data class Game(
    val name: String,
    @DrawableRes val image: Int,
)