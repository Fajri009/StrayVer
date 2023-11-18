package com.fajri.strayver.data.model

import com.fajri.strayver.model.Artikel
import com.fajri.strayver.model.UserData

data class UserModelResponse(
    val item: UserData? = UserData(),
    val key: String? = ""
)
