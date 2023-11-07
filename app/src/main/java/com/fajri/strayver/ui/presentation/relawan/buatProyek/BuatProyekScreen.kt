package com.fajri.strayver.ui.presentation.relawan.buatProyek

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.relawan.buatProyek.component.BuatProyekContent
import com.fajri.strayver.ui.presentation.relawan.buatProyek.component.BuatProyekHead
import com.fajri.strayver.ui.theme.Primary700

@Composable
fun BuatProyekScreen(navController: NavController, viewModel: BuatProyekViewModel = hiltViewModel()) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(
            model = R.drawable.ilustrasi,
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )

        Column {
            Spacer(modifier = Modifier.height(20.dp))
            BuatProyekHead(navController)
            BuatProyekContent(viewModel)
        }
    }
}