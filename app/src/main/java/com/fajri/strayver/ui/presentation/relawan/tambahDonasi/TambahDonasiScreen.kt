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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.fajri.strayver.R
import com.fajri.strayver.ui.presentation.relawan.tambahDonasi.component.TambahDonasiContainerJudul
import com.fajri.strayver.ui.theme.Shades50
import com.fajri.strayver.util.Route

@Composable
fun TambahDonasiScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = R.drawable.terbaru,
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
            TambahDonasiContainerJudul(navController)
        }
    }
}