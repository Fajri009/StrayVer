package com.fajri.strayver.data.model

import com.fajri.strayver.model.Donasi

data class DonasiModelResponse(
    val item: Donasi? = Donasi(),
    val key: String? = ""
)
