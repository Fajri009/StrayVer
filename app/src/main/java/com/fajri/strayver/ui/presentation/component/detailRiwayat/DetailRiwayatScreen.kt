package com.fajri.strayver.ui.presentation.relawan.detailRiwayat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.relawan.detailRiwayat.component.DetailRiwayatContent
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Type

@Composable
fun DetailRiwayatScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(
            model = R.drawable.ilustrasi,
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                modifier = Modifier.padding(20.dp),
                text = "Detail Riwayat",
                color = Color.White,
                style = Type.displayXsSemiBold()
            )
            DetailRiwayatContent()
        }
    }
}