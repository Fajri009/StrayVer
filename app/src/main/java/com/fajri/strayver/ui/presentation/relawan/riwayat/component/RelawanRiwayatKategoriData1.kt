package com.fajri.strayver.ui.presentation.relawan.riwayat.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.util.DonaturProgres
import com.fajri.strayver.util.TipeDonasi

@Composable
fun RelawanRiwayatKategoriData1(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 20.dp, end = 20.dp)
    ) {
        RelawanRiwayatCard(
            tipe = TipeDonasi.DANA,
            companyIcon = R.drawable.freya,
            companyName = "Freya_Jayawardana",
            progres = DonaturProgres.PROSES,
            judul = "Selamatkan ratusan kucing kelaparan",
            jumlah = "Rp 50.000",
            navController = navController
        )
        RelawanRiwayatCard(
            tipe = TipeDonasi.BARANG,
            companyIcon = R.drawable.louis,
            companyName = "Louis_Tomlinson",
            progres = DonaturProgres.PROSES,
            judul = "Dibutuhkan Kandang Hewan (Kucing atau ...",
            jumlah = "3 pcs",
            navController = navController
        )
        RelawanRiwayatCard(
            tipe = TipeDonasi.DANA,
            companyIcon = R.drawable.haewon,
            companyName = "Oh_Haewon",
            progres = "",
            judul = "Selamatkan ratusan kucing kelaparan",
            jumlah = "Rp 50.000",
            navController = navController
        )
        RelawanRiwayatCard(
            tipe = TipeDonasi.BARANG,
            companyIcon = R.drawable.bruno,
            companyName = "Bruno_Fernandes",
            progres = DonaturProgres.SELESAI,
            judul = "Dibutuhkan Kandang Hewan (Kucing atau ...",
            jumlah = "5 pcs",
            navController = navController
        )
    }
    Divider(
        modifier = Modifier.fillMaxWidth(),
        color = Primary100
    )
}
