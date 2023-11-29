package com.fajri.strayver.ui.presentation.relawan.tambahDonasi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.ui.presentation.component.NotFound
import com.fajri.strayver.ui.presentation.relawan.tambahDonasi.TambahDonasiViewModel
import com.fajri.strayver.ui.theme.Shades50

@Composable
fun TambahDonasiContainerDonatur(
    navController: NavController,
    viewModel: TambahDonasiViewModel
) {
    val transaksiData by viewModel.transaksiData

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Shades50)
    ) {
        LazyColumn() {
            item {
                Spacer(modifier = Modifier.height(5.dp))
            }
            if (transaksiData.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        NotFound(message = "Tidak ada donatur")
                    }
                }
            } else {
                items(transaksiData) {
                    TambahDonasiItem(transaksiData = it.item!!, navController = navController)
                }
            }
        }
    }
}