package com.fajri.strayver.ui.presentation.relawan.riwayat.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fajri.strayver.ui.presentation.relawan.riwayat.RelawanRiwayatViewModel
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun RelawanRiwayatContent(navController: NavController, viewModel: RelawanRiwayatViewModel = hiltViewModel()) {
    val tabTitle = listOf("Semua", "Dana", "Barang")

    var type by remember {
        mutableStateOf("Semua")
    }

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
                        type = tab
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
            item {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier
                            .background(
                                Primary100,
                                RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                            )
                            .padding(top = 2.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                        text = "21 September 2023",
                        color = Primary900,
                        style = Type.text2xsSemiBold()
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    RelawanRiwayatKategoriData1(navController)
                }
            }

            item {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        modifier = Modifier
                            .background(
                                Primary100,
                                RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                            )
                            .padding(top = 2.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                        text = "21 September 2023",
                        color = Primary900,
                        style = Type.text2xsSemiBold()
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    RelawanRiwayatKategoriData1(navController)
                }
            }

            item {
                Spacer(modifier = Modifier.height(55.dp))
            }
        }
    }
}