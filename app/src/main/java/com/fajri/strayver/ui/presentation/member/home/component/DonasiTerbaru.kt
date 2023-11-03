package com.fajri.strayver.ui.presentation.member.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.register.component.ItemDonasiTerbaru
import com.fajri.strayver.ui.theme.Type

@Composable
fun DonasiTerbaru(modifier: Modifier) {
    Column {
        Text(
            text = "Proyek Donasi Terbarumu",
            style = Type.textMdSemiBold(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        ItemDonasiTerbaru(R.drawable.terbaru, "Dibutuhkan kandang hewan (kucing atau anjing)", "10 barang")
        ItemDonasiTerbaru(R.drawable.terbaru2, "Selamatkan ratusan kucing kelaparan di Kecamatan Tou", "Rp 3.258.500")
    }
}