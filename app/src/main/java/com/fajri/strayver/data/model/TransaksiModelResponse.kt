package com.fajri.strayver.data.model

import com.fajri.strayver.model.Transaksi


data class TransaksiModelResponse(
    val item: Transaksi? = Transaksi(),
    val key: String? = ""
)