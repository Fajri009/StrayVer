package com.fajri.strayver.ui.presentation.relawan.riwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.model.Transaksi
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.DonaturProgres
import com.fajri.strayver.util.TipeDonasi

@Composable
fun RelawanRiwayatKategoriData(
    navController: NavController,
    transaksiData: Transaksi
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .background(
                    Primary100,
                    RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                )
                .padding(top = 2.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
            text = transaksiData.tanggal.toString(),
            color = Primary900,
            style = Type.text2xsSemiBold()
        )
        RelawanRiwayatCard(
            tipe = transaksiData.donasiType,
            donaturIcon = R.drawable.freya,
            donaturName = transaksiData.gambar,
            progres = transaksiData.status,
            judul = transaksiData.title,
            jumlah = transaksiData.income.toString(),
            navController = navController
        )
    }
    Divider(
        modifier = Modifier.fillMaxWidth(),
        color = Primary100
    )
}
