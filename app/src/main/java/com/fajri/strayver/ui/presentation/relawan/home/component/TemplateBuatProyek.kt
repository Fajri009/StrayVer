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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fajri.strayver.ui.theme.Neutral900
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.ui.theme.Type

@Composable
fun TemplateBuatProyek(
    judul: String,
    image: Int,
    color1: Color,
    color2: Color
) {
    Card(
        modifier = Modifier
            .width(175.dp)
            .height(180.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(color1, color2)))
                .padding(top = 10.dp)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 10.dp),
                text = judul,
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
                    model = image,
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