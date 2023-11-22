package com.fajri.strayver.ui.presentation.member.donasi.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.member.donasi.MemberDonasiViewModel
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun DonasiContent(navController: NavController, viewModel: MemberDonasiViewModel) {
    Column(
        Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(30.dp))
            .background(Color.White)
            .padding(top = 0.dp)
    ) {
        val tabTitle = listOf("Dana", "Barang")
        var type by remember {
            mutableStateOf("Dana")
        }

        Column(
            Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Shades50)

        ) {
            TabRow(
                selectedTabIndex = viewModel.currTabIndex.value,
                modifier = Modifier.fillMaxWidth(),
                indicator = {
                    TabRowDefaults.Indicator(
                        modifier = Modifier
                            .tabIndicatorOffset(it[viewModel.currTabIndex.value])
                            .padding(horizontal = 65.dp)
                            .clip(CircleShape),
                        color = Primary700,
                        height = 4.dp
                    )
                }

            ) {
                tabTitle.forEachIndexed { index, tab ->
                    Tab(
                        selected = index == viewModel.currTabIndex.value,
                        onClick = {
                            viewModel.setIndex(index)
                            type = tab
                        },
                        text = {
                            Text(
                                text = tab,
                                style =
                                if (index == viewModel.currTabIndex.value) Type.textSmSemiBold()
                                else Type.textSmMedium(),
                            )
                        }, selectedContentColor = Primary900,
                        unselectedContentColor = Neutral800
                    )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))
            LazyColumn(Modifier.fillMaxSize()) {
                items(3) {
                    DonasiCard(
                        type = "Dana",
                        img = R.drawable.kucing_makan,
                        title = "Selamatkan ratusan kucing kelaparan di Kecamatan Tou",
                        companyName = "Anabul Foundation",
                        companyIcon = R.drawable.anabul_foundation,
                        progress = .45f,
                        value = 3258000,
                        navController
                    )
                }
            }
        }
    }
}