package com.fajri.strayver.ui.presentation.relawan.riwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.ui.presentation.component.DateTag
import com.fajri.strayver.ui.presentation.component.NotFound
import com.fajri.strayver.ui.presentation.relawan.riwayat.RelawanRiwayatViewModel
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.TipeDonasi
import com.fajri.strayver.util.toDateString

@Composable
fun RelawanRiwayatContent(navController: NavController, viewModel: RelawanRiwayatViewModel) {
    val tabTitle = listOf("Semua", TipeDonasi.DANA, TipeDonasi.BARANG)
    val transaksiData by viewModel.transaksiData

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)
    ) {
        TabRow(
            selectedTabIndex = viewModel.currentTabIndex.value,
            modifier = Modifier.fillMaxWidth(),
            indicator = {
                TabRowDefaults.Indicator(
                    modifier = Modifier
                        .tabIndicatorOffset(it[viewModel.currentTabIndex.value])
                        .padding(horizontal = 50.dp)
                        .clip(CircleShape),
                    color = Primary700,
                    height = 4.dp
                )
            }
        ) {
            tabTitle.forEachIndexed { index, tab ->
                Tab(
                    selected = index == viewModel.currentTabIndex.value,
                    onClick = {
                        viewModel.setIndex(index)
                        viewModel.setTipeDonasi(tab)
                    },
                    text = {
                        Text(
                            text = tab,
                            style =
                                if (index == viewModel.currentTabIndex.value) Type.textSmSemiBold()
                                else Type.textSmMedium()
                        )
                    },
                    selectedContentColor = Primary900,
                    unselectedContentColor = Neutral800
                )
            }
        }

        LazyColumn() {
            if (transaksiData.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        NotFound(message = "Riwayat tidak ditemukan")
                    }
                }
            } else {
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                }
                items(transaksiData.size) {
                    // Jika riwayatnya cuman 1
                    if (it == 0) {
                        DateTag(date = (transaksiData[it].item!!.tanggal).toDateString())
                        Spacer(modifier = Modifier.height(5.dp))
                        RelawanRiwayatCard(
                            transaksi = transaksiData[it].item!!, 
                            navController = navController
                        )
                    } else {
                        // Jika riwayat lain memiliki tanggal yang sama, dimulai dari it == transaksi.size
                        if ((transaksiData[it].item!!.tanggal).toDateString() == (transaksiData[it - 1].item!!.tanggal).toDateString()) {
                            RelawanRiwayatCard(
                                transaksi = transaksiData[it].item!!,
                                navController = navController
                            )
                        }
                        // Jika berbeda, akan membuat kategori baru dengan tanggal yang berbeda
                        else {
                            Spacer(modifier = Modifier.height(20.dp))
                            DateTag(date = (transaksiData[it].item!!.tanggal).toDateString())
                            Spacer(modifier = Modifier.height(5.dp))
                            RelawanRiwayatCard(
                                transaksi = transaksiData[it].item!!,
                                navController = navController
                            )
                        }
                    }
                }
            }

        }
    }
}
