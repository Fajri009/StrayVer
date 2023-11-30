package com.fajri.strayver.ui.presentation.relawan.donasi.component

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
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.ui.presentation.component.NotFound
import com.fajri.strayver.ui.presentation.relawan.donasi.RelawanDonasiViewModel
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route
import com.fajri.strayver.util.TipeDonasi

@Composable
fun RelawanDonasiContent(navController: NavController, viewModel: RelawanDonasiViewModel) {
    val tabTitle = listOf(TipeDonasi.DANA, TipeDonasi.BARANG)
    val donasiData by viewModel.donasiData

    LaunchedEffect(key1 = viewModel.search.value) {
        viewModel.searchQuery()
        if (viewModel.search.equals("")) {
            viewModel.getDonasiByUserIdAndCategory()
        }
    }

    LaunchedEffect(key1 = viewModel.tipeDonasi.value) {
        viewModel.getDonasiByUserIdAndCategory()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Neutral50, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
    ) {
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
                            .padding(horizontal = 65.dp)
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

            Spacer(modifier = Modifier.height(15.dp))

            LazyColumn(
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                if (donasiData.isEmpty()) {
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(1f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            NotFound(message = "Tidak ada donasi")
                        }
                    }
                } else {
                    items(donasiData) {
                        RelawanDonasiCard(donasiData = it.item!!, navController = navController, viewModel)
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}
