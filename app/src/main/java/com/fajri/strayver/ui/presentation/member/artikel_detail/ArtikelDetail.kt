package com.fajri.strayver.ui.presentation.member.artikel_detail

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.util.Route

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
                }
        )
        IconButton(
            onClick = {
                navController.popBackStack()
                navController.navigate(Route.MEMBER_HOME)
            },
            Modifier
                .padding(start= 10.dp, top = 50.dp)
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
        Column (Modifier.align(Alignment.TopCenter)) {
            Spacer(modifier = Modifier.height(200.dp))
            ArtikelContent()
        }

    }
}