package com.fajri.strayver.ui.presentation.relawan.tambahDonasi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fajri.strayver.model.Donasi
import com.fajri.strayver.ui.presentation.component.CustomProgressBar
import com.fajri.strayver.ui.presentation.relawan.tambahDonasi.TambahDonasiViewModel
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral600
import com.fajri.strayver.ui.theme.Primary600
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Secondary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.TipeDonasi
import com.fajri.strayver.util.formatLongWithDots

@Composable
fun TambahDonasiContainerJudul(
    navController: NavController,
    donasiData: Donasi,
    viewModel: TambahDonasiViewModel
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Neutral50)
    ) {
        Column {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = donasiData.title,
                    color = Primary900,
                    style = Type.textLgSemiBold()
                )
                Spacer(modifier = Modifier.height(12.dp))
                CustomProgressBar(progress = donasiData.donasiGain.toFloat() / donasiData.donasiGoal!!.toFloat())
                Spacer(modifier = Modifier.height(2.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Terkumpul",
                            color = Neutral600,
                            style = Type.text2xsRegular()
                        )
                        Text(
                            text =
                                when(donasiData.category) {
                                    TipeDonasi.DANA -> "Rp ${formatLongWithDots(donasiData.donasiGain)}"
                                    TipeDonasi.BARANG -> "${formatLongWithDots(donasiData.donasiGain)} barang"
                                    else -> "-"
                                },
                            color = Secondary900,
                            style = Type.textXsSemiBold()
                        )
                    }
                    Text(
                        text =
                            when(donasiData.category) {
                                TipeDonasi.DANA -> "dari Rp ${formatLongWithDots(donasiData.donasiGoal!!)}"
                                TipeDonasi.BARANG -> "dari ${formatLongWithDots(donasiData.donasiGoal!!)} barang"
                                else -> "-"
                            },
                        color = Neutral600,
                        style = Type.text2xsRegular()
                    )
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Primary600)
            ) {
                Column {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp),
                        text = "Donatur",
                        color = Shades50,
                        style = Type.textMdSemiBold(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TambahDonasiContainerDonatur(navController, viewModel)
                }
            }
        }
    }
}