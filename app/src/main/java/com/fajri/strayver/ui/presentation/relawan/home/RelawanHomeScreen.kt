package com.fajri.strayver.ui.presentation.relawan.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fajri.strayver.data.model.DonasiModelResponse
import com.fajri.strayver.ui.presentation.relawan.home.component.BuatProyek
import com.fajri.strayver.ui.presentation.relawan.home.component.DonasiCard
import com.fajri.strayver.ui.presentation.relawan.home.component.DonasiTerbaruItem
import com.fajri.strayver.ui.presentation.relawan.home.component.RelawanGreet
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Type

@Composable
fun RelawanHomeScreen(
    navController: NavController,
    viewModel: RelawanHomeViewModel = hiltViewModel()
) {
    val userData by viewModel.userData
    val donasiData by viewModel.donasiData

    LaunchedEffect(key1 = true) {
        viewModel.getUser()
        viewModel.getDonasiByUserId()
    }
    
    Column {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Box(Modifier.fillMaxWidth()) {
                    RelawanGreet(
                        Modifier
                            .fillMaxWidth()
                            .height(178.dp)
                            .clip(RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
                            .background(Primary700),
                        userData.item!!
                    )
                    DonasiCard(
                        Modifier
                            .align(Alignment.TopCenter)
                            .offset(y = 130.dp)
                            .padding(horizontal = 30.dp),
                        userData.item!!
                    )
                }
                Spacer(modifier = Modifier.height(100.dp))
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                ) {
                    BuatProyek(modifier = Modifier.fillMaxWidth(), navController)
                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Proyek Terbarumu",
                        style = Type.textMdSemiBold(),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            DonasiTerbaruList(navController, donasiData)
            item { 
                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}

fun LazyListScope.DonasiTerbaruList(navController: NavController, donasiList: List<DonasiModelResponse>) {
    items(donasiList) {
        DonasiTerbaruItem(navController, it.item!!)
    }
}