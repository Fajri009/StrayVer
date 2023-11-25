package com.fajri.strayver.data.model

import com.fajri.strayver.model.DonasiData

data class DonasiModelResponse (
    val item: DonasiData? = DonasiData(),
    val key: String? = ""
)