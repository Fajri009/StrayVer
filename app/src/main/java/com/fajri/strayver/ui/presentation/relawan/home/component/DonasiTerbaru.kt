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
import com.fajri.strayver.model.DonasiData
import com.fajri.strayver.model.UserData
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.TipeDonasi

@Composable
fun DonasiTerbaru(modifier: Modifier, navController: NavController, donasiData: DonasiData) {
    Column {
        Text(
            text = "Proyek Donasi Terbarumu",
            style = Type.textMdSemiBold(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        DonasiTerbaruItem(
            tipeDonasi = TipeDonasi.DANA,
            image = R.drawable.terbaru2,
            judul = "Dibutuhkan kandang hewan (kucing atau anjing)",
            progress = 0.5f,
            jumlah = "3.258.500",
            navController = navController
        )
//        DonasiTerbaruItem(
//            tipeDonasi = TipeDonasi.BARANG,
//            image = R.drawable.terbaru,
//            judul = "Selamatkan ratusan kucing kelaparan di Kecamatan Tou",
//            progress = 0.3f,
//            jumlah = "10",
//            navController = navController
//        )
    }
}