package com.fajri.strayver.ui.presentation.relawan.detailRiwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fajri.strayver.model.Transaksi
import com.fajri.strayver.ui.presentation.component.detailRiwayat.DetailRiwayatViewModel
import com.fajri.strayver.ui.presentation.component.detailRiwayat.component.DetailRiwayatDanaCard
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.util.TipeDonasi

@Composable
fun DetailRiwayatContent(transaksi: Transaksi, role: String, viewModel: DetailRiwayatViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Neutral50, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .padding(start = 20.dp, end = 20.dp, top = 31.dp)
    ) {

        when(transaksi.donasiType) {
            TipeDonasi.DANA -> DetailRiwayatDanaCard(transaksi = transaksi, role)
            TipeDonasi.BARANG -> DetailRiwayatBarangCard(transaksi = transaksi, role, viewModel)
        }
    }
}