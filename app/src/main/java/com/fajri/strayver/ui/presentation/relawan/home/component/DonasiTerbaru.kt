package com.fajri.strayver.ui.presentation.relawan.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun DonasiTerbaru(modifier: Modifier, navController: NavController) {
    Column {
        Text(
            text = "Proyek Donasi Terbarumu",
            style = Type.textMdSemiBold(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        DonasiTerbaruItem(R.drawable.terbaru2, "Dibutuhkan kandang hewan (kucing atau anjing)", 0.5f, "10 barang", {})
        DonasiTerbaruItem(R.drawable.terbaru, "Selamatkan ratusan kucing kelaparan di Kecamatan Tou", 0.3f, "Rp 3.258.500", {navController.navigate(Route.TAMBAH_DONASI)})
        DonasiTerbaruItem(R.drawable.terbaru, "Selamatkan ratusan kucing kelaparan di Kecamatan Tou", 0.3f, "Rp 3.258.500", {navController.navigate(Route.TAMBAH_DONASI)})
    }
}