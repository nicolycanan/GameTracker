package br.com.nicolycanan.gametracker.model

import androidx.annotation.DrawableRes

data class Game(
    val id: Int,
    val name: String,
    @DrawableRes val imageRes: Int,
    val description: String
)