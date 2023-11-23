package com.fajri.strayver.ui.presentation.member.kirim_donasi

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.component.CustomButton
import com.fajri.strayver.ui.presentation.component.LoadingDialog
import com.fajri.strayver.ui.presentation.member.kirim_donasi.component.FormBarang
import com.fajri.strayver.ui.presentation.member.kirim_donasi.component.KirimDonasiViewModel
import com.fajri.strayver.ui.presentation.member.kirim_donasi.component.MetodePembayaran
import com.fajri.strayver.ui.theme.Neutral50
import com.fajri.strayver.ui.theme.Primary700
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.ButtonType
import com.fajri.strayver.util.Route

@Composable
fun KirimDonasiScreen(
    navController: NavController,
    viewModel: KirimDonasiViewModel = hiltViewModel()
) {

    if (viewModel.isLoading.value) {
        LoadingDialog()
    }

    val type = "barang"
    val context = LocalContext.current

    when (type) {
        "dana" -> KirimDana(navController, context, viewModel)
        "barang" -> KirimBarang(navController, context, viewModel)
    }
}

@Composable
private fun KirimDana(navController: NavController, context: Context, viewModel: KirimDonasiViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(model = R.drawable.ilustrasi, contentDescription = "")
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Route.DETAIL_DONASI)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "",
                    tint = Shades50
                )
            }
            Text(text = "Donasi Dana", style = Type.displayXsSemiBold(), color = Shades50)

        }
        Column(Modifier.align(Alignment.TopStart)) {
            Spacer(modifier = Modifier.height(40.dp))
            MetodePembayaran(
                navController,
                Modifier
                    .padding(top = 60.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Neutral50)
                    .padding(20.dp)
            )
        }

        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 20.dp, vertical = 40.dp)
        ) {
            CustomButton(onClick = { navController.navigate(Route.MEMBER_RIWAYAT) }, text = "Kirim", type =
            ButtonType.LARGE)
        }
    }
}

@Composable
private fun KirimBarang(navController: NavController, context: Context, viewModel: KirimDonasiViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Primary700)
    ) {
        AsyncImage(model = R.drawable.ilustrasi, contentDescription = "")
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Route.DETAIL_DONASI)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "",
                    tint = Shades50
                )
            }
            Text(text = "Donasi Barang", style = Type.displayXsSemiBold(), color = Shades50)

        }
        Column(Modifier.align(Alignment.TopStart)) {
            Spacer(modifier = Modifier.height(40.dp))
            FormBarang(
                navController = navController,
                context = context,
                viewModel= viewModel,
                Modifier
                    .padding(top = 60.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Neutral50)
                    .padding(20.dp)
            )
        }
    }
}