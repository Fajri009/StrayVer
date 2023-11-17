package com.fajri.strayver.data.model

import com.fajri.strayver.model.Artikel

data class ArtikelModelResponse(
    val item: Artikel? = Artikel(),
    val key: String? = ""
)
