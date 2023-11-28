package com.fajri.strayver.ui.presentation.component.detailRiwayat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.LoadingDialog
import com.fajri.strayver.ui.presentation.relawan.detailRiwayat.component.DetailRiwayatContent
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route

@Composable
fun DetailRiwayatScreen(
    navController: NavController,
    transaksiId: String,
    viewModel: DetailRiwayatViewModel= hiltViewModel()
) {

    val transaksi by viewModel.transaksi
    val role by viewModel.role


    LaunchedEffect(key1 = true, block = {
        viewModel.getTransaksiById(transaksiId)
        viewModel.getRole()
    })

    if (viewModel.isLoading.value) {
        LoadingDialog()
    }

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
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.height(35.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement =
                Arrangement.spacedBy(0.dp)
            ) {
                IconButton(onClick = {
                    navController.popBackStack()
                    navController.navigate(Route.MEMBER_RIWAYAT)
                }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIos,
                        contentDescription = "",
                        tint = Shades50,
                    )
                }
                Text(
                    modifier = Modifier.padding(20.dp),
                    text = "Detail Riwayat",
                    color = Color.White,
                    style = Type.displayXsSemiBold()
                )
            }
            DetailRiwayatContent(transaksi, role)
        }
    }
}