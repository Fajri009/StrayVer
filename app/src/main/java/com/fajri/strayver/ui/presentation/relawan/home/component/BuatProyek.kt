package com.fajri.strayver.ui.presentation.relawan.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Neutral900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun BuatProyek(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Buat Proyek Donasimu!",
            style = Type.textMdSemiBold(),
            color = Neutral900,
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TemplateBuatProyek(
                judul = "Proyek \nDonasi Dana",
                image = R.drawable.money,
                color1 = Color(0xFFEE7180),
                color2 = Color(0xFFFDECEE),
                onClick = {navController.navigate(Route.BUAT_PROYEK)}
            )
            TemplateBuatProyek(
                judul = "Proyek \nDonasi Barang",
                image = R.drawable.barang,
                color1 = Color(0xFF02C0E5),
                color2 = Color(0xFFD9F9FF),
                onClick = {navController.navigate(Route.BUAT_PROYEK)}
            )
        }
    }
}