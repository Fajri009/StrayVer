package com.fajri.strayver.ui.presentation.relawan.home.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.theme.Neutral900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type
import com.fajri.strayver.util.Route
import com.fajri.strayver.util.TipeDonasi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemplateBuatProyek(
    type: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .width(165.dp)
            .height(170.dp),
        onClick = { navController.navigate(Route.BUAT_PROYEK + "?type=${type}") },
        elevation = CardDefaults.cardElevation(5.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    when (type) {
                        TipeDonasi.DANA -> Brush.verticalGradient(listOf(Color(0xFFEE7180), Color(0xFFFDECEE)))
                        TipeDonasi.BARANG -> Brush.verticalGradient(listOf(Color(0xFF02C0E5), Color(0xFFD9F9FF)))
                        else -> { Brush.verticalGradient(listOf(Color.White, Color.Black)) }
                    }
                )
                .padding(top = 10.dp),
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = "Proyek Donasi $type",
                style = Type.textSmSemiBold(),
                color = Shades50,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Canvas(
                    modifier = Modifier
                        .size(150.dp)
                        .offset(x = 30.dp,y = 40.dp)
                ) {
                    drawOval(
                        color = Shades50
                    )
                }
                AsyncImage(
                    model =
                        when (type) {
                            TipeDonasi.DANA -> R.drawable.money
                            TipeDonasi.BARANG -> R.drawable.barang
                            else -> {}
                        },
                    contentDescription = "",
                    modifier = Modifier
                        .size(120.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomEnd)
                        .padding(end = 10.dp)
                )
            }
        }
    }
}