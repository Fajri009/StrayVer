package com.fajri.strayver.ui.presentation.member.detail_donasi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.member.detail_donasi.component.DetailContent
import com.fajri.strayver.ui.theme.Neutral900
import com.fajri.strayver.ui.theme.Shades100
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.util.Route

@Composable
fun DetailDonasiScreen(navController: NavController) {

    val colors = listOf(
        Color.Transparent,
        Color(red= 0f, green = 0f, blue = 0f, alpha = .55f)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = R.drawable.kucing_makan,
            contentDescription = "",
            Modifier
                .graphicsLayer { alpha = 1f }
                .drawWithContent {
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors),
                        blendMode = BlendMode.DstOut
                    )
                }
        )

        IconButton(
            onClick = {
                navController.popBackStack()
                navController.navigate(Route.MEMBER_DONASI)
            },
            Modifier
                .padding(12 .dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "",
                tint = Shades50,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(red = 0f, green = 0f, blue = 0f, alpha = .55f))
                    .padding(6.dp)

            )
        }

        Column(Modifier.align(Alignment.TopStart)) {
            Spacer(modifier = Modifier.height(180.dp))
            DetailContent()
        }
    }
}