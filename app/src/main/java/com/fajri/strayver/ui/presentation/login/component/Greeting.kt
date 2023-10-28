package com.fajri.strayver.ui.presentation.login.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.fajri.strayver.ui.theme.Neutral700
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type

@Composable
fun Greeting() {
    Text(
        text = "Selamat Datang,",
        color = Primary900,
        style = Type.textLgSemiBold()
    )
    Text(
        text = "Halo, silahkan masuk untuk melanjutkan!",
        color = Neutral700,
        style = Type.textXsRegular()
    )
}