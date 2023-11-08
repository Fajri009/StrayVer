package com.fajri.strayver.ui.presentation.relawan.detailRiwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.fajri.strayver.ui.theme.Primary50
import com.fajri.strayver.ui.theme.Primary800
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun DetailRiwayatCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary50, RoundedCornerShape(10.dp))
    ) {
        Column {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = "Donasi Barang",
                color = Primary800,
                style = Type.textLgSemiBold(),
                textAlign = TextAlign.Center
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Shades50, RoundedCornerShape(10.dp))
            ) {

            }
        }
    }
}