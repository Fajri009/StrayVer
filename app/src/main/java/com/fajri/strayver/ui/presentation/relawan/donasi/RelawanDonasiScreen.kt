package com.fajri.strayver.ui.presentation.relawan.donasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.relawan.donasi.component.RelawanDonasiContent
import com.fajri.strayver.ui.presentation.relawan.donasi.component.RelawanDonasiHead
import com.fajri.strayver.ui.theme.Primary700

@Composable
fun RelawanDonasiScreen(navController: NavController, viewModel: RelawanDonasiViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(
            model = R.drawable.ilustrasi,
            contentDescription = ""
        )
        Column {
            RelawanDonasiHead(viewModel)
            Spacer(modifier = Modifier.height(22.dp))
            RelawanDonasiContent(navController, viewModel)
        }
    }
}