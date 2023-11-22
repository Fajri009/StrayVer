package com.fajri.strayver.ui.presentation.member.riwayat.component

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ScrollableTabRow
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
import com.fajri.strayver.ui.presentation.member.riwayat.MemberRiwayatViewModel
import com.fajri.strayver.ui.theme.Neutral800
import com.fajri.strayver.ui.theme.Primary100
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Primary900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.google.accompanist.pager.pagerTabIndicatorOffset
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RiwayatContent(viewModel: MemberRiwayatViewModel) {

    val tabTitle = listOf("Dana", "Barang")
    var type by remember {
        mutableStateOf("Dana")
    }

    Column(
        Modifier
            .padding(top = 20.dp)
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
                        type= tab
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
        RiwayatItem(type = type.lowercase())
    }
}
