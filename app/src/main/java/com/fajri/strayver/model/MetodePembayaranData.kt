package com.fajri.strayver.model

import androidx.annotation.DrawableRes

data class MetodePembayaranData(
    @DrawableRes
    val gambar: Int,
    val nama: String,
    val isEnabled: Boolean
)
