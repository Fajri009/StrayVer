package com.fajri.strayver.ui.presentation.relawan.detailRiwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.detailRiwayat.component.DetailRiwayatDanaCard
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.util.DonaturProgres

@Composable
fun DetailRiwayatContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Neutral50, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .padding(start = 20.dp, end = 20.dp, top = 31.dp)
    ) {
        DetailRiwayatBarangCard(
            kode = "-NdB81uc2ih6fsOQF18H",
            judul = "Dibutuhkan Kandang Hewan (Kucing atau Anjing)",
            nama = "Freya Jayawardana",
            jumlah = 3,
            tanggal = "21 Oktober 2023",
            status = DonaturProgres.PROSES,
            ekspedisi = "JnT Express",
            noResi = "9734817579829",
            deskripsi = "Kandang Kucing 3 buah ukuran medium warna ungu, hitam, biru. Warna sedikit pudar. Tidak ada cacat.",
            gambar = R.drawable.gambar_barang
        )
//        DetailRiwayatDanaCard(
//            kode = "-NdB81uc2ih6fsOQF18H",
//            judul = "Dibutuhkan Kandang Hewan (Kucing atau Anjing)",
//            nama = "Freya Jayawardana",
//            tanggal = "21 Oktober 2023",
//            metode = "Saldo StrayVer",
//            total = "50.000"
//        )
    }
}