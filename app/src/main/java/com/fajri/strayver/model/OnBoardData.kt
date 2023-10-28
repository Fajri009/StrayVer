package com.fajri.strayver.model

import androidx.annotation.DrawableRes

data class OnBoardData(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
)
