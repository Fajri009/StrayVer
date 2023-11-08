package com.fajri.strayver.ui.presentation.relawan.tambahDonasi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.util.DonaturProgres
import com.fajri.strayver.util.Route

@Composable
fun TambahDonasiContainerDonatur(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)
    ) {
        LazyColumn() {
            item {
                Spacer(modifier = Modifier.height(5.dp))
                TambahDonasiItem(foto = R.drawable.freya, tanggal = "11 November 2023", progres = DonaturProgres.PROSES, nama = "Freya_Jayawardana", jumlah = "3 pcs", onClick = {navController.navigate(Route.DETAIL_RIWAYAT)})
                TambahDonasiItem(foto = R.drawable.louis, tanggal = "9 November 2023", progres = DonaturProgres.SELESAI, nama = "Louis_Tomlinson", jumlah = "1 pc", onClick = {})
                TambahDonasiItem(foto = R.drawable.zee, tanggal = "9 November 2023", progres = DonaturProgres.DIBATALKAN, nama = "Azizi_Asadel", jumlah = "10 pcs", onClick = {})
                TambahDonasiItem(foto = R.drawable.peter, tanggal = "8 November 2023", progres = DonaturProgres.PROSES, nama = "Peter_Parker", jumlah = "5 pcs", onClick = {})
                TambahDonasiItem(foto = R.drawable.chaewon, tanggal = "5 November 2023", progres = DonaturProgres.DIBATALKAN, nama = "Kim_Chaewon", jumlah = "4 pcs", onClick = {})
                TambahDonasiItem(foto = R.drawable.bruno, tanggal = "1 November 2023", progres = DonaturProgres.DIBATALKAN, nama = "Bruno_Fernandes", jumlah = "20 pcs", onClick = {})
                TambahDonasiItem(foto = R.drawable.haewon, tanggal = "20 Oktober 2023", progres = DonaturProgres.SELESAI, nama = "Oh_Haewon", jumlah = "15 pcs", onClick = {})
                TambahDonasiItem(foto = R.drawable.shani, tanggal = "15 Oktober 2023", progres = DonaturProgres.SELESAI, nama = "Shani_Indira_Natio", jumlah = "20 pcs", onClick = {})
            }
        }
    }
}