package com.fajri.strayver.ui.presentation.relawan.riwayat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.relawan.riwayat.component.RelawanRiwayatContent
import com.fajri.strayver.ui.presentation.relawan.riwayat.component.RelawanRiwayatHead
import com.fajri.strayver.ui.theme.Primary700

@Composable
fun RelawanRiwayatScreen(navController: NavController, viewModel: RelawanRiwayatViewModel = hiltViewModel()) {
    LaunchedEffect(key1 = viewModel.search.value) {
        viewModel.searchQuery()
    }

    LaunchedEffect(key1 = viewModel.tipeDonasi.value) {
        viewModel.getTransaksiByIdRelawan()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary700),
    ) {
        AsyncImage(
            model = R.drawable.ilustrasi,
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Column {
            RelawanRiwayatHead(viewModel)
            Spacer(modifier = Modifier.height(22.dp))
            RelawanRiwayatContent(navController, viewModel)
        }
    }
}