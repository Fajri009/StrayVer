package com.fajri.strayver.ui.presentation.member.artikel_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.R.drawable.artikel_sasha
import com.fajri.strayver.ui.presentation.member.artikel_detail.component.ArtikelContent

@Composable
fun ArtikelDetail(navController: NavController) {
    val colors = listOf(
        Color.Transparent,
        Color(red = 0f, green = 0f, blue = 0f, alpha = .55f)
    )

    Box(Modifier.fillMaxSize()) {
        AsyncImage(model = artikel_sasha,
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .graphicsLayer { alpha = 1f }
                .drawWithContent {
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(colors),
                        blendMode = BlendMode.DstOut
                    )
                })
        Column (Modifier.align(Alignment.TopCenter)) {
            Spacer(modifier = Modifier.height(200.dp))
            ArtikelContent()
        }

    }
}