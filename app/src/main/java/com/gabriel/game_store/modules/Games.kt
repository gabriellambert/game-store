package com.gabriel.game_store.modules

import androidx.annotation.DrawableRes

data class Games(
    val name: String,
    @DrawableRes val image: Int,
)