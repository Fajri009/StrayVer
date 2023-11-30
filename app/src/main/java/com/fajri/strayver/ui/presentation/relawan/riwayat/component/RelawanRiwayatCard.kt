package com.fajri.strayver.ui.presentation.relawan.riwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.model.Transaksi
import com.fajri.strayver.ui.presentation.component.CompanyTag
import com.fajri.strayver.ui.presentation.relawan.riwayat.RelawanRiwayatViewModel
import com.fajri.strayver.ui.theme.Neutral700
import com.fajri.strayver.ui.theme.Primary50
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Secondary50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.ui.theme.Warning900
import com.fajri.strayver.util.DonaturProgres
import com.fajri.strayver.util.Route
import com.fajri.strayver.util.TipeDonasi
import com.fajri.strayver.util.formatLongWithDots

@Composable
fun RelawanRiwayatCard(
    transaksiData: Transaksi,
    navController: NavController,
    viewModel: RelawanRiwayatViewModel
) {
    val userData by viewModel.userData

    LaunchedEffect(key1 = true) {
        viewModel.getUserDataByUserId(transaksiData.idMember)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 20.dp, end = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Route.DETAIL_RIWAYAT + "?transaksiId=${transaksiData.transaksiId}")
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .background(
                        when (transaksiData.donasiType) {
                            TipeDonasi.DANA -> Secondary50
                            TipeDonasi.BARANG -> Primary50
                            else -> Color.White
                        }, RoundedCornerShape(10.dp)
                    )
                    .padding(8.dp),
                model =
                when (transaksiData.donasiType) {
                    TipeDonasi.DANA -> R.drawable.dana_icon
                    TipeDonasi.BARANG -> R.drawable.barang_icon
                    else -> R.drawable.anabul_foundation
                },
                contentDescription = "",
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column{
                Row {
                    CompanyTag(companyName = transaksiData.namaMember, companyIcon = userData.avatar)
                    Spacer(modifier = Modifier.width(5.dp))
                    when (transaksiData.status) {
                        DonaturProgres.PROSES -> ProgresProses()
                        DonaturProgres.SELESAI -> ProgresSelesai()
                    }
                }
                Text(
                    text = transaksiData.title,
                    color = Neutral700,
                    style = Type.textXsSemiBold(),
                    modifier = Modifier.fillMaxWidth(.7f)
                )
            }
            Text(
                text =
                    when (transaksiData.donasiType) {
                        TipeDonasi.DANA -> "Rp ${formatLongWithDots(transaksiData.income)}"
                        TipeDonasi.BARANG -> "${formatLongWithDots(transaksiData.income)} pcs"
                        else -> transaksiData.income.toString()
                    },
                color = Primary900,
                style = Type.textSmSemiBold(),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }

}

@Composable
private fun ProgresProses() {
    Text(
        modifier = Modifier
            .border(1.dp, Warning900, RoundedCornerShape(5.dp))
            .padding(start = 5.dp, top = 1.dp, end = 5.dp),
        text = "Proses",
        color = Warning900,
        style = Type.text2xsRegular()
    )
}

@Composable
private fun ProgresSelesai() {
    Text(
        modifier = Modifier
            .border(1.dp, Primary900, RoundedCornerShape(5.dp))
            .padding(start = 5.dp, top = 1.dp, end = 5.dp),
        text = "Selesai",
        color = Primary900,
        style = Type.text2xsRegular()
    )
}