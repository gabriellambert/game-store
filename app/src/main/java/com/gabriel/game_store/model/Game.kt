package com.gabriel.game_store.model

import androidx.annotation.DrawableRes
import java.net.URI

data class Game(
    val name: String,
    @DrawableRes val image: Int,
    val background_image: URI? = null
)

