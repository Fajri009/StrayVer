package com.fajri.strayver.ui.presentation.member.riwayat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.member.riwayat.component.RiwayatContent
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun MemberRiwayatScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(model = R.drawable.ilustrasi, contentDescription = "")
        Text(
            text = "Riwayat Donasi",
            style = Type.displayXsSemiBold(),
            color = Shades50,
            modifier = Modifier.padding(start = 20.dp, top = 52.dp)
        )
        Column(Modifier.align(Alignment.TopStart)) {
            RiwayatContent()
        }
    }
}