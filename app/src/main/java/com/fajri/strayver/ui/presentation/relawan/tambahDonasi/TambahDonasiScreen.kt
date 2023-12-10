package com.fajri.strayver.ui.presentation.relawan.tambahDonasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.relawan.tambahDonasi.component.TambahDonasiContainerJudul
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.util.Route

@Composable
fun TambahDonasiScreen(
    navController: NavController,
    donasiId: String,
    viewModel: TambahDonasiViewModel = hiltViewModel()
) {
    val donasiData by viewModel.donasiData

    val colors = listOf(
        Color.Transparent,
        Color(red = 0f, green = 0f, blue = 0f, alpha = .55f)
    )

    LaunchedEffect(key1 = true) {
        viewModel.getDonasiById(donasiId)
        viewModel.getTransaksiByIdDonasi(donasiId)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .drawWithContent {
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors),
                        blendMode = BlendMode.DstOut
                    )
                },
            model = donasiData.gambar,
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.padding(start = 10.dp, top = 50.dp)
        ) {
            Icon(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(red = 0f, green = 0f, blue = 0f, alpha = .55f))
                    .padding(6.dp),
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "",
                tint = Shades50,
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(230.dp))
            TambahDonasiContainerJudul(navController, donasiData, viewModel)
        }
    }
}