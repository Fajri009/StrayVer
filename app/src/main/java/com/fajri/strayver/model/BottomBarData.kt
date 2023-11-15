package com.fajri.strayver.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

data class BottomBarData(
    val title: String,
    val icon: Painter,
    val relawanRoute: String,
    val memberRoute: String,
    val altRoute: String= "",
    val altRoute2: String = ""
)
